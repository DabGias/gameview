package br.com.gameview.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
            .oauth2Login(login -> login.loginPage("/login").permitAll().defaultSuccessUrl("/jogos", true))
            .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
        .build();
    }
}
