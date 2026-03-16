package com.tms.springboottms.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtService {

  private final SecretKey key = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey123".getBytes());

  public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
        .signWith(SignatureAlgorithm.HS256, key)
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

  private Claims extractAllClaims(String token) {

    return Jwts.parser()
        .setSigningKey(key)
        .parseClaimsJws(token)
        .getBody();
  }
}