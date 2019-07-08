package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Helmet extends Item {

	@NotNull
	private int protection;
	
	public Helmet(String name, String id, int level, int protection) {
		super(name, id, level);
		this.protection = protection;
	}
	
	public int getProtection() { return this.protection; }
	
	@Override
	public String toString() {
		return String.format("%s (%d)", this.getName(), this.protection);
	}

}
