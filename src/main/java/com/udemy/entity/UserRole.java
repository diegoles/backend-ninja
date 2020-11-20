package com.udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_rol", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "user_name"}))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id", unique = true, nullable = false)
    private Integer userRoleId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name", nullable = false)
    private User user;
    
    @Column(name="role", nullable = false, length = 45)
    private String role;
}
