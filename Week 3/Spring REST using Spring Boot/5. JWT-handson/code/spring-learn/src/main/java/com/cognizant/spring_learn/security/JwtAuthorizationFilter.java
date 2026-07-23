package com.cognizant.spring_learn.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    private static final String SECRET =
            "ThisIsASecretKeyForJwtSigningThatIsAtLeast32BytesLong!";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        LOGGER.info("Start JwtAuthorizationFilter");

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication =
                getAuthentication(header);

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);

        LOGGER.info("End JwtAuthorizationFilter");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String header) {

        try {

            String token = header.replace("Bearer ", "");

            Key key = Keys.hmacShaKeyFor(
                    SECRET.getBytes(StandardCharsets.UTF_8));

            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            String user = claims.getBody().getSubject();

            LOGGER.debug("User : {}", user);

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        Collections.emptyList());
            }

        } catch (JwtException e) {

            LOGGER.error("Invalid JWT");

        }

        return null;
    }
}