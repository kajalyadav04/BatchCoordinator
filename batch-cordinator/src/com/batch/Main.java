package com.batch;

import java.util.Map;
import java.util.Scanner;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;
import com.batch.exception.AdminLoginException;
import com.batch.exception.InvalidException;
import com.batch.exception.NullException;
import com.batch.service.BatchesService;
import com.batch.service.FacultyService;
import com.batch.service.serviceImpl.BatchesServiceImpl;
import com.batch.service.serviceImpl.FacultyServiceImpl;
import com.batch.utility.AdminPassword;
import com.batch.utility.FileCreation;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Map<String, Batches> batchesMap = FileCreation.batches();
		Map<String, Faculty> facultyMap = FileCreation.faculty();
		FacultyService facultyService = new FacultyServiceImpl();
		BatchesService batchesService = new BatchesServiceImpl();
		int input;

		System.out.println("Welcome to batch Management System");
		try {

			do {

				System.out.println("Enter Your Preferences, What do you want ," + "\n"
						+ "Press '1' -_-_-> For Admin Login" + "\n" + "Press '2' -_-_-> For Faculty Login ," + "\n"
						+ "Press '3' -_-_-> For Faculty SignUp ," + "\n" + "Press '0' -_-_-> For Existing the System. "
						+ "\n");
				input = sc.nextInt();
				switch (input) {
				case 1:
					admin(sc, facultyMap, facultyService,batchesMap,batchesService);
					break;
				case 2:
					faculty();
					break;
				case 3:
					facultySignup();
					break;
				case 0:
					System.out.println("Successfully Existed from the System");
					break;
				default:
					throw new InvalidException("invalid option selected");
				}
			} while (input != 0);
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());

		}

	}

	private static void facultySignup() {
		// TODO Auto-generated method stub

	}

	private static void faculty() {
		// TODO Auto-generated method stub

	}

	private static void admin(Scanner sc, Map<String, Faculty> faculty, FacultyService facultyService, Map<String, Batches> batchesMap, BatchesService batchesService ) {
		// TODO Auto-generated method stub

		boolean loginSuccess;
		try {
			loginSuccess = adminLogin(sc);
			int selectOption = 0;
			do {
				System.out.println("Press '1' ----- > to view all faculty" + "\n"
						+ "Press '2' ------ > to create new Course" + "\n" + "Press '3'-------> to view all Course"
						+ "\n" + "Press '4'-----> to delete a Course" + "\n"
						+ "Press '5' -----> to view a particular Course" + "\n"
						+ "Press '6' ------> to Update a particular Course" + "\n"
						+ "Press '7' ------> to Assign a faculty to a Course" + "\n"
						+ "Press '8' ------> to view all  batches to a Course" + "\n"
						+ "Press '0' ------> to Exit From Admin...");
				selectOption = sc.nextInt();
				switch (selectOption) {
				case 1:
					adminViewAllFaculties(faculty, facultyService);
					break;
				case 2 :
					adminCreateNewBatch(sc , batchesMap , batchesService);
					break;
				case 8:
					adminViewAllBatches(batchesMap,batchesService);
					break;
				default:
					throw new InvalidException("please select correct option");

				}

			} while (!(selectOption == 0));
		} catch (AdminLoginException e) {
			System.out.println(e.getMessage());
		}

//			System.out.println(loginSuccess);

	}

	private static void adminCreateNewBatch(Scanner sc, Map<String, Batches> batchesMap,
			BatchesService batchesService) {
		String string = null; 
		System.out.println("Enter Following details to Create a New Course");
		System.out.println("Enter a Unique ID :-");
		String id = sc.next();
		System.out.println("Enter Course Name :-");
		String courseName = sc.next();
		System.out.println("Enter Number of Seats for Course :- "+courseName);
		int noOfSeats = sc.nextInt();
		System.out.println("Enter a Start Date for Course :- "+courseName);
		String localDate = sc.next();
		System.out.println("Enter Duration for Course :- "+courseName);
		int duration = sc.nextInt();
		Batches newBatch = new Batches(id , courseName, noOfSeats, localDate , duration);
		batchesService.createNewBatch(batchesMap, newBatch);
		
	}

	private static void adminViewAllBatches(Map<String, Batches> batchesMap, BatchesService batchesService) {
		// TODO Auto-generated method stub
		try {
			batchesService.batchesViewAll(batchesMap);
		} catch (NullException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		
	}

	private static void adminViewAllFaculties(Map<String, Faculty> faculty, FacultyService facultyService) {
		// TODO Auto-generated method stub
		try {
			facultyService.adminViewAllFac(faculty);
		} catch (NullException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static Boolean adminLogin(Scanner a) throws AdminLoginException {
		System.out.println("Enter AdminLogin");
		System.out.println("Enter username");
		String usernameString = a.next();
		System.out.println("Enter password");
		String passwordString = a.next();
		if (usernameString.equals(AdminPassword.username) && passwordString.equals(AdminPassword.password)) {
			System.out.println("Successfully Login");
			return true;
		}
		throw new AdminLoginException("Invalid data");
	}

}
