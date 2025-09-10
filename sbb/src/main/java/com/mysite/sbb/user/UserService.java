package com.mysite.sbb.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public Siteuser create(String username, String email, String password) {
		Siteuser user = new Siteuser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		
		// Spring Security 등록
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		this.userRepository.save(user);
		
		return user;
		
	}
	

}
