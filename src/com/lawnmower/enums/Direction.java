package com.lawnmower.enums;

public enum Direction {

	MOVING('A'),RIGHT('D'),LEFT('G');
	
	private final char chr;
	
	Direction(char chr){
		this.chr=chr;
	}

	public char getChr() {
		return chr;
	}
	
}
