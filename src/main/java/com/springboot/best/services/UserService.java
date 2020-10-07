package com.springboot.best.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.best.dao.UserRepository;
import com.springboot.best.model.User;

@Service
public class UserService {
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptEndcoder;
	
	public void saveUser(User user) {
		user.setPassword(bcryptEndcoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
}
