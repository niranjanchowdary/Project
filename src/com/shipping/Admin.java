package com.shipping;

public class Admin {
	// classs starts Here....
	private static final String ADMIN_NAME = "admin";// admin name
	private static final String ADMIN_PASS = "pass"; //admin password


	protected boolean ckeckAdmin(String name, String pass) {   //Checking admin details 
		if (ADMIN_NAME.equals(name) && ADMIN_PASS.equals(pass))
			return true;
		else
			return false;
	}

}
