package com.airpremia.eosh.components.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtComponent jwtComponent;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");
        String uri = request.getRequestURI();
        List<String> permitUriList = List.of("/actuator", "/api/v1/authority/users");

        if (permitUriList.stream().anyMatch(uri::contains)) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = authorizationHeader.substring(7); // "Bearer "

        if (!jwtComponent.validateToken(jwtToken)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            return;
        }

        Authentication authentication = jwtComponent.getAuthentication(jwtToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
