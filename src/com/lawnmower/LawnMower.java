package com.lawnmower;

import com.lawnmower.enums.Direction;
import com.lawnmower.enums.Orientation;
import com.lawnmower.exceptions.DirectionNotFoundException;
import com.lawnmower.exceptions.OrientationNotFoundException;

public class LawnMower {
	
	 private Integer x;
	    private Integer y;
	    private char orientation;
	    private static Lawn lawn;
	    

	    public LawnMower(Integer x, Integer y, char orientation, Lawn lawn) {
	        this.x = x;
	        this.y = y;
	        this.orientation = orientation;
	        this.lawn = lawn;
	}
	    
	   
	    public Integer getX() {
			return x;
		}


		public void setX(Integer x) {
			this.x = x;
		}


		public Integer getY() {
			return y;
		}


		public void setY(Integer y) {
			this.y = y;
		}


		public char getOrientation() {
			return orientation;
		}


		public void setOrientation(char orientation) {
			this.orientation = orientation;
		}
		

		public static Lawn getLawn() {
			return lawn;
		}


		public static void setLawn(Lawn lawn) {
			LawnMower.lawn = lawn;
		}


		/**
		 * This method is used to analyze each moves of the lawmower
		 * 
		 * @param moves
		 * @throws OrientationNotFoundException
		 * @throws DirectionNotFoundException
		 */
		public void movesProcess(String moves) throws OrientationNotFoundException, DirectionNotFoundException{
	        char stepMoves[]= moves.toCharArray();
	        for(Character step : stepMoves) {
	            if (Direction.RIGHT.getChr()==step){
	            	toTheRightDirection();
	            }else if(Direction.LEFT.getChr()==step) {
	            	toTheLeftDirection();
	            }
	            else if(Direction.MOVING.getChr()==step){
	                movingForward();
	            }
	            else {
	            	throw new DirectionNotFoundException();
	            }
	        }
	    }

		/**
		 * This method is used if the lawnmower move is to the right direction
		 * 
		 * @throws OrientationNotFoundException
		 */
	    public void toTheRightDirection() throws OrientationNotFoundException{
	        	switch (this.orientation){
				case 'N': this.orientation = Orientation.EAST.getChr();
					break;
				case 'E': this.orientation = Orientation.SOUTH.getChr();
					break;
				case 'S': this.orientation = Orientation.WEST.getChr();
					break;
				case 'W': this.orientation = Orientation.NORTH.getChr();
					break;
				 default :
					 throw new OrientationNotFoundException();
				}
	        }
	    
		/**
		 * This method is used if the lawnmower move is to the left direction
		 * 
		 * @throws OrientationNotFoundException
		 */
		public void toTheLeftDirection() throws OrientationNotFoundException {
				switch (this.orientation) {
				case 'N': this.orientation = Orientation.WEST.getChr();
					break;
				case 'E': this.orientation = Orientation.NORTH.getChr();
					break;
				case 'S': this.orientation = Orientation.EAST.getChr();
					break;
				case 'W': this.orientation = Orientation.SOUTH.getChr();
					break;
				 default :
			        throw new OrientationNotFoundException();
				}
		}


		/**
		 * Method used if the lawnmower movement is to move forward
		 */
		    public void movingForward(){
		    	switch (this.orientation) {
				case 'N': if(this.y<lawn.getY())
						this.y++;
						break;
				case 'E': if(this.x<lawn.getX())
						this.x++;
						break;
				case 'S': if(this.y>0)
		                this.y--;
						break;
				case 'W': if(this.x>0)
		                this.x--;
						break;
		    	}
		    }
	   

	    @Override
	    public String toString() {
	        return   x +" "+ y +" "+ orientation;
	    }

}
