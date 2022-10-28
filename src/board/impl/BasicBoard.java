package board.impl;

import java.util.Random;

import board.Board;
import board.Location;

/**
 * Implementation of Board interface with 10x10 grid and ship lengths 2,3,4,5
 * Initializes the board and places the ships at random non-overlapping locations 
 */
public class BasicBoard implements Board {
	
	static final int GRID_SIZE = 10;
	static final int[] SHIP_SIZE_ARR = new int[] {2,3,4,5};
	static final int HIT = -1;
	
	Random random;
	int[][] grid;
	int remainingShipCounts;
	
	public BasicBoard() {
		
		random = new Random();
		grid = new int[GRID_SIZE][GRID_SIZE];
		for(int i=0; i<SHIP_SIZE_ARR.length; i++) {
			remainingShipCounts+= SHIP_SIZE_ARR[i];
			setShip(i+1, SHIP_SIZE_ARR[i]);
		}
	}
	
	@Override
	public int getGridSize() {
		return GRID_SIZE;
	}
	
	/** randomly chooses coordinates and horizontal/vertical position 
	 * and sets the shipIndex on each cell where the ship is placed
	 * @param shipIndex
	 * @param length
	 */
	void setShip(int shipIndex, int length) {
		int row = 0;
		int col = 0;
		boolean isSpotEmpty = false;
		boolean isHorizontalPlacement = true;
		while(!isSpotEmpty) {
			isHorizontalPlacement = random.nextBoolean();
			int randomIndex1 = random.nextInt(GRID_SIZE - length); // to accommodate ship
			int randomIndex2 = random.nextInt(GRID_SIZE);
			
			// Note that randomIndex1 is the start index for ship length, so it will be assigned to 
			// row for vertical placement (ship expands over multiple columns)
			// or to column for horizontal placement (ship expands over multiple rows)
			
			if(isHorizontalPlacement) {
				row = randomIndex2;
				col = randomIndex1;
				isSpotEmpty = isHorizontalSpotEmpty(row, col, length);
			} else {
				row = randomIndex1;
				col = randomIndex2;
				isSpotEmpty = isVerticalSpotEmpty(row, col, length);
			}
		
		}
		if(isHorizontalPlacement) {
			placeShipHorizontally(row, col, length, shipIndex);
		} else {
			placeShipVertically(row, col, length, shipIndex);
			
		}
	}

	private void placeShipVertically(int row, int col, int length, int shipIndex) {
		for(int i=row; i<row+length; i++) {
			grid[i][col] = shipIndex;
		}
	}

	private void placeShipHorizontally(int row, int col, int length, int shipIndex) {
		for(int i=col; i<col+length; i++) {
			grid[row][i] = shipIndex;
		}
	}

	private boolean isVerticalSpotEmpty(int row, int col, int length) {
		for(int i=row; i<row+length; i++) {
			if(grid[i][col] != 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isHorizontalSpotEmpty(int row, int col, int length) {
		for(int i=col; i<col+length; i++) {
			if(grid[row][i] != 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean hit(Location location) {
		if(grid[location.getRow()][location.getColumn()] > 0) {
			grid[location.getRow()][location.getColumn()] = HIT;
			remainingShipCounts--;
			return true;
		}
		return false;
	}

	@Override
	public boolean isShipRemaining() {
		return remainingShipCounts > 0;
	}
	
}
