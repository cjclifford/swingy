package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Character;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.Enemy;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.EInput;
import za.co.wethinkcode.model.Item;

import java.util.Scanner;
import javax.validation.constraints.NotNull;

public class ConsoleGameView {
	
	@NotNull
	private Game game;
	
	public ConsoleGameView(Game game) { this.game = game; }
	
	public EInput onHandleInput() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			switch (scanner.nextLine().toUpperCase()) {
			case "NORTH":
				return EInput.NORTH;
			case "SOUTH":
				return EInput.SOUTH;
			case "EAST":
				return EInput.EAST;
			case "WEST":
				return EInput.WEST;
			case "QUIT":
				return EInput.QUIT;
			default:
				System.out.println("You cannot do that.");
			}
		}
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
		System.out.println(this.game.world.hero.toString());
	}
	
	public EInput onEncounter(Enemy enemy) {
		System.out.printf("You encountered an %s\n[F] Fight\n[R] Run\n", enemy.getName());
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			switch (scanner.nextLine().toUpperCase()) {
			case "F":
				return EInput.FIGHT;
			case "R":
				return EInput.RUN;
			default:
				System.out.println("You cannot do that.");
			}
		}
	}
	
	public boolean onDropLoot(Item loot) {
		System.out.printf("The enemy dropped something.\n%s\nDo you want to equip it?\n[Y] Yes\n[N] No\n", loot.toString());
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {			
			switch (scanner.nextLine().toUpperCase()) {
			case "Y":
				return true;
			case "N":
				return false;
			default:
				System.out.println("That is not an option.");
			}
		}
	}
	
	public void onRunSuccess() {
		System.out.println("Successfully ran away");
	}
	
	public void onRunFailure() {
		System.out.println("Failed to run away.");
	}
	
	public void onReachBoundary() {
		System.out.println("You beat this map!");
	}
	
	public void onFight(Enemy enemy) {
		System.out.printf("You fight the %s\n", enemy.getName());
	}
	
	public void onDefeatEnemy(Enemy enemy) {
		System.out.printf("You have defeated the %s\n", enemy.getName());
	}
	
	public void onDeath(Enemy enemy) {
		System.out.printf("%s died to a %s\n", this.game.world.hero.getName(), enemy.getName());
	}

}
