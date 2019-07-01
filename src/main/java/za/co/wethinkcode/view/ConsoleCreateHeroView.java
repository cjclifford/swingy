package za.co.wethinkcode.view;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Game.EArmour;
import za.co.wethinkcode.model.Game.EHelmet;
import za.co.wethinkcode.model.Game.EWeapon;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.HeroClass;
import za.co.wethinkcode.model.Weapon;
import za.co.wethinkcode.model.Armour;
import za.co.wethinkcode.model.Helmet;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.lang.NullPointerException;

public class ConsoleCreateHeroView {
	
	private Game game;
	
	public ConsoleCreateHeroView(Game game) {
		this.game = game;
	}
	
	public Hero onCreateHero() {
		String heroName;
		String heroClassName;

		System.out.println("What is the name of your hero?\n");

		Scanner scanner = new Scanner(System.in);
		
		heroName = scanner.nextLine();
		
		System.out.println("Choose a class:");
		
		System.out.printf("%-10.10s %-10.10s %-10.10s %-10.10s\n", "Class Name", "Health", "Attack", "Defense");
		
		for (Map.Entry<String, HeroClass> entry : this.game.heroClasses.entrySet()) {
			System.out.printf(
				"%-10.10s %-10.10s %-10.10s %-10.10s\n",
				entry.getKey(),
				entry.getValue().health,
				entry.getValue().attack,
				entry.getValue().defense
			);
		}
		
		while (true) {
			heroClassName = scanner.nextLine();
			try {
				HeroClass heroClass = this.game.heroClasses.get(heroClassName);
				return new Hero(
					heroName,
					heroClassName,
					heroClass.health,
					heroClass.attack,
					heroClass.defense,
					heroClass.weapon,
					heroClass.armour,
					heroClass.helmet
				);
			} catch (NullPointerException e) {
				System.out.println("Please select a valid class");
			}
		}
	}

}