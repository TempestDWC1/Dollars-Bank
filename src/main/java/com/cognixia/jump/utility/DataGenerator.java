package com.cognixia.jump.utility;

import java.util.ArrayList;

import com.cognixia.jump.model.Customer;

/*
 * This class is just used for creating testing data for use
 */

public class DataGenerator {

	public static ArrayList<Customer> testingDataList(){
		ArrayList<Customer> testCustomers = new ArrayList<>();
		testCustomers.add(new Customer("Max", "maxmax", "Maxmax@1", (float) 400));
		testCustomers.add(new Customer("Mary", "marymary", "Marymary@2", (float) 100));
		testCustomers.add(new Customer("Dav", "davdavdav", "Davdav@3", (float) 1000));
		testCustomers.add(new Customer("jackson", "jacksonjackson", "Jacksonjackson@4", (float) 200.35));
		return testCustomers;
	}
}
