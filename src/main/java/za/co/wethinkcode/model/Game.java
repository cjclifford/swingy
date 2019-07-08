package za.co.wethinkcode.model;

import za.co.wethinkcode.model.Weapon;
import za.co.wethinkcode.model.HeroClass;
import za.co.wethinkcode.model.Armour;
import za.co.wethinkcode.model.Helmet;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Game {
	
	public static enum EWeapon {
		RUSTY_SWORD
	}
	
	public static enum EArmour {
		LEATHER_ARMOUR
	}
	
	public static enum EHelmet {
		LEATHER_CAP
	}
	
	public World world;
	
	public ArrayList<Hero> heroes;
	
	public Map<String, HeroClass> heroClasses;
	
	public Map<EWeapon, Weapon> weapons;
	
	public Map<EArmour, Armour> armour;
	
	public Map<EHelmet, Helmet> helmets;
	
	public Game() {
		this.heroes = new ArrayList<>();
		this.heroClasses = new HashMap<>();
		this.weapons = new HashMap<>();
		this.armour = new HashMap<>();
		this.helmets = new HashMap<>();
		
		// make some items
		this.weapons.put(EWeapon.RUSTY_SWORD, new Weapon("Rusty Sword", "RUSTY_SWORD", 1, 1));
		this.armour.put(EArmour.LEATHER_ARMOUR, new Armour("Leather Armour", "LEATHER_ARMOUR", 1, 1));
		this.helmets.put(EHelmet.LEATHER_CAP, new Helmet("Leather Cap", "LEATHER_CAP", 1, 5));
		
		// make some hero classes
		this.heroClasses.put(
			"Warrior",
			new HeroClass(
				12,
				1,
				1,
				null,
				null,
				null
			)
		);
	}
	
	public Item getRandomItem(int level) {
		ArrayList<Item> obtainableItems = new ArrayList<>();
		Weapon weapon;
		Armour armour;
		Helmet helmet;
		
		for (Map.Entry<EWeapon, Weapon> weaponEntry : this.weapons.entrySet()) {
			weapon = weaponEntry.getValue();
			if (weapon.getLevel() <= level)
				obtainableItems.add(weapon);
		}
		for (Map.Entry<EArmour, Armour> armourEntry : this.armour.entrySet()) {
			armour = armourEntry.getValue();
			if (armour.getLevel() <= level)
				obtainableItems.add(armour);
		}
		for (Map.Entry<EHelmet, Helmet> helmetEntry : this.helmets.entrySet()) {
			helmet = helmetEntry.getValue();
			if (helmet.getLevel() <= level)
				obtainableItems.add(helmet);
		}
		return obtainableItems.get(new Random().nextInt(obtainableItems.size()));
	}

}
