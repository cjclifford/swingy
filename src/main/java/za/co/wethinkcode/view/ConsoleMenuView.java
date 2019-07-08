package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.EController;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.validation.constraints.NotNull;

public class ConsoleMenuView {
	
	@NotNull
	private Game game;
	
	public ConsoleMenuView(Game game) {
		this.game = game;
	}
	
	private boolean onLoadHeroes() {
		File file = new File("heroes.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			
			if (!scanner.hasNext()) {
				scanner.close();
				return false;
			}
			
			String line;
			
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				
				String rawHero[] = line.split(",");
				
				Hero loadedHero = new Hero(
						rawHero[0],
						rawHero[1],
						Integer.parseInt(rawHero[2]),
						Integer.parseInt(rawHero[3]),
						Integer.parseInt(rawHero[4]),
						Integer.parseInt(rawHero[5]),
						Integer.parseInt(rawHero[6]),
						rawHero[7].equals("NONE") ? null : this.game.weapons.get(Game.EWeapon.valueOf(rawHero[7])),
						rawHero[8].equals("NONE") ? null : this.game.armour.get(Game.EArmour.valueOf(rawHero[8])),
						rawHero[9].equals("NONE") ? null : this.game.helmets.get(Game.EHelmet.valueOf(rawHero[9]))
				);
				this.game.heroes.add(loadedHero);
			}
			scanner.close();
			return true;
		} catch (FileNotFoundException e) {
			try {
				System.out.println("Save file not found, making it");
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
				fileWriter.close();
				return false;
			} catch (IOException ioException) {
				System.out.println("Failed to create save file");
				return false;
			}
		}
	}

	public EController onSelectOption() {
		if (!this.onLoadHeroes())
			return EController.CREATE_HERO;
		
		System.out.println("[S] Select a hero\n[N] Create a new hero");
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String input = scanner.nextLine();
			
			switch (input.toUpperCase()) {
			case "S":
				return EController.SELECT_HERO;
			case "N":
				return EController.CREATE_HERO;
			default:
				System.out.println(input + " is not an option");
			}
		}
	}
	
}
