 package com.sunbeam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentDto {
    private Long sId;
    private String sName;
    private String email;
    private String courseName; 
}



