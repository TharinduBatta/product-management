package com.practicle.product_management.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converts Keycloak JWT token roles into Spring Security Granted Authorities.
 * Keycloak stores roles inside the "realm_access" claim as a list.
 * This converter extracts those roles and maps them to Spring Security's role format
 */
public class JwtRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        var roles = jwt.getClaimAsMap("realm_access");
        if (roles == null || !roles.containsKey("roles")) {
            return List.of();
        }

        @SuppressWarnings("unchecked")
        var roleList = (List<String>) roles.get("roles");

        return roleList.stream()
                .map(role -> "ROLE_" + role.toUpperCase()) // Convert roles to Spring Security format
                .map(org.springframework.security.core.authority.SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
