package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;

import java.lang.NumberFormatException;
import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;
import java.util.Scanner;
import javax.validation.constraints.NotNull;

public class ConsoleSelectHeroView {
	
	@NotNull
	Game game;
	
	public ConsoleSelectHeroView(Game game) { this.game = game; }
	
	public Hero onSelectHero() {
		System.out.println("Select a hero:");
		
		for (int i = 0; i < this.game.heroes.size(); i++) {
			System.out.printf("%d %s\n", i + 1, this.game.heroes.get(i).getName());
		}
		
		System.out.println("[B] Go back");
		
		Scanner scanner = new Scanner(System.in);
		String input;
		int index;
		Hero hero;
		
		while (true) {
			input = scanner.nextLine();
			try {
				index = Integer.parseInt(input) - 1;
				try {
					if (index < 0 && index >= this.game.heroes.size())
						continue;
					hero = this.game.heroes.get(index);
					return hero;
				} catch (NullPointerException e) {
					System.out.println("Are you fucking blind?");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Are you fucking blind?");
				}
			} catch (NumberFormatException e) {
				if (input.toUpperCase().contentEquals("B")) {
					return null;
				}
				else
					System.out.println("Congratulations, you discovered an easter egg by being a downy!");
			}
		}
	}

}
