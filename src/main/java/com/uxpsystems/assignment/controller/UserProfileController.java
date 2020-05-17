package com.uxpsystems.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.models.UserProfile;
import com.uxpsystems.assignment.models.UserProfileResponse;
import com.uxpsystems.assignment.service.UserProfileService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@PostMapping(value = "/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfileResponse> createProfile(@RequestBody UserProfile userProfile){
		UserProfileResponse profileResponse = userProfileService.createProfile(userProfile);
		return new ResponseEntity<UserProfileResponse>(profileResponse, HttpStatus.CREATED);
	}
	

	@GetMapping(value = "/profiles/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfileResponse> retrieveProfile(@PathVariable(name = "userId") Integer userId){
		UserProfileResponse profileResponse =userProfileService.retrieveProfile(userId);
		return new ResponseEntity<UserProfileResponse>(profileResponse, HttpStatus.OK);
	}
	
	@PutMapping(value = "/profiles/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfileResponse> updateProfile(@PathVariable(name = "userId") Integer userId, @RequestBody UserProfile userProfile){
		UserProfileResponse profileResponse = userProfileService.updateProfile(userId, userProfile);
		return new ResponseEntity<UserProfileResponse>(profileResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/profiles/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfileResponse> deleteProfile(@PathVariable(name = "userId") Integer userId){
		userProfileService.deleteProfile(userId);
		return new ResponseEntity<UserProfileResponse>(HttpStatus.NO_CONTENT);
	}
	
	
}
