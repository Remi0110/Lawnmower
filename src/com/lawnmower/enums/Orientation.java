package com.lawnmower.enums;

public enum Orientation {
	
NORTH('N'),EAST('E'),WEST('W'),SOUTH('S');
	
	private final char chr;
	
	 Orientation(char chr){
		this.chr=chr;
	}

	public char getChr() {
		return chr;
	}

}
