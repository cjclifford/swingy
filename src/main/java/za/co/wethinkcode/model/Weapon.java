package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Weapon extends Item {
	
	@NotNull
	private int damage;
	
	public Weapon(String name, String id, int damage) {
		super(name, id);
		this.damage = damage;
	}
	
	public int getDamage() { return this.damage; }
}
