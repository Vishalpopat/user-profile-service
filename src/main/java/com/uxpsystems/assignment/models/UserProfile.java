package com.uxpsystems.assignment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserProfile {

	@Id
	@GeneratedValue
	private Integer Id;
	
	private String address;
	
	private String phoneNumber;
	
	private Integer userId;

}

