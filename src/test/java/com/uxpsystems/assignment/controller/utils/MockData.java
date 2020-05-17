package com.uxpsystems.assignment.controller.utils;

import java.util.Optional;

import com.uxpsystems.assignment.models.UserProfile;
import com.uxpsystems.assignment.models.UserProfileResponse;

public class MockData {

	public static UserProfileResponse mockUserProfileResponse() {
		return new UserProfileResponse("address", "phoneNumber");
	}

	public static UserProfile mockUserProfile() {
		UserProfile userProfile = new UserProfile();
		userProfile.setUserId(101);
		userProfile.setAddress("address");
		userProfile.setPhoneNumber("11111111");
		return userProfile;
	}
	
	public static Optional<UserProfile> mockOptionalUserProfile(){
		return Optional.of(mockUserProfile());
	}

}
