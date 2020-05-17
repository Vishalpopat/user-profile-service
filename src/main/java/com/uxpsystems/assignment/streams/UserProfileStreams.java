package com.uxpsystems.assignment.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserProfileStreams {


	String INPUT = "user-profile-in";
	
	@Input(INPUT)
	SubscribableChannel userProfileListener();
	
	
}
