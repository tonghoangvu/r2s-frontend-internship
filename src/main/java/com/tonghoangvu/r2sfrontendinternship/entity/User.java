package com.tonghoangvu.r2sfrontendinternship.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Must use for H2
	private Long id;

	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String description;
}
