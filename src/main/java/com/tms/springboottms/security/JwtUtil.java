package com.tms.springboottms.security;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    private final String SECRET = "secret_key";

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 36000))
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    }
    
    public String extractUsername(String token) {
        return Jwts.parser()
        .setSigningKey(SECRET)
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
    }
}

