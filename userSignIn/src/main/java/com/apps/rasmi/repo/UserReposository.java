package com.apps.rasmi.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apps.rasmi.entity.UserEntity;

@Repository
public interface UserReposository extends CrudRepository<UserEntity, Long>{

	UserEntity findUserByEmail(String emailId);
}
