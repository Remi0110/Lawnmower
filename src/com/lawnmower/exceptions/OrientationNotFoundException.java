package com.lawnmower.exceptions;

public class OrientationNotFoundException extends Exception{

	public OrientationNotFoundException() {
		System.out.println("orientation was not recognized");
	}

}