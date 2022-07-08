package com.projectpenguin.logviewer.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class HttpSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/api/**").authenticated()
                        .antMatchers("/api/login").permitAll())
                .logout()
                .logoutUrl("/api/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/api/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authenticationSuccessHandler())
                .failureUrl("/login?error");
        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://localhost"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "PATCH", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
