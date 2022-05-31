package com.antra.videomanager.security.factory;

import com.antra.videomanager.domain.entity.User;
import com.antra.videomanager.domain.entity.UserRole;
import com.antra.videomanager.security.pojo.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getUserRoleSet())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<UserRole> userRoles) {
        return userRoles.stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getRole_l().getRoleName()))
                .collect(Collectors.toList());
    }
}
