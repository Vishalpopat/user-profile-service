package com.uxpsystems.assignment.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserProfileRepository;
import com.uxpsystems.assignment.exception.UserProfileServiceException;
import com.uxpsystems.assignment.models.UserProfile;
import com.uxpsystems.assignment.models.UserProfileResponse;
import com.uxpsystems.assignment.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Override
	public UserProfileResponse createProfile(UserProfile userProfile) {
		 UserProfile profile = userProfileRepository.save(userProfile);
		 return convertToResponse(profile);
	}

	@Override
	public UserProfileResponse retrieveProfile(Integer userId) {
		Optional<UserProfile> profile = userProfileRepository.findByUserId(userId);
		if(profile.isPresent()) {
			return convertToResponse(profile.get());
		}
		return null;
	}

	@Override
	public UserProfileResponse updateProfile(Integer userId, UserProfile userProfile) {
		
		Optional<UserProfile> userProfileData = userProfileRepository.findByUserId(userId);
		
		if(userProfileData.isPresent()) {
			UserProfile existingUserProfile = userProfileData.get();
			existingUserProfile.setAddress(userProfile.getAddress());
			existingUserProfile.setPhoneNumber(userProfile.getPhoneNumber());
			UserProfile profile = userProfileRepository.save(existingUserProfile);
			return convertToResponse(profile);
		}else {
			throw new UserProfileServiceException("Profile does not exist", "1", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteProfile(Integer userId) {
		
		Optional<UserProfile> userProfileData = userProfileRepository.findByUserId(userId);
		if(userProfileData.isPresent()) {
			userProfileRepository.delete(userProfileData.get());
		}else {
			throw new UserProfileServiceException("Profile does not exist", "1", HttpStatus.NOT_FOUND);
		}
	}


	private UserProfileResponse convertToResponse(UserProfile profile) {
		return new UserProfileResponse(profile.getAddress(), profile.getPhoneNumber());
	}
	
}
