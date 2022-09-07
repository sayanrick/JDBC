package com.bank_management_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Execute {
	public static void main(String ...args) throws NumberFormatException, IOException {
		System.out.println("-------------BANK MANAGEMENT APP--------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("PRESS 1 TO OPEN A NEW ACCOUNT");
		System.out.println("PRESS 2 FOR BALANCE ENQUIRY");
		System.out.println("PRESS 3 FOR DEPOSIT");
		System.out.println("PRESS 4 FOR WITHDRAWAL");
		int input = Integer.parseInt(br.readLine());
		if(input == 1) {
			System.out.println("Enter Account No: ");
			long accNo = Long.parseLong(br.readLine());

			System.out.println("Enter Name: ");	
			String name = br.readLine();

			System.out.println("Enter Adhar No: ");	
			long adharNo =  Long.parseLong(br.readLine());

			System.out.println("Enter Address: ");	
			String address = br.readLine();

			System.out.println("Enter minimum balace to be inserted:: ");	
			int amount = Integer.parseInt(br.readLine());

			UserDetails st = new UserDetails(accNo, name, adharNo, address, amount);
			boolean ans = UserDetailsDao.accountCreation(st);
			if(ans) {
				System.out.println("Account created successfully....");
			} else {
				System.out.println("Something went wrong try again");
			}
			System.out.println(st);

		}
		else if (input == 2) {
			// available balance
			UserDetailsDao.showUserBalace();
		}
		else if (input == 3) {
			// deposit money
			UserDetailsDao.deposit();
		}
		else if (input == 4) {
			// withdraw money
			UserDetailsDao.withdrawal();
		}

	}

}
