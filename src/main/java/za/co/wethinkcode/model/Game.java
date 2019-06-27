package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	public World world;
	
	public ArrayList<Hero> heroes;
	
	@NotNull
	public RenderMode renderMode;
	
	public Game(RenderMode renderMode) {
		this.renderMode = renderMode;
		this.heroes = new ArrayList<>();
		
		Scanner fileScanner;
		File file = new File("../../heroes.txt");
		
		try {
			fileScanner = new Scanner(file);
			if (fileScanner.hasNext()) {
				String line;
				while (fileScanner.hasNextLine()) {
					line = fileScanner.nextLine();
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
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			try {
				System.out.println("heroes.txt not found, making it");
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
				fileWriter.close();
			} catch (IOException ioException) {
				System.out.println("Failed to open file heroes.txt for writing");
			}
		}
	}

}
