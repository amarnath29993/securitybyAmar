package com.marlabs.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marlabs.model.User;
import com.marlabs.repo.UserRepo;
import com.marlabs.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Override
	public Integer saveuser(User user) {
		String pwd = user.getUserPassword();
		pwd = pwdEncoder.encode(pwd);
		user.setUserPassword(pwd);
		return userRepo.save(user).getUserId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserEmail(username);
		List<String> roles = user.getRoles();

		Set<GrantedAuthority> autority = new HashSet<>();

		for (String role : roles) {
			autority.add(new SimpleGrantedAuthority(role));
		}
		org.springframework.security.core.userdetails.User uob = new org.springframework.security.core.userdetails.User(
				username, user.getUserPassword(), autority);
		return uob;

	}

}
