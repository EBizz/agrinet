package com.agrownet.solutions.emarket.data.repository;

import javax.persistence.*;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.agrownet.solutions.emarket.data.model.User;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public User save(User account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		entityManager.persist(account);
		return account;
	}
	
	public User findByEmail(String email) {
		try {
			return entityManager.createNamedQuery(User.FIND_BY_EMAIL, User.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	
}
