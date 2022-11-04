package com.techtask.user.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class UserRegistrationDto {


	private LocalDate registered;

	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@NotEmpty(message = "Email cannot be empty")
	@Size(min = 5, max = 50, message = "Email length should be in range 5-50 symbols")
	private String email;

	private String title;

	@NotEmpty(message = "Cannot be empty")
	private String firstName;

	@NotEmpty(message = "Cannot be empty")
	private String lastName;

	@Size(min = 8, max = 255, message = "This field cannot be empty. Min 8, max 255 symbols")
	@NotEmpty
	private String addressLine1;

	private String addressLine2;

	private String city;

	@Size(min = 6, max = 10, message = "This field cannot be empty. Min 6, max 10 symbols")
	@NotEmpty
	private String postcode;

	private String phoneNumber;

	@Size(min = 8, max = 100, message = "Password length should be in range 8-100 symbols")
	@NotEmpty
	private String password;
}
