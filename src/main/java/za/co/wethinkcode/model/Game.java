package za.co.wethinkcode.model;

import za.co.wethinkcode.model.Weapon;
import za.co.wethinkcode.model.Game.EArmour;
import za.co.wethinkcode.model.Game.EHelmet;
import za.co.wethinkcode.model.Game.EWeapon;
import za.co.wethinkcode.model.HeroClass;
import za.co.wethinkcode.model.Armour;
import za.co.wethinkcode.model.Helmet;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
	
	@NotNull
	public ERenderMode renderMode;
	
	public Game(ERenderMode renderMode) {
		this.renderMode = renderMode;
		this.heroes = new ArrayList<>();
		this.heroClasses = new HashMap<>();
		this.weapons = new HashMap<>();
		this.armour = new HashMap<>();
		this.helmets = new HashMap<>();
		
		// make some hero classes
		this.heroClasses.put(
				"Warrior",
				new HeroClass(
					12,
					1,
					1,
					this.weapons.get(EWeapon.RUSTY_SWORD),
					this.armour.get(EArmour.LEATHER_ARMOUR),
					this.helmets.get(EHelmet.LEATHER_CAP)
				)
			);
		
		// make some items
		this.weapons.put(EWeapon.RUSTY_SWORD, new Weapon("Rusty Sword", "RUSTY_SWORD", 1));
		this.armour.put(EArmour.LEATHER_ARMOUR, new Armour("Leather Armour", "LEATHER_ARMOUR", 1));
		this.helmets.put(EHelmet.LEATHER_CAP, new Helmet("Leather Cap", "LEATHER_CAP", 5));
	}

}
