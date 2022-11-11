package com.demo_jpa.service;

import com.demo_jpa.dao.UserDao;
import com.demo_jpa.entity.User;
import com.demo_jpa.securityconfig.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User u = userDao.findUserByUsername(username);
		System.out.println(u.getUsername() + "  " + u.getPassword());
		if(u==null){
			throw new UsernameNotFoundException("User not found");
		}
		return new SecurityUser(u);
		//return new org.springframework.security.core.userdetails.User(u.get().getUsername(),u.get().getPassword(),new ArrayList<>());
	//	return u.map(SecurityUser::new)
		//		.orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
	}


}
