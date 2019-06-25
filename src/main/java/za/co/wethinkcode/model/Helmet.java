package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public class Helmet extends Item {

	@NotNull
	private int protection;
	
	public Helmet(String name, int protection) {
		super(name);
		this.protection = protection;
	}
	
	public int getProtection() { return this.protection; }

}
