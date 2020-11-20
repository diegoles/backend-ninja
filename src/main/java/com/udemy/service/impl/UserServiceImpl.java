package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.udemy.entity.User user = userRepository.findByUserName(userName);
        List<GrantedAuthority> authorities = buildAutorities(user.getUserRols());
        return buildUser(user, authorities);
    }

    private User buildUser(com.udemy.entity.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUserName(), user.getPassword(), user.getEnabled(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, authorities);
    }

    private List<GrantedAuthority> buildAutorities(Set<UserRole> userRols) {
        Set<GrantedAuthority> auths = new HashSet<>();
        userRols.forEach(x -> auths.add(new SimpleGrantedAuthority(x.getRole())));
        return new ArrayList<GrantedAuthority>(auths);
    }
}
