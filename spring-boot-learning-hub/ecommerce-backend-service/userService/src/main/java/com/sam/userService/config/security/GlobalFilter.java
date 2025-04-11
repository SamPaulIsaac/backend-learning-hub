package com.sam.userService.config.security;

import com.sam.userService.service.CustomUserDetailService;
import com.sam.userService.utils.GlobalUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.sam.userService.utils.GlobalConstants.*;


@Component
@Slf4j
public class GlobalFilter extends OncePerRequestFilter {
    @Autowired
    GlobalUtility globalUtility;
    @Autowired
    CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = parseJwt(request);
        try {
            if (jwtToken != null && globalUtility.validateJwtToken(jwtToken)) {
                String username = globalUtility.getUserNameFromJwtToken(jwtToken);
                UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            log.error(FILTER_ERROR_MESSAGE + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String jwtToken = "";

        if (StringUtils.hasText(authorizationHeader) &&
                authorizationHeader.startsWith(BEARER))
            jwtToken = authorizationHeader.substring(7);

        return jwtToken;
    }
}