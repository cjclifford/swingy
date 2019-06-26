package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.RenderMode;
import za.co.wethinkcode.model.Cardinal;
import za.co.wethinkcode.view.ConsoleCharacterCreationView;
import za.co.wethinkcode.view.ConsoleCharacterSelectionView;
import za.co.wethinkcode.view.ConsoleGameView;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class GameEngine {
	
	private World world;
	
	private ArrayList<Hero> heroes;
	
	@NotNull
	private RenderMode renderMode;
	
	// TODO: implement swing renderer
	// private SwingRenderer swingRenderer;
	
	private GameController gameController;
	
	private BufferedWriter fileWriter;
	
	private Scanner fileScanner;
	
	private Scanner consoleScanner;
	
	public GameEngine(RenderMode renderMode) {
		this.renderMode = renderMode;
		this.consoleScanner = new Scanner(System.in);
		this.heroes = new ArrayList<Hero>();
	}
	
	public void handleConsoleInput() {
		switch (consoleScanner.nextLine()) {
		case "north":
			this.gameController.onMove(Cardinal.NORTH);
			break;
		case "south":
			this.gameController.onMove(Cardinal.SOUTH);
			break;
		case "west":
			this.gameController.onMove(Cardinal.WEST);
			break;
		case "east":
			this.gameController.onMove(Cardinal.EAST);
			break;
		default:
			System.out.println("Unknown command");
		}
	}
	
	// handle swing input
	// public void handleSwingInput(Event e) {}
	
	public void update() {
		// update models
	}
	
	public void render() {
		if (this.renderMode == RenderMode.CONSOLE) {			
			
		}
		// else
	}
	
	public Hero createHero() {
		if (this.renderMode == RenderMode.CONSOLE) {			
			ConsoleCharacterCreationView consoleCharacterCreationView = new ConsoleCharacterCreationView();
		}
		return null;
	}
	
	public Hero chooseHero() {
		if (this.renderMode == RenderMode.CONSOLE) {
			ConsoleCharacterSelectionView consoleCharacterSelectionView = new ConsoleCharacterSelectionView(this.heroes);;
		}
		return null;
	}
	
	public void run() {
		File file = new File("../../heroes.txt");
		String line;
		
		try {
			this.fileScanner = new Scanner(file);
			if (this.fileScanner.hasNext()) {				
				while (this.fileScanner.hasNextLine()) {
					line = this.fileScanner.nextLine();
					String rawHero[] = line.split(",");
					Hero loadedHero = new Hero(
							rawHero[0],
							Integer.parseInt(rawHero[1]),
							Integer.parseInt(rawHero[2]),
							Integer.parseInt(rawHero[3]),
							Integer.parseInt(rawHero[4]),
							Integer.parseInt(rawHero[5])
					);
					this.heroes.add(loadedHero);
				}
			} else {
				// create character
			}
			for (Hero hero : this.heroes) {
				System.out.println(hero.getName() + ":");
				System.out.println("Level: " + hero.getLevel());
				System.out.println("XP: " + hero.getXp());
				System.out.println("Health: " + hero.getHealth());
				System.out.println("Attack: " + hero.getAttack());
				System.out.println("Defense: " + hero.getDefense());
				System.out.println("-------------------------------");
			}
		} catch (FileNotFoundException fileNotFoundException) {
			try {
				fileWriter = new BufferedWriter(new FileWriter(file));
				// create hero
			} catch (IOException ioException) {
				System.out.println("Failed to open file \"heroes.txt\" for writing");
			}
		}
		
		// select/create character
		// generate world
		
		while(true) {
			// do checks for render mode
			this.handleConsoleInput();
			this.update();
			// do checks for render mode
			this.render();
		}
	}
	
}
