package com.example.securityproject.security;

import com.example.securityproject.domain.User;
import com.example.securityproject.domain.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser create(User user) {
        return new JwtUser(user,
                mapToGrantedAuthorities(user.getUserRoleSet())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<UserRole> userRoles) {
        return userRoles.stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getUserRoleId()))
                .collect(Collectors.toList());
    }
}
