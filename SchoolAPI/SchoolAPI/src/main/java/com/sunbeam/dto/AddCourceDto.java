package com.sunbeam.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sunbeam.entities.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class AddCourceDto {

   
	private String name;

	private Category category;

	private LocalDate startDate;

	private LocalDate endDate;

	private double fee;

	private String gradeToPass;

}
