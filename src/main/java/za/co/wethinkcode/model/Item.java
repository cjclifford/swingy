package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public abstract class Item {
	
	@NotNull
	private String name;
	
	public Item(String name) { this.name = name; }
	
	public String getName() { return this.name; }

}
