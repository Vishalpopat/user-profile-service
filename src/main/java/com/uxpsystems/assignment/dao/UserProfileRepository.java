package com.uxpsystems.assignment.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.uxpsystems.assignment.models.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>{

	Optional<UserProfile> findByUserId(Integer userId);
	
}
