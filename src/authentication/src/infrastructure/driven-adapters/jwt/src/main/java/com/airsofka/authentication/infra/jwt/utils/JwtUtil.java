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

@Component
public class JwtUtil {
  @Value("${security.jwt.secret}")
  private String secretKey;

  @Value("${security.jwt.issuer}")
  private String issuer;

  @Value("${security.jwt.ttlMillis}")
  private Long ttlMillis;

  private final Logger log = LoggerFactory.getLogger(JwtUtil.class);

  public String create(String id, String subject) {
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    JwtBuilder builder = Jwts.builder()
      .setId(id)
      .setIssuedAt(now)
      .setSubject(subject)
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

  public String getValue(String jwt) {
    Claims claims = Jwts.parserBuilder()
      .setSigningKey(getSigningKey())
      .build()
      .parseClaimsJws(jwt)
      .getBody();

    return claims.getSubject();
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
