package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Hero extends Character {
	
	private String heroClass;
	
	private Weapon weapon;
	
	private Armour armour;
	
	private Helmet helmet;
	
	@NotNull
	private int level;
	
	@NotNull
	private int xp;
	
	@NotNull
	private int xpRequirement;
	
	public Hero(String name, String heroClass, int level, int xp, int health, int attack, int defense, Weapon weapon, Armour armour, Helmet helmet) {
		super(name, health, attack, defense);
		
		this.heroClass = heroClass;
		
		this.level = level;
		this.xp = xp;
		this.xpRequirement = this.calculateXpRequirement();
		
		this.weapon = weapon;
		this.armour = armour;
		this.helmet = helmet;
	}
	
	public Hero(String name, String heroClass, int health, int attack, int defense, Weapon weapon, Armour armour, Helmet helmet) {
		super(name, health, attack, defense);
		
		this.heroClass = heroClass;
		
		this.level = 1;
		this.xp = 0;
		this.xpRequirement = this.calculateXpRequirement();
		
		this.weapon = weapon;
		this.armour = armour;
		this.helmet = helmet;
	}
	
	public int calculateXpRequirement() {
		return this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;
	}
	
	public int getTotalHealth() {
		if (this.helmet != null)
			return this.getHealth() + this.helmet.getProtection();
		return this.getHealth();
	}
	
	public int getTotalAttack() {
		if (this.weapon != null)
			return this.getAttack() + this.weapon.getDamage();
		return this.getAttack();
	}
	
	public int getTotalDefense() {
		if (this.helmet != null)
			return this.getDefense() + this.armour.getArmour();
		return this.getDefense();
	}
	
	public String getHeroClass() { return this.heroClass; }
	
	public int getLevel() { return this.level; }
	
	public int getXp() { return this.xp; }
	
	public int getXpRequirement() { return this.xpRequirement; }
	
	//TODO: Implementation
	public void fight(Enemy enemy) {
		System.out.println("slap!");
	}

	//TODO: Implementation
	public boolean run(Enemy enemy) {
		System.out.println("running");
		return true;
	}
	
	private void levelUp() {
		this.level++;
		// do some stat improvements here
	}
	
	public void gainXp(int xp) {
		this.xp += xp;
		if (this.xp >= this.xpRequirement) {
			this.levelUp();
			this.xp = this.xp - this.xpRequirement;
			this.xpRequirement = this.calculateXpRequirement();
		}
	}
	
	public void equipItem(Item item) {
		if (item instanceof Weapon) {
			this.weapon = (Weapon)item;
		} else if (item instanceof Armour) {
			this.armour = (Armour)item;
		} else if (item instanceof Helmet) {
			this.helmet = (Helmet)item;
		} else {
			System.out.println("This item cannot be equipped.");
		}
	}

}
