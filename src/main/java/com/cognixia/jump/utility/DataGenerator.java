package com.cognixia.jump.utility;

import java.util.ArrayList;

import com.cognixia.jump.model.Customer;

/*
 * This class is just used for creating testing data for use
 */

public class DataGenerator {

	public static ArrayList<Customer> testingDataList(){
		ArrayList<Customer> testCustomers = new ArrayList<>();
		testCustomers.add(new Customer("Max", "maxmax", "maxmaxmax", (float) 400));
		testCustomers.add(new Customer("Mary", "marymary", "marymarymary", (float) 100));
		testCustomers.add(new Customer("Dav", "davdavdav", "davdavdav", (float) 1000));
		testCustomers.add(new Customer("jackson", "jacksonjackson", "jacksonjackson", (float) 200.35));
		return testCustomers;
	}
}
