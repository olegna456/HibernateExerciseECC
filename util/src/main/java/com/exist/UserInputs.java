package com.exist.util;

import java.util.*;

public class UserInputs {

	static Scanner console = new Scanner(System.in);

	public static String getString(String message) {
		boolean isValid = false;
		String input = "";
		do {
			System.out.print(message);
			input = console.nextLine();
			if(input.isEmpty()) {
				System.out.println(message + " cannot be empty.Try Again");
				// getString(message);
			} else {
				isValid = true;
			}
		}while(!isValid);
		return input;
	}

	public static int getIntInput(String message,int min,int max) {
		boolean isValid = false;
		int input = 0;
		do {
			System.out.print(message);
			input = Integer.parseInt(console.nextLine());
			if((input < min) || (input > max)) {
				System.out.println(message + " cannot be empty. Try Again");
				// getIntInput(message, min, max);
			}else {
				isValid = true;
			}
		}while(!isValid);	
		return input;
	}

	public static double getDoubleInput(String message) {
		boolean isValid = false;
		double input = 0;
		do {
			System.out.print(message);
			input = Double.parseDouble(console.nextLine());
			if(input < 0) {
				System.out.println(message + " cannot be empty. Try Again");
				// getDoubleInput(message);
			} else {
				isValid = true;
			}
		}while(!isValid);
		return input;
	}

	public static boolean getBooleanInput(String message) {
		boolean isValid = false;
		boolean emp = false;
		String input = "";
		do{
			System.out.print(message);
			input = console.nextLine();
			if(input.isEmpty()) {
				
			} else {
				isValid = true;
			}
		}while(!isValid);
		if(input == "true") {
			emp = true;
		} else {
			emp = false;
		}
		return emp;
	}




}