package com.clean.springbootstarter.services;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clean.springbootstarter.entity.UserEntity;
import com.clean.springbootstarter.model.User;
import com.clean.springbootstarter.repository.UserRepository;

@Service
public class CleanCityUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		UserEntity userEntity = userRepository.findByName(username);
		if(userEntity == null) {
			
			throw new UsernameNotFoundException(username);
		}
		User user = new User();
		user.setName(userEntity.getName());
		user.setPassword(userEntity.getPassword());
		user.setUserId(userEntity.getUserId());
		
		List<String> userRoles = Arrays.asList("ADMIN");
		return new CleanCityUserDetails(user,userRoles);
	}

}
