package com.cognixia.jump.utility;

/*
 * ConsolePrinter is used to for single Responsibility
 * I will use this object to print to the console
 */

public final class ConsolePrinter {

	public <T> void print( T toConsole) {
		System.out.println(toConsole);
	}
	
	public <T> void print( T toConsole, String color) {
		
		color = color.toLowerCase();
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_BLUE = "\u001B[34m";
		final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		final String ANSI_RESET = "\u001B[0m";
		
		switch (color){
		case "red":
			System.out.println(ANSI_RED + toConsole + ANSI_RESET);
			break;
		case "blue":
			System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLUE + toConsole + ANSI_RESET);
			break;
		}
	}
	
}
