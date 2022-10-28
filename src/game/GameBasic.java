package game;

import board.Board;
import board.Location;
import board.impl.BasicBoard;
import player.Player;
import player.impl.HumanPlayer;
import player.impl.RoboBasicPlayer;


public class GameBasic {
	private static final String WELCOME_MESSAGE = "Hi there! Welcome to Battleship! You are playing with a robo player.\n"
			+ "When asked, please choose a location between A 1 to J 10 to fire at opponent's board";
	
	public static void main(String[] args) {
		GameBasic game = new GameBasic();
		game.play();
	}
	
	void play() {
		Board humanBoard = new BasicBoard();
		Board roboBoard = new BasicBoard();
		Player human = new HumanPlayer(humanBoard);
		Player robot = new RoboBasicPlayer(roboBoard);

		System.out.println(WELCOME_MESSAGE);
		
		Location humanLocation, roboLocation;
		while(humanBoard.isShipRemaining() && roboBoard.isShipRemaining()) {
			delay(1000);
			System.out.println("\nYour turn, Please enter a hit location ");
			humanLocation = human.fire();
			
			if(robot.isHit(humanLocation)) {
				System.out.println("Yay, its a hit!");
			}else {
				System.out.println("Oops, it's a miss! Better luck next time..");
			}
			delay(2000);
			
			roboLocation = robot.fire();
			System.out.println("\nRobot selected location row = "+ (char)('A'+ roboLocation.getRow()) +" and column = "+ (roboLocation.getColumn()+1));
			delay(1000);
			if(human.isHit(roboLocation)) {
				System.out.println("Oh no.. Robot guessed it right!!");
			}else {
				System.out.println("Haha, It's a miss! Robot is not that smart...");
			}
		}
		
		if(!humanBoard.isShipRemaining()) {
			System.out.println("Robot wins, Dooms day is near...");
		}else {
			System.out.println("As always, Humans are most intelligent being exist. Robots can't win .....");
		}
	}

	private void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			
		}
		
	}
}
