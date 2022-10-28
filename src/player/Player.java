package player;

import board.Location;

public interface Player {
	
	/** 
	 * @param location to fire at on the board associated with the player
	 * @return true if there is a ship at the given location and it is not already hit
	 * <br> false otherwise
	 */
	boolean isHit(Location location);
	
	/** chooses coordinates to fire at
	 * @return location
	 */
	Location fire(); 
}
