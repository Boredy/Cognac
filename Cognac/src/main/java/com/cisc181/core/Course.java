package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;

	
	public Course(UUID courseID, String courseName, int gradePoints) {
		super();
		CourseID = courseID;
		CourseName = courseName;
		GradePoints = gradePoints;

	}


	public UUID getCourseID() {
		return CourseID;
	}


	public String getCourseName() {
		return CourseName;
	}


	public int getGradePoints() {
		return GradePoints;
	}
}
