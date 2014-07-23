package com.agrownet.solutions.emarket.service;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.agrownet.solutions.emarket.data.model.User;
import com.agrownet.solutions.emarket.data.repository.UserRepositoryImpl;


public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepositoryImpl userRepository;
	
	@PostConstruct	
	protected void initialize() {
		userRepository.save(new User("user", "demo", "ROLE_USER"));
		userRepository.save(new User("admin", "admin", "ROLE_ADMIN"));
	}
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return createUser();
	}
	
	public void signin() {
		SecurityContextHolder.getContext().setAuthentication(authenticate());
	}
	
	private Authentication authenticate() {
		return new UsernamePasswordAuthenticationToken(createUser(), null, Collections.singleton(createAuthority()));		
	}
	
	private org.springframework.security.core.userdetails.User createUser() {
		return new org.springframework.security.core.userdetails.User("rao", passwordEncoder.encode("sudha"), Collections.singleton(createAuthority()));
	}

	private GrantedAuthority createAuthority() {
		return new SimpleGrantedAuthority("ROLE_USER");
	}
}
