package com.batch.utility;

public class GenerateId {
	public static String generateFacIdString(String username) {
		int num = (int) (Math.random()*1000);
		return username + num;
	}
//	
//	public static void main(String[] args) {
//		String res = generateFacIdString("raj");
//		System.out.println(res);
//	}
 }
