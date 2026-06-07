package com.tms.springboottms.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tms.springboottms.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * [LOGIN + JWT] Loads users from MySQL for Spring Security.
 * <pre>
 *   Called by:
 *     - DaoAuthenticationProvider at login (via AuthenticationManager)
 *     - {@link JwtFilter} on protected requests
 * </pre>
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var currentUser = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
            .username(currentUser.getUsername())
            .password(currentUser.getPassword())
            .roles(currentUser.getRole().name())
            .build();
    }
}
