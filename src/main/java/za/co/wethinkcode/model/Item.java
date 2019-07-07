package za.co.wethinkcode.model;

import javax.validation.constraints.NotNull;

public abstract class Item {
	
	@NotNull
	private String name;
	
	@NotNull
	private String id;
	
	public Item(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() { return this.name; }
	
	public String getId() { return this.id; }

}
