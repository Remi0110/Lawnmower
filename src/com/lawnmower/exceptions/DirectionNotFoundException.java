package com.lawnmower.exceptions;

public class DirectionNotFoundException extends Exception{

	public DirectionNotFoundException() {
		System.out.println("Direction was not recognized");
	}
}