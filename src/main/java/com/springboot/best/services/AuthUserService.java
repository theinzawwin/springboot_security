package com.springboot.best.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.best.dao.UserHasPrivilegeRepository;
import com.springboot.best.dao.UserRepository;
@Service
public class AuthUserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private UserHasPrivilegeRepository userHasPrivilegeRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.springboot.best.model.User user=userRepository.findByName(username);
	
		//List<GrantedAuthority> authories=new ArrayList<GrantedAuthority>();
		List<GrantedAuthority> authories=userHasPrivilegeRepository.findByUserId(user.getId()).stream().map(g->{
			GrantedAuthority authority = new SimpleGrantedAuthority(g.getPrivileges().getCode());
			return authority;
		}).collect(Collectors.toList());
			
			
		UserDetails userDetails = (UserDetails)new User(user.getName(),
				user.getPassword(), authories);
		return userDetails;
	}

}
