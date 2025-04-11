package com.sam.productService.config.security;

import com.sam.productService.utils.GlobalUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    GlobalUtility globalUtility;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = extractToken(request);
        try {
            if (token != null && globalUtility.validateJwtToken(token)) {
                Authentication auth = globalUtility.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private String parseJwt(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String jwtToken = "";

        if (StringUtils.hasText(authorizationHeader) &&
                authorizationHeader.startsWith("Bearer "))
            jwtToken = authorizationHeader.substring(7);

        return jwtToken;
    }
}