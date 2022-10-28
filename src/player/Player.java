package player;

import board.Location;

public interface Player {
	boolean isHit(Location location);
	Location fire(); 
}
