package com.tms.springboottms.security;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
/**
 * [STARTUP] Security entry point — runs once when the app starts.
 * <pre>
 *   1. /auth/** → public
 *   2. everything else → must be authenticated (JWT validated by {@link JwtFilter})
 *   3. exposes PasswordEncoder + AuthenticationManager beans for login
 * </pre>
 */
@Configuration
// @EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/users/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/tasks/**").hasRole("ADMIN")
                .anyRequest().authenticated())

           .exceptionHandling(ex -> ex
            .authenticationEntryPoint((req, res, e) -> {
                returnBody(res, 401, "Unauthorized");
            })
            .accessDeniedHandler((req, res, e) -> {
                returnBody(res, 403, "Access Denied");
            }))
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /** Used at register (encode) and login (matches) via DaoAuthenticationProvider. */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** Exposes Spring's manager so {@link com.tms.springboottms.service.impl.AuthServiceImpl} can call authenticate() at login. */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    private void returnBody(HttpServletResponse res, int code, String message) throws IOException {
        res.setStatus(code);
        res.setContentType("application/json");
        res.getWriter().write("{\"status\":" + code + ",\"data\":\"" + message + "\"}");
    }

}
