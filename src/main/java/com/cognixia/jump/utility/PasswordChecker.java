package com.cognixia.jump.utility;

public class PasswordChecker {

	public static boolean check(String password) {
		if(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#%$^&*]).{8,}$")) return true;
		return false;
	}
}
