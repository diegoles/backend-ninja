package com.udemy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_name", unique = true, nullable = false, length = 45)
    private String userName;

    @Column(name = "password", unique = false, nullable = false, length = 60)
    private String password;

    @Column(name = "enabled", unique = false, nullable = false)
    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserRole> userRols = new HashSet<>();

    public User() {
    }

    public User(String userName, String password, Boolean enabled) {
        super();
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String userName, String password, Boolean enabled, Set<UserRole> userRols) {
        super();
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.userRols = userRols;
    }

}
