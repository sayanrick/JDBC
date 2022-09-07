package com.bank_management_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserDetailsDao {
	public static boolean accountCreation(UserDetails st) {
		boolean f = false;
		try {
			// jdbc code
			Connection con = ConnectionProvider.createC();
			// prepared statement
			PreparedStatement pst = con.prepareStatement("insert into user_details(accNo ,name, adharNo, address, amount) values (? ,?, ?, ?, ?)");
			// set the value of parameter
			pst.setLong(1, st.getAccNo());
			pst.setString(2, st.getName());
			pst.setLong(3, st.getAdharNo());
			pst.setString(4, st.getAddress());
			pst.setInt(5, st.getAmount());
			
			pst.executeUpdate();
			f = true;
		} catch(Exception e) {
			e.printStackTrace();

		}
		return f;

	}

	public static void showUserBalace() {

		try {
			Connection con = ConnectionProvider.createC();
			Statement st = con.createStatement();
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Account No: ");
			long accountNo = Long.parseLong(br.readLine());

			ResultSet set = st.executeQuery("select amount from user_details where accNo=" + accountNo);
			while(set.next()) {
				System.out.println("Available balance: "+set.getLong(1));
			}
			set.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println();
		}

	}
	
	public static void deposit() {
		try {
			Connection con = ConnectionProvider.createC();
			Statement st = con.createStatement();			
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Account No: ");
			long accountNo = Long.parseLong(br.readLine());
			System.out.println("Enter amount to be inserted: ");
			int userAmount = Integer.parseInt(br.readLine());
			
			ResultSet set = st.executeQuery("select amount from user_details where accNo=" + accountNo);
			while(set.next()) {
				long updatedAmount = (set.getLong(1)+userAmount);
				System.out.println("Available balance: "+set.getLong(1));
				System.out.println("Updated balance: "+updatedAmount);
				st.executeUpdate("update user_details set amount="+updatedAmount+" where accNo="+accountNo);
				System.out.println("Transaction successfull...");
				
			}
			set.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println();
		}
	}
	
	public static void withdrawal() {
		try {
			Connection con = ConnectionProvider.createC();
			Statement st = con.createStatement();			
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Account No: ");
			long accountNo = Long.parseLong(br.readLine());
			System.out.println("Enter amount to be withdrawn: ");
			int userAmount = Integer.parseInt(br.readLine());
			
			ResultSet set = st.executeQuery("select amount from user_details where accNo=" + accountNo);
			while(set.next()) {
				long updatedAmount = (set.getLong(1)-userAmount);
				System.out.println("Available balance: "+set.getLong(1));
				System.out.println("Updated balance: "+updatedAmount);
				st.executeUpdate("update user_details set amount="+updatedAmount+" where accNo="+accountNo);
				System.out.println("Transaction successfull...");
				
			}
			set.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println();
		}
	}
}

