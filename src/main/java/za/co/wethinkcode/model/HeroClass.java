package za.co.wethinkcode.model;

public class HeroClass {
	
	public int health;
	
	public int attack;
	
	public int defense;
	
	public Weapon weapon;
	
	public Armour armour;
	
	public Helmet helmet;
	
	public HeroClass(int health, int attack, int defense, Weapon weapon, Armour armour, Helmet helmet) {
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.weapon = weapon;
		this.armour = armour;
		this.helmet = helmet;
	}

}
