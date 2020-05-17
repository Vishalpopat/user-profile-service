package com.uxpsystems.assignment.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.HttpMethod;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.uxpsystems.assignment.models.UserProfile;
import com.uxpsystems.assignment.service.UserProfileService;
import com.uxpsystems.assignment.streams.UserProfileStreams;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class UserProfileListener {

	@Autowired
	UserProfileService userProfileService;

	@StreamListener(UserProfileStreams.INPUT)
	public void handleUserProfileChange(@Payload UserProfile userProfile,
			@Header(value = "requestType") String requestType, @Header(value = "userId") Integer userId) {
		log.info("Received userProfile: {}", userProfile);
		if (HttpMethod.PUT.toString().equalsIgnoreCase(requestType)) {
			userProfileService.updateProfile(userId, userProfile);
		} else if (HttpMethod.DELETE.toString().equalsIgnoreCase(requestType)) {
			userProfileService.deleteProfile(userId);
		}
	}

}
