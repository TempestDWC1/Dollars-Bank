package com.cognixia.jump.utility;

/*
 * ConsolePrinter is used to for single Responsibility
 * I will use this object to print to the console
 */

public final class ConsolePrinter {

	public <T> void print( T toConsole) {
		System.out.println(toConsole);
	}
}
