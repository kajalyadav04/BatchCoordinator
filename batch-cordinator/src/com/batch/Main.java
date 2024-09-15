package com.batch;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.batch.entity.Address;
import com.batch.entity.Batches;
import com.batch.entity.Faculty;
import com.batch.exception.AdminLoginException;
import com.batch.exception.DuplicateEntryException;
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
					facultySignup(sc, facultyMap, facultyService);
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

	private static void facultySignup(Scanner sc , Map<String , Faculty> faculty, FacultyService facultyService) {

		System.out.println("Enter Following details");
		System.out.println("Enter Your First Name (last name don't bother)");
		String userName = sc.next();
		System.out.println("Create a password");
		String password = sc.next();
		System.out.println("Enter Your City");
		String city = sc.next();
		System.out.println("Enter Your State");
		String state = sc.next();
		System.out.println("Enter Your ZipCode");
		int zip = sc.nextInt();
		System.out.println("Enter a Landmark");
		String landmark = sc.next();
		Address address = new Address(city, zip, state, landmark);
		System.out.println("Enter Your Email");
		String email = sc.next();
		System.out.println("Enter Your Phone number");
		int phoneNumber = sc.nextInt();
		Faculty faculty1 = new Faculty(userName, password, email, phoneNumber, address);
        try {
            facultyService.signUp(faculty1, faculty);
        } catch (IOException | DuplicateEntryException e) {
			System.out.println(e.getMessage());
        }
    }

	private static void faculty() {

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
