package com.tms.springboottms.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  private final SecretKey key =
      Keys.hmacShaKeyFor("mysupersecretkeymysupersecretkeymysupersecretkey".getBytes());

  public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(key, SignatureAlgorithm.HS256)   // ✅ fixed
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