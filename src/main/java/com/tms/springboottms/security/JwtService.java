package com.tms.springboottms.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * [LOGIN + JWT] Creates and reads JWT tokens.
 * <pre>
 *   Login:    {@link #generateToken(String)}
 *   Filter:   {@link #extractUsername(String)} + {@link #isTokenValid(String, String)}
 * </pre>
 */
@Service
public class JwtService {

    private static final long TOKEN_TTL_MS = 1000 * 60 * 60; // 1 hour

    private final SecretKey key =
        Keys.hmacShaKeyFor("mysupersecretkeymysupersecretkeymysupersecretkey".getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + TOKEN_TTL_MS))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        return username.equals(extractUsername(token));
    }
}
