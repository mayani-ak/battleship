package player.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import board.Board;
import board.Location;

public class RoboBasicPlayer extends AbstractPlayer {
		
	Random random;
	Set<String> usedLocations;
	public RoboBasicPlayer(Board board){
		super(board);
		random = new Random();
		usedLocations = new HashSet<>();
		
	}

	@Override
	public Location fire() {
		int row = random.nextInt(board.getGridSize());
		int col = random.nextInt(board.getGridSize());
		String key = row + "-" + col;
		while(usedLocations.contains(key)) {
			row = random.nextInt(board.getGridSize());
			col = random.nextInt(board.getGridSize());
			key = row + "-" + col;
		}
		
		usedLocations.add(key);
		return new Location(row, col);
	}

	
}
