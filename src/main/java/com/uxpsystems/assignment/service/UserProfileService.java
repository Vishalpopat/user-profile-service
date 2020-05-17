package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.models.UserProfile;
import com.uxpsystems.assignment.models.UserProfileResponse;

public interface UserProfileService {

	UserProfileResponse createProfile(UserProfile userProfile);

	UserProfileResponse retrieveProfile(Integer userId);

	UserProfileResponse updateProfile(Integer userId, UserProfile userProfile);

	void deleteProfile(Integer userId);

}
