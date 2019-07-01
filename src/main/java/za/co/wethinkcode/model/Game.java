package za.co.wethinkcode.model;

import za.co.wethinkcode.model.Weapon;
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
	public RenderMode renderMode;
	
	public Game(RenderMode renderMode) {
		this.renderMode = renderMode;
		this.heroes = new ArrayList<>();
		this.weapons = new HashMap<>();
		this.armour = new HashMap<>();
		this.helmets = new HashMap<>();
		
		// make some items
		this.weapons.put(EWeapon.RUSTY_SWORD, new Weapon("Rusty Sword", 1));
		this.armour.put(EArmour.LEATHER_ARMOUR, new Armour("Leather Armour", 1));
		this.helmets.put(EHelmet.LEATHER_CAP, new Helmet("Leather Cap", 5));
	}

}
