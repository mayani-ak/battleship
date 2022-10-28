package player.impl;

import board.Board;
import board.Location;
import player.Player;

public abstract class AbstractPlayer implements Player {
	
	Board board;
	
	
	protected AbstractPlayer(Board board) {
		this.board = board;
	}
	
	@Override
	public boolean isHit(Location location) {
		return board.hit(location);
	}

}
