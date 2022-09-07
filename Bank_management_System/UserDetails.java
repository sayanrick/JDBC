package com.bank_management_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetails {
	private long accNo;
	private String name;
	private long adharNo;
	private String address;
	private int amount;
}
	
