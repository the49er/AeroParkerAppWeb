package com.techtask.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegistrationDto {

	private LocalDateTime registered;

	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@Size(min = 5, max = 50, message = "Email length should be in range 5-50 symbols")
	private String email;

	private String title;

	@Size(min = 2, max = 50, message = "This field cannot be empty. Min 2, max 255 symbols")
	private String firstName;

	@Size(min = 2, max = 50, message = "This field cannot be empty. Min 2, max 255 symbols")
	private String lastName;

	@Size(min = 8, max = 255, message = "This field cannot be empty. Min 8, max 255 symbols")
	private String addressLine1;

	private String addressLine2;

	private String city;

	@Size(min = 6, max = 10, message = "This field cannot be empty. Min 6, max 10 symbols")
	private String postcode;

	@Size(max = 20)

	private String phoneNumber;

	@Size(min = 8, max = 100, message = "Password length should be in range 8-100 symbols")
	private String password;
}
