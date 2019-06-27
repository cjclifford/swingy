package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Hero;

import java.util.Scanner;

public class ConsoleCreateHeroView {
	
	public Hero onCreateHero() {
		Scanner scanner = new Scanner(System.in);
		String name;

		System.out.println("What is the name of your hero?");
		name = scanner.nextLine();
		return new Hero(name);
	}

}