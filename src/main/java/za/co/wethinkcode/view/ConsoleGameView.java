package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Character;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.Enemy;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.EInput;

import java.util.Scanner;

public class ConsoleGameView {
	
	private Game game;
	
	public ConsoleGameView(Game game) { this.game = game; }
	
	public EInput onHandleInput() {
		
		Scanner scanner = new Scanner(System.in);
		
		switch (scanner.nextLine().toUpperCase()) {
		case "NORTH":
			return EInput.NORTH;
		case "SOUTH":
			return EInput.SOUTH;
		case "EAST":
			return EInput.EAST;
		case "WEST":
			return EInput.WEST;
		default:
			System.out.println("You cannot do that.");
		}
		return EInput.QUIT;
	}
	
	public void onRenderState() {
		World world = this.game.world;
		
		for (Character[] characters : world.getBoard()) {
			for (Character character : characters) {
				if (character instanceof Hero)
					System.out.print("H");
				else if (character instanceof Enemy)
					System.out.print("E");
				else System.out.print(".");
			}
			System.out.println();
		}
	}
	
	public void onReachBoundary() {
		System.out.println("You beat this map!");
	}

}
