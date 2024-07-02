package com.sunbeam.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class UpdateCourse {

	
	
	private LocalDate startDate;

	private LocalDate endDate;

	private double fee;

}
