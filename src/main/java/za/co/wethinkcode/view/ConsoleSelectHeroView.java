package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;

import java.lang.NumberFormatException;
import java.lang.NullPointerException;
import java.util.Scanner;

public class ConsoleSelectHeroView {
	
	Game game;
	
	public ConsoleSelectHeroView(Game game) { this.game = game; }
	
	public Hero onSelectHero() {
		System.out.println("Select a hero:");
		
		for (int i = 0; i < this.game.heroes.size(); i++) {
			System.out.println(String.format("%d %s", i + 1, this.game.heroes.get(i).getName()));
		}
		
		System.out.println("[B] To go back");
		
		Scanner scanner = new Scanner(System.in);
		String input;
		int index;
		Hero hero;
		
		while (true) {
			input = scanner.nextLine();
			try {
				index = Integer.parseInt(input) - 1;
				try {
					hero = this.game.heroes.get(index);
					scanner.close();
					return hero;
				} catch (NullPointerException e) {
					System.out.println(String.format("%d is not a valid hero", index));
				}
			} catch (NumberFormatException e) {
				if (input.toUpperCase().contentEquals("B"))
					return null;
				else
					System.out.println(String.format("%s is not a valid option", input));
			}
		}
	}

}
