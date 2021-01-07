package com.apps.rasmi.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.apps.rasmi.ws.dto.UserDetailsDTO;

public interface UserDetailService extends UserDetailsService {
	
	
	public UserDetailsDTO createUser(UserDetailsDTO userDetailsDTO);
	
	public UserDetailsDTO getUser(String email);

}
