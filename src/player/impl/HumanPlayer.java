package player.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.Board;
import board.Location;

public class HumanPlayer extends AbstractPlayer {
	
	Scanner scanner;
		
	public HumanPlayer(Board board) {
		super(board);
		scanner = new Scanner(System.in);
	}
	
	private boolean isValidColumn(int input) {
		return input > 0 && input <= board.getGridSize();
	}
	
	private boolean isValidLength(String str) {
		return str!= null && str.length() == 1;
	}
	
	private boolean isValidRow(String str) {
		return isValidLength(str) && str.charAt(0) >= 'A' 
				&& str.charAt(0) <= 'A' + board.getGridSize();
	}


	@Override
	public Location fire() {
		
		String row;
		do {
			System.out.println("Please enter row value between A to "+ (char)('A' + board.getGridSize() - 1) + " : ");
			row = scanner.next();
		} while(!isValidRow(row));
		
		int intRow = row.charAt(0) - 'A';
		
		int col = 0;
		while(!isValidColumn(col)) {
			System.out.println("Please enter column value between 1 to "+ board.getGridSize() + " : ");
			try {
				col = scanner.nextInt();
			} catch (InputMismatchException ex) {
				col = 0;
			}
		}
		
		return new Location(intRow, col - 1);
	}

}
