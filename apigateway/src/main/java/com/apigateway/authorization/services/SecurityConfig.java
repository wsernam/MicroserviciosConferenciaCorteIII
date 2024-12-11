/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apigateway.authorization.services;

import java.util.Collection;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

/**
 *
 * @author Ashlee Campaz
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    JwtAuthenticationConverter authenticationConverter(
            Converter<Map<String, Object>, Collection<GrantedAuthority>> authoritiesConverter) {
        var authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
            return authoritiesConverter.convert(jwt.getClaims());
        });
        return authenticationConverter;
    }

    @Bean
    SecurityFilterChain resourceServerSecurityFilterChain(
            HttpSecurity http,
            Converter<Jwt, AbstractAuthenticationToken> authenticationConverter) throws Exception {

        http.oauth2ResourceServer(resourceServer -> {
            resourceServer.jwt(jwtDecoder -> {
                jwtDecoder.jwtAuthenticationConverter(authenticationConverter);
            });
        });

        http.sessionManagement(sessions -> {
            sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }).csrf(csrf -> {
            csrf.disable();
        });

        http.authorizeRequests()
            // Regla personalizada para validar el usuario en el endpoint
            .antMatchers("/EasyConference/Article/*").access("@customAuthorizationService.checkUsername(authentication, request)")
            .antMatchers("/EasyConference/Conference/*").access("@customAuthorizationService.checkUsername(authentication, request)")    
            // Otras reglas de autorización
            .antMatchers("/EasyConference/Conference/*").hasRole("user")
            .anyRequest().authenticated();

        return http.build();
    }
    
     private String extractUsernameFromToken(Object principal) {
        Jwt jwt = (Jwt) principal;
        return jwt.getClaim("preferred_username");
    }

}
