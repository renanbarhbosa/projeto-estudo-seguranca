package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // Desabilita a proteção contra ataques do tipo csrf.
        // Um ataque que grava dados na sessão,
        // o que gera uma vulnerabilidade que possibilita às pessoas a acessar os recursos da aplicação.
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Configura a permissão para
        // as minhas requisições.
        return http.build();
    }
}
