package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import pkgException.PersonException;

import java.util.Date;

public class Staff_Test {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws PersonException {
		
		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		Calendar date = Calendar.getInstance();
		date.set(2000, 1, 2);
		
		Staff s1 = new Staff("A", "B", "C", date.getTime(), "Mars", "(111)-111-1111", "Email0", "", 1, 10000, date.getTime(), eTitle.MR);
		
		Staff s2 = new Staff("D", "E", "F", date.getTime(), "Venus", "(222)-222-2222", "Email1", "", 2, 20000, date.getTime(), eTitle.MRS);
		
		Staff s3 = new Staff("G", "H", "I", date.getTime(), "Moon", "(333)-333-3333", "Email2", "", 3, 30000, date.getTime(), eTitle.MR);
	
		Staff s4 = new Staff("J", "K", "M", date.getTime(), "Jupiter", "(444)-444-4444", "Email3", "", 4,40000, date.getTime(), eTitle.MR);
	
		Staff s5 = new Staff("N", "O", "P", date.getTime(), "Pluto", "(555)-555-5555", "Email4", "", 5, 50000, date.getTime(), eTitle.MR);
	
		StaffList.add(s1);
		StaffList.add(s2);
		StaffList.add(s3);
		StaffList.add(s4);
		StaffList.add(s5);
		
		double TotalSalary = 0;
		
		for (Staff staff : StaffList) {
			TotalSalary += staff.getSalary();
		}
		
		double AverageSalary = TotalSalary / 5;
		
		assertEquals(30000 , AverageSalary, 0);
	}
	
	@Test
	public void testException() throws PersonException {
		
		boolean testExceptionDeadPerson = false;
		boolean testExceptionWrongPhoneFormat = false;
		
		
		Calendar date = Calendar.getInstance();
		date.set(1901, 1, 1);
		// Test for dead person
		try {
			Staff s6 = new Staff("Q", "R", "S", date.getTime(), "Pluto", "(666)-666-6666", "Email4", "", 5, 50000, date.getTime(), eTitle.MR);
		} catch (PersonException e) {
			e.printStackTrace();
			testExceptionDeadPerson = true;
		}
		
		
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2000, 1, 1);
		
		
		// Test for incorrect phone number format
		try {
			Staff s6 = new Staff("Q", "R", "S", date2.getTime(), "Pluto", "9", "Email4", "", 5, 50000, date2.getTime(), eTitle.MR);
		} catch (PersonException e) {
			e.printStackTrace();
			testExceptionWrongPhoneFormat = true;
		}
		
		assertEquals(testExceptionDeadPerson, true);
		assertEquals(testExceptionWrongPhoneFormat, true);
		
	}

}
