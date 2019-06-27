package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Hero;

import java.util.Scanner;
import java.util.ArrayList;

public class ConsoleMenuView {
	
	public static enum Option {
		SELECT,
		CREATE
	}
	
	private ArrayList<Hero> heroes;
	private Scanner scanner;
	
	public ConsoleMenuView() {
		this.heroes = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}

	public Option onSelectOption() {
		System.out.println("Would you like to:\n[S] Select a hero; or\n[N] Create a new hero?");
		
		while (true) {			
			String input = this.scanner.nextLine();
			
			switch (input.toUpperCase()) {
			case "S":
				return Option.SELECT;
			case "N":
				return Option.CREATE;
			default:
				System.out.println(input + " is not an option");
			}
		}
	}
	
}
