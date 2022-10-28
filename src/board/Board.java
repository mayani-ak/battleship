package board;

public interface Board {	
	boolean hit(Location location);
	int getGridSize();
	boolean isShipRemaining();
}
