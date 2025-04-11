package com.sam.orderService.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Configuration
public class GlobalUtility {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expiration;


    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static String getUser() {
        return "SAM PAUL ISAAC";
    }

    public boolean validateJwtToken(String jwtToken) throws Exception {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parse(jwtToken);
            return true;
        } catch (Exception e) {
            throw new Exception("Error occurred during jwt token validation: " + e.getLocalizedMessage());
        }
    }

    private SecretKey getSigningKey() {
        byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(key);
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
        String username = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(username, null, null);
    }

}
