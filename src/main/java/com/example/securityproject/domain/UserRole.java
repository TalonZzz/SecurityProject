package com.example.securityproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "userrole")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(generator = "user_role_UUID")
    @GenericGenerator(name = "user_role_UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "UserRoleId")
    private String userRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @Column(name = "RoleId", insertable = false, updatable = false)
    private Integer roleId;

}
