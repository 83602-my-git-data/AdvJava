package com.sunbeam.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Service;

import com.sunbeam.entities.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddStudentDto {

	private Long sId;

	private String sName;

	private String email;

	private String password;

	private Long id;

}
