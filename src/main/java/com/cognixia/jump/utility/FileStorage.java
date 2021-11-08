package com.cognixia.jump.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileStorage {

	public void write(String toWrite) throws IOException {
		File file = new File("../src/main/resources/static/customer.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.append(toWrite);
		writer.close();
	}
	
	public ArrayList<String> read(){
		return null;
		
	}
	
}
