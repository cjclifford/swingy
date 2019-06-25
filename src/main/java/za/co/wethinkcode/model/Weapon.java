package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Weapon extends Item {
	
	@NotNull
	public int damage;
	
	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}
}
