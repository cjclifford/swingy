package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Hero extends Character {
	
	private Item weapon;
	
	private Item armour;
	
	private Item helmet;
	
	@NotNull
	private int level;
	
	@NotNull
	private int xp;
	
	@NotNull
	private int xpRequirements;
	
	//TODO: Make this a builder constructor instead
	public Hero(String name, int health, int attack, int defense, int x, int y) {
		super(name, health, attack, defense, x, y);
	}
	
	public int getLevel() { return this.level; }
	
	public int getXp() { return this.xp; }
	
	public int getXpRequirements() { return this.xpRequirements; }
	
	//TODO: Implementation
	public void fight(Character enemy) {
		System.out.println("slap!");
	}

	//TODO: Implementation
	public boolean run(Character enemy) {
		System.out.println("running");
		return true;
	}
	
	private void levelUp() {}
	
	public void gainXp(int xp) {
		this.xp += xp;
		if (this.xp >= this.xpRequirements) {
			this.levelUp();
			this.xp = this.xp - this.xpRequirements;
			this.xpRequirements = this.level * 1000 + (this.level - 1) * (this.level - 1) * 450;
		}
	}
	
	public void equipItem(Item item) {
		if (item instanceof Weapon) {
			this.weapon = item;
		} else if (item instanceof Armour) {
			this.armour = item;
		} else if (item instanceof Helmet) {
			this.helmet = item;
		} else {
			System.out.println("This item cannot be equipped.");
		}
	}

}
