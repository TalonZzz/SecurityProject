package com.example.securityproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Table(name = "user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(generator = "user_UUID")
    @GenericGenerator(name = "user_UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UserId")
    private String userId;

    @Column(name = "UserName")
    private String username;

    @Column(name = "Password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRoleSet;

}
