package com.airsofka.authentication.infra.jwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
  @Value("${security.jwt.secret}")
  private String secretKey;

  @Value("${security.jwt.issuer}")
  private String issuer;

  @Value("${security.jwt.ttlMillis}")
  private Long ttlMillis;

  private final Logger log = LoggerFactory.getLogger(JwtUtil.class);

  public String create(String id, String subject, Map<String, Object> claims) {
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    JwtBuilder builder = Jwts.builder()
      .setId(id)
      .setSubject(subject)
      .setClaims(claims)
      .setIssuedAt(now)
      .setIssuer(issuer)
      .signWith(getSigningKey(), SignatureAlgorithm.HS256);

    if (ttlMillis >= 0) {
      long expMillis = nowMillis + ttlMillis;
      builder.setExpiration(new Date(expMillis));
    }

    return builder.compact();
  }

  private Key getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public String getValue(String jwt) {
    Claims claims = Jwts.parserBuilder()
      .setSigningKey(getSigningKey())
      .build()
      .parseClaimsJws(jwt)
      .getBody();

    return claims.getSubject();
  }

  public Map<String, Object> getClaims(String jwt) {
    return Jwts.parserBuilder()
      .setSigningKey(getSigningKey())
      .build()
      .parseClaimsJws(jwt)
      .getBody();
  }

  public String getKey(String jwt) {
    Claims claims = Jwts.parserBuilder()
      .setSigningKey(getSigningKey())
      .build()
      .parseClaimsJws(jwt)
      .getBody();

    return claims.getId();
  }
}
