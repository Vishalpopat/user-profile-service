package com.uxpsystems.assignment.config;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.uxpsystems.assignment.streams.UserProfileStreams;

@EnableBinding(UserProfileStreams.class)
public class UserProfileServiceConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}
}
