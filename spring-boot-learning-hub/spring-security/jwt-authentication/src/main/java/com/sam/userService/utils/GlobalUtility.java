package com.sam.userService.utils;


import com.sam.userService.service.CustomUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static com.sam.userService.utils.GlobalConstants.JWT_ERROR_MESSAGE;


@Component
public class GlobalUtility {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateJwtToken(Authentication authentication) {

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .subject(customUserDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey() {
        byte[] key = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(key);
    }

    public boolean validateJwtToken(String jwtToken) throws Exception {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parse(jwtToken);
            return true;
        } catch (Exception e) {
            throw new Exception(JWT_ERROR_MESSAGE + e.getLocalizedMessage());
        }
    }

    public String getUserNameFromJwtToken(String jwtToken) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(jwtToken).getPayload().getSubject();
    }
}
