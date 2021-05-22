package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Alien aln = repo.findByName(name);
		if(aln == null)
			throw new UsernameNotFoundException("Not Found");
		return new UserPrincpal(aln);
	}

}
