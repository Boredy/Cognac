package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

import pkgException.PersonException;

public class Student_Test {

	
	/*Add three Course records, add them to an ArrayList of Course
	Add two Semesters, one for Fall, one for Spring.  Add them to an ArrayList of Semester
	Add two Sections for each Course & Semester (total of six Sections).  Add them to an ArrayList of Section
	Create ten Student records, add them to an ArrayList of Student.

	Test Cases

	Enroll the ten students you created in each of the Sections you created.  Grade each student (pick your own grade values).

	Determine each student's GPA, test it with an assertEquals.
	Determine each course's average grade, test it with an assertEqual.
*/
	
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();
	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
	
	
	@BeforeClass
	public static void setup() throws PersonException {
		
		Calendar startDate1 = Calendar.getInstance();
		Calendar endDate1 = Calendar.getInstance();
		startDate1.set(2017, 8, 29);
		endDate1.set(2018, 5, 20);
		
		Calendar startDate2 = Calendar.getInstance();
		Calendar endDate2 = Calendar.getInstance();
		startDate2.set(2017, 8, 29);
		endDate2.set(2018, 5, 20);
		
		Course C1 = new Course(UUID.randomUUID(), "Chem", 10);
		Course C2 = new Course(UUID.randomUUID(), "Physics", 20);
		Course C3 = new Course(UUID.randomUUID(), "Geo", 30);
		
		courseList.add(C1);
		courseList.add(C2);
		courseList.add(C3);
		
		Semester s1 = new Semester(UUID.randomUUID(), startDate1.getTime(), endDate1.getTime()); 
		Semester s2 = new Semester(UUID.randomUUID(), startDate2.getTime(), endDate2.getTime());
		
		semesterList.add(s1);
		semesterList.add(s2);
		
		Section sec1 = new Section(C1.getCourseID(), s1.getSemesterID(), UUID.randomUUID(), 1);
		Section sec2 = new Section(C1.getCourseID(), s2.getSemesterID(), UUID.randomUUID(), 2);
		Section sec3 = new Section(C2.getCourseID(), s1.getSemesterID(), UUID.randomUUID(), 3);
		Section sec4 = new Section(C2.getCourseID(), s2.getSemesterID(), UUID.randomUUID(), 4);
		Section sec5 = new Section(C3.getCourseID(), s1.getSemesterID(), UUID.randomUUID(), 5);
		Section sec6 = new Section(C3.getCourseID(), s2.getSemesterID(), UUID.randomUUID(), 6);
		
		sectionList.add(sec1);
		sectionList.add(sec2);
		sectionList.add(sec3);
		sectionList.add(sec4);
		sectionList.add(sec5);
		sectionList.add(sec6);
		
		//generating 10 students
		for(int i = 0; i<10; i++) {
			studentList.add(new Student("FirstName" + i, "MiddleName" + i, "LastName" + i, 
					Calendar.getInstance().getTime(), eMajor.BUSINESS, "Address" + i, "(111)-111-1111", "Email" + i));						
		}
		
		double[][]grades={{98,90,96,95,92,93,90,97,94,100},
		 		  {86,93,96,88,85,89,83,87,99,94},
				  {85,76,78,80,81,84,82,86,93,95},
				  {95,78,80,75,89,69,70,84,92,85},
				  {78,98,84,89,50,78,79,85,99,100},
				  {89,90,99,98,90,75,89,74,90,84}};
		
		
		//setting the enrollment and adding the grades
		int column = 0;		
		for(Section sec : sectionList) {	
			int rowindex = 0;
			for(Student s : studentList) {				
				enrollmentList.add(new Enrollment(s.getStudentID(), sec.getSectionID()));
				enrollmentList.get(enrollmentList.size() -1).setGrade(grades[column][rowindex]);
				rowindex++;
			}
			column++;
		}		
	}

	@Test
	public void testGPA() {
		double firsttotal = 0;
		double secondtotal = 0;
		double thirdtotal = 0;
		double fourthtotal = 0;
		double fifthtotal = 0;
		double sixthtotal = 0;
		double seventhtotal = 0;
		double eightotal = 0;
		double ninethtotal = 0;
		double tenthtotal = 0;
		
		for(Enrollment e : enrollmentList) {
			
			if(e.getStudentID() == enrollmentList.get(0).getStudentID()) {
				firsttotal += e.getGrade();				
			}
			
			else if (e.getStudentID() == enrollmentList.get(1).getStudentID()) {
				secondtotal += e.getGrade();
			}
			else if (e.getStudentID() == enrollmentList.get(2).getStudentID()) {
				thirdtotal += e.getGrade();
			}
			else if (e.getStudentID() == enrollmentList.get(3).getStudentID()) {
				fourthtotal += e.getGrade();
			}
			else if (e.getStudentID() == enrollmentList.get(4).getStudentID()) {
				fifthtotal += e.getGrade();
			}
			else if (e.getStudentID() == enrollmentList.get(5).getStudentID()) {
				sixthtotal += e.getGrade();
			}
			else if (e.getStudentID() == enrollmentList.get(6).getStudentID()) {
				seventhtotal += e.getGrade();
			}
			else if (e.getStudentID() == enrollmentList.get(7).getStudentID()) {
				eightotal += e.getGrade();
			}
			else if (e.getStudentID() == enrollmentList.get(8).getStudentID()) {
				ninethtotal += e.getGrade();
			}
			else tenthtotal += e.getGrade();
			}
		
		// gpa formula: (total points / 6) /100 * 4 
		
		assertEquals((((firsttotal/6)/100)*4),3.54,0.1);
		assertEquals((((secondtotal/6)/100)*4),3.5,0.1);
		assertEquals((((thirdtotal/6)/100)*4),3.55,0.1);
		assertEquals((((fourthtotal/6)/100)*4),3.5,0.1);
		assertEquals((((fifthtotal/6)/100)*4),3.24,0.1);
		assertEquals((((sixthtotal/6)/100)*4),3.25,0.1);
		assertEquals((((seventhtotal/6)/100)*4),3.28,0.1);
		assertEquals((((eightotal/6)/100)*4),3.42,0.1);
		assertEquals((((ninethtotal/6)/100)*4),3.78,0.1);
		assertEquals((((tenthtotal/6)/100)*4),3.72,0.1);
	}
		
		
		
	
	@Test
	public void testCourseAVG() {
		
		double course1total = 0;
		double course2total = 0;
		double course3total = 0;
		for(int h = 0; h < 20; h++) {//the first 20 students are in section 1 and section 2 so therefore the same course, and so on
			course1total += enrollmentList.get(h).getGrade();
		}
		
		for(int v = 20; v < 40; v++ ) {
			course2total += enrollmentList.get(v).getGrade();
		}
		
		for(int x = 40; x < 60; x++) {
			course3total += enrollmentList.get(x).getGrade();
		}
		
		assertEquals(course1total/20, 92.25, 0);
		assertEquals(course2total/20, 82.85, 0);
		assertEquals(course3total/20, 85.9, 0);
		
	}
	
}