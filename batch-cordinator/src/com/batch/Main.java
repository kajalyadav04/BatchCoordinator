package com.batch;

import java.util.Map;
import java.util.Scanner;

import com.batch.entity.Batches;
import com.batch.entity.Faculty;
import com.batch.exception.AdminLoginException;
import com.batch.exception.InvalidException;
import com.batch.utility.AdminPassword;
import com.batch.utility.FileCreation;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Map<String, Batches> batchesMap =FileCreation.batches();
		Map<String, Faculty> facultyMap = FileCreation.faculty();
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
					admin(sc);
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

	private static void admin(Scanner sc) {
		// TODO Auto-generated method stub
		
			boolean loginSuccess;
			try {
				loginSuccess = adminLogin(sc);
			} catch (AdminLoginException e) {
				System.out.println(e.getMessage());
			}
//			System.out.println(loginSuccess);
		
		

	}
	public static Boolean adminLogin(Scanner a) throws AdminLoginException {
		System.out.println("Enter AdminLogin");
		System.out.println("Enter username");
		 String usernameString = a.next();
		 System.out.println("Enter password");
		 String passwordString = a.next();
		 if(usernameString.equals(AdminPassword.username)&&passwordString.equals(AdminPassword.password)) {
			 System.out.println("Successfully Login");
			 return true;
		 }
		throw new AdminLoginException("Invalid data"); 
	}

}
