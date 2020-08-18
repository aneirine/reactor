package com.aneirine.reactor.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfiguration {

    private  final AuthenticationManager authenticationManages;
    private  final SecurityContextRepository securityContextRepository;

    public WebSecurityConfiguration(AuthenticationManager authenticationManages, SecurityContextRepository securityContextRepository) {
        this.authenticationManages = authenticationManages;
        this.securityContextRepository = securityContextRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        return serverHttpSecurity.csrf()
                .disable()
                .formLogin()
               .authenticationManager()
                .securityContextRepository()
                .and()
                .httpBasic().disable()
                .authorizeExchange()
                .pathMatchers("/", "/login", "/favicon.ico").permitAll()
                .pathMatchers("/controller").hasRole("ADMIN")
                .anyExchange()
                .authenticated().and()
                .build();
    }

}
