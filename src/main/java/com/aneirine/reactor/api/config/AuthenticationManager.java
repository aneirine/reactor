package com.aneirine.reactor.api.config;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private final JWTUtil jwtUtil;

    public AuthenticationManager(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();

        String username;
        try {
            username = jwtUtil.extractUsername(authToken);
        } catch (Exception e) {
            username = null;
            e.printStackTrace();
        }

        if (username != null && jwtUtil.validateToken(authToken)) {
            Claims claimsFromToken = jwtUtil.getClaimsFromToken(authToken);
            List<String> list = claimsFromToken.get("role", List.class);
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = list.stream().map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    username, null, simpleGrantedAuthorities

            );
            return Mono.just(authenticationToken);
        } else return Mono.empty();


    }

}
