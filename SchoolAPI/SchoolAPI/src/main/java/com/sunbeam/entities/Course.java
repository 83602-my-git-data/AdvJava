package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name; // Corrected field name to lowercase 'name'

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "fee", nullable = false)
    private double fee;

    @Column(name = "grade_to_pass", nullable = false)
    private String gradeToPass; // Corrected field name to lowercase 'gradeToPass'

    // Constructors, getters, and setters are already included via Lombok annotations
}
