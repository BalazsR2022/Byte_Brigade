package com.geolidth.BackEnd.auth;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNullApi;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (isPublicEndpoint(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        // Authorization: Bearer rezrtz.drrg.fdg
        String auth = request.getHeader("Authorization");
        if (auth != null && auth.startsWith("Bearer ") && auth.length() > 7) {
            String token = auth.substring(7);

        }
        filterChain.doFilter(request, response);

    }

    public boolean isPublicEndpoint(HttpServletRequest request) {
        if (request.getMethod().equals("POST") && request.getServletPath().equals("/users")) {
            return true;
        }
        if (request.getMethod().equals("POST") && request.getServletPath().equals("/login")) {
            return  true;
        }
        return false;
    }
}
