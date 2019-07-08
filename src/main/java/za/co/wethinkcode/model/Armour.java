package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Armour extends Item {
	
	@NotNull
	private int armour;
	
	public Armour(String name, String id, int level, int armour) {
		super(name, id, level);
		this.armour = armour;
	}
	
	public int getArmour() { return this.armour; }
	
	@Override
	public String toString() {
		return String.format("%s (%d)", this.getName(), this.armour);
	}

}
