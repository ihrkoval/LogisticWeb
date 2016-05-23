package com.rosteach.security;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceIMPL implements UserDetailsService 
 {

	@Autowired
    private EntityManager entityManager; 
 

	
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		
		User user = new User();
		user.setPassword("1234");
		user.setLogin("admin");
		
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		
		
		if (user.getLogin().equals("admin")){
            roles.add(new SimpleGrantedAuthority(UserRole.ADMIN.name()));
            
        }
		
	   roles.add(new SimpleGrantedAuthority(UserRole.USER.name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                roles);
	
		return userDetails;
	}

}
