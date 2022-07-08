package com.projectpenguin.logviewer.configuration;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.config.ldap.LdapPasswordComparisonAuthenticationManagerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.springframework.security.ldap.authentication.PasswordComparisonAuthenticator;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class LDAPSecurityConfiguration {

    // @Bean
    // PasswordComparisonAuthenticator authenticator(BaseLdapPathContextSource contextSource) {
    //     PasswordComparisonAuthenticator authenticator = new PasswordComparisonAuthenticator(contextSource);
    //     authenticator.setUserSearch(new FilterBasedLdapUserSearch("ou=people,dc=springframework,dc=org", "(uid={0})", contextSource));
    //     authenticator.setUserDnPatterns(new String[] { "uid={0},ou=people" });
    //     return authenticator;
    // }

    // @Bean
    // LdapAuthenticationProvider authenticationProvider(LdapAuthenticator authenticator) {
    //     return new LdapAuthenticationProvider(authenticator);
    // }

    @Bean
    AuthenticationManager authenticationManager(BaseLdapPathContextSource contextSource) {
        LdapPasswordComparisonAuthenticationManagerFactory factory = new LdapPasswordComparisonAuthenticationManagerFactory(
                contextSource, new BCryptPasswordEncoder());
        factory.setUserSearchBase("ou=people,dc=springframework,dc=org");
        factory.setUserSearchFilter("(uid={0})");
        factory.setUserDnPatterns("uid={0},ou=people");
        factory.setPasswordAttribute("userPassword");  
        return factory.createAuthenticationManager();
    }

    // @Bean
    // AuthenticationManager authenticationManager(BaseLdapPathContextSource contextSource) {
    //     LdapBindAuthenticationManagerFactory factory = new LdapBindAuthenticationManagerFactory(contextSource, new BCryptPasswordEncoder());
    //     factory.setUserSearchFilter("(uid={0})");
    //     factory.setUserSearchBase("ou=people");
    //     return factory.createAuthenticationManager();
    // }

}