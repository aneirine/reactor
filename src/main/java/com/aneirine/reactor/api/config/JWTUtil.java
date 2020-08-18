package com.aneirine.reactor.api.config;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Base64;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String extractUsername(String authToken) {
        String key = Base64.getEncoder().encodeToString(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken)
                .getBody()
                .getSubject();

    }
}
