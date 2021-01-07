package com.apps.rasmi.userServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apps.rasmi.entity.UserEntity;
import com.apps.rasmi.repo.UserReposository;
import com.apps.rasmi.ws.dto.UserDetailsDTO;
import com.apps.rasmi.ws.dto.Utils;
import com.apps.rasmi.ws.service.UserDetailService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailService {

	@Autowired
	UserReposository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	Utils utils;

	@Override
	public UserDetailsDTO createUser(UserDetailsDTO userDetailsDTO) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDetailsDTO, userEntity);
		userEntity.setUserId(utils.generateUserId(20));
		userEntity.setEnCryptedPassword(bCryptPasswordEncoder.encode(userDetailsDTO.getPassword()));
		userEntity.setEmailVerificationToken("RASMI");
		UserEntity userEntity2 = userRepository.save(userEntity);
		UserDetailsDTO userDetailsDTO1 = new UserDetailsDTO();
		UserEntity userEntity3 = userRepository.findUserByEmail(userEntity2.getEmail());
		BeanUtils.copyProperties(userEntity3, userDetailsDTO1);
		return userDetailsDTO1;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity3 = userRepository.findUserByEmail(email);
		if(userEntity3==null)
			throw new UsernameNotFoundException(email);
		 return new User(userEntity3.getEmail(), userEntity3.getEnCryptedPassword(), new ArrayList<>());
	}

	@Override
	public UserDetailsDTO getUser(String email) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findUserByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		UserDetailsDTO returnValue = new UserDetailsDTO();
		BeanUtils.copyProperties(userEntity, returnValue);
 
		return returnValue;
	}

}
