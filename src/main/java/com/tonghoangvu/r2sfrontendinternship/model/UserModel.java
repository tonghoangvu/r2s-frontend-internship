package com.tonghoangvu.r2sfrontendinternship.model;

import com.tonghoangvu.r2sfrontendinternship.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
	private Long id;
	private String email;
	private String username;
	// private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String description;

	public UserModel(User user) {
		id = user.getId();
		email = user.getEmail();
		username = user.getUsername();
		// password = user.getPassword();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		phone = user.getPhone();
		description = user.getDescription();
	}
}
