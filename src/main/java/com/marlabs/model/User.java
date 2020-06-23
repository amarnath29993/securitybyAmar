package com.marlabs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private List<String> roles;

	public Integer getUserId() {
		return userId;
	}

}
