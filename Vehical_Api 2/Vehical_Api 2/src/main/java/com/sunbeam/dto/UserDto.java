package com.sunbeam.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	/*1) Uid (unique identifier for each User)
	2) Uname (Cannot be Blank)
	3) Email (Cannot be Blank)
	4) Password (Cannot be blank, min 6 characters)
	5) City (Cannot be Blank)
	6) Contact_No (Cannot be blank, min 10 digit)*/
	
	private Long uid;
	@NotEmpty(message = "User name can not be empty")
	private String uName;
	@Email(message = "Email should be vaild")
	@NotEmpty(message = "Email can not be blank")
	private String email;
	@NotEmpty(message = "Password can not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	@NotEmpty(message = "City can not be empty")
	private String city;
	 @NotEmpty(message = "Contact number can not be blank")
	 @Size(min = 10, message = "Contact number must be at least 10 digits")
	private String contactNo;
}
