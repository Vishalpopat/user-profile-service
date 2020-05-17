package com.uxpsystems.assignment.service.impl;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uxpsystems.assignment.controller.utils.MockData;
import com.uxpsystems.assignment.dao.UserProfileRepository;
import com.uxpsystems.assignment.exception.UserProfileServiceException;
import com.uxpsystems.assignment.models.UserProfile;
import com.uxpsystems.assignment.models.UserProfileResponse;

@ExtendWith(MockitoExtension.class)
public class UserProfileServiceImplTest {

	@Mock
	UserProfileRepository userProfileRepository;

	@InjectMocks
	UserProfileServiceImpl userProfileService;

	@Test
	void testCreateProfile() {
		Mockito.when(userProfileRepository.save(any())).thenReturn(MockData.mockUserProfile());
		UserProfileResponse createProfile = userProfileService.createProfile(MockData.mockUserProfile());
		Assertions.assertEquals("address", createProfile.getAddress());
	}

	@Test
	void testRetrieveProfile1() {
		Mockito.when(userProfileRepository.findByUserId(any())).thenReturn(MockData.mockOptionalUserProfile());
		UserProfileResponse retrieveProfile = userProfileService.retrieveProfile(1);
		Assertions.assertEquals("address", retrieveProfile.getAddress());
	}

	@Test
	void testRetrieveProfile2() {
		Optional<UserProfile> mockOptionalUserProfile = Optional.ofNullable(null);
		Mockito.when(userProfileRepository.findByUserId(any())).thenReturn(mockOptionalUserProfile);
		UserProfileResponse retrieveProfile = userProfileService.retrieveProfile(1);
		Assertions.assertNull(retrieveProfile);
	}

	@Test
	void testUpdateProfile1() {
		Optional<UserProfile> mockOptionalUserProfile = Optional.ofNullable(null);
		Mockito.when(userProfileRepository.findByUserId(any())).thenReturn(mockOptionalUserProfile);
		Assertions.assertThrows(UserProfileServiceException.class,
				() -> userProfileService.updateProfile(1, MockData.mockUserProfile()));
	}

	@Test
	void testUpdateProfile2() {
		Mockito.when(userProfileRepository.findByUserId(any())).thenReturn(MockData.mockOptionalUserProfile());
		Mockito.when(userProfileRepository.save(any())).thenReturn(MockData.mockUserProfile());
		UserProfileResponse updateProfile = userProfileService.updateProfile(1, MockData.mockUserProfile());
		Assertions.assertEquals("address", updateProfile.getAddress());
	}

	@Test
	void testDeleteProfile1() {
		Optional<UserProfile> mockOptionalUserProfile = Optional.ofNullable(null);
		Mockito.when(userProfileRepository.findByUserId(any())).thenReturn(mockOptionalUserProfile);
		Assertions.assertThrows(UserProfileServiceException.class, () -> userProfileService.deleteProfile(1));
	}

	@Test
	void testDeleteProfile2() {
		Mockito.when(userProfileRepository.findByUserId(any())).thenReturn(MockData.mockOptionalUserProfile());
		userProfileService.deleteProfile(1);
		Mockito.verify(userProfileRepository, times(1)).delete(Mockito.any());
	}

}
