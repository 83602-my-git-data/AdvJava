package com.sunbeam.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;

import com.sunbeam.entities.Company;
import com.sunbeam.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDto {
	@NotEmpty(message = "Vehicle name should not be empty")
	private String vName;
	private Company company;
	@NotEmpty(message = "Vehicle number can not be empty")
	private String vNumber;
	@NotEmpty(message = "Vechicle type must be specify")
	private String vType;
	private Long uid;
}
