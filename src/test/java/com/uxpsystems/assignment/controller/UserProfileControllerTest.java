package com.uxpsystems.assignment.controller;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.uxpsystems.assignment.controller.utils.MockData;
import com.uxpsystems.assignment.models.UserProfile;
import com.uxpsystems.assignment.models.UserProfileResponse;
import com.uxpsystems.assignment.service.UserProfileService;

@SpringBootTest
class UserProfileControllerTest {

	@Mock
	UserProfileService userProfileService;
	
	@InjectMocks
	UserProfileController userProfileController;
	
	@Test
	void createProfileTest() {
		Mockito.when(userProfileService.createProfile(any(UserProfile.class))).thenReturn(MockData.mockUserProfileResponse());
		ResponseEntity<UserProfileResponse> createProfile = userProfileController.createProfile(MockData.mockUserProfile());
		Assertions.assertEquals("address", createProfile.getBody().getAddress());
	}
	
	@Test
	void retrieveProfileTest() {
		Mockito.when(userProfileService.retrieveProfile(any(Integer.class))).thenReturn(MockData.mockUserProfileResponse());
		ResponseEntity<UserProfileResponse> retrieveProfile = userProfileController.retrieveProfile(101);
		Assertions.assertEquals("address", retrieveProfile.getBody().getAddress());
	}

}
