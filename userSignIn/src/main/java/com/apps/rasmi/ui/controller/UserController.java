package com.apps.rasmi.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.rasmi.ui.request.UserDetails;
import com.apps.rasmi.ui.response.UserRest;
import com.apps.rasmi.ws.dto.UserDetailsDTO;
import com.apps.rasmi.ws.service.UserDetailService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserDetailService userDetailService;
	
	@GetMapping
	public String getUser()
	{
		return "rasmita jena";
		
	}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetails userDetails)
	{
		UserDetails usDetails=new UserDetails();
		
		UserDetailsDTO userDetailDTO=new UserDetailsDTO();
		UserRest useResponse=new UserRest();
		
		BeanUtils.copyProperties(userDetails, userDetailDTO);
		userDetailDTO= userDetailService.createUser(userDetailDTO);
		
		BeanUtils.copyProperties(userDetailDTO, useResponse);
		
		return useResponse;
		
	}
}
