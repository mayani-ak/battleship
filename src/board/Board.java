package board;

public interface Board {	
	/**
	 * @param location to fire at
	 * @return true if there is a ship at the given location and it is not already hit
	 * <br> false otherwise
	 */
	boolean hit(Location location);
	
	/**
	 * @return number of rows in the board  
	 */
	int getGridSize();
	
	/** 
	 * @return true if any cell which has a part of ship and is not hit
	 * <br>false if all the cells containing ship are hit
	 */
	boolean isShipRemaining();
}
