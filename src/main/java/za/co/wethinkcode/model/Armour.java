package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Armour extends Item {
	
	@NotNull
	private int armour;
	
	public Armour(String name, String id, int armour) {
		super(name, id);
		this.armour = armour;
	}
	
	public int getArmour() { return this.armour; }

}
