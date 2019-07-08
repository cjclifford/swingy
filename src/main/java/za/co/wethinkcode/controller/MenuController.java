package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.view.ConsoleMenuView;

import javax.validation.constraints.NotNull;

public class MenuController implements IController {
	
	@NotNull
	private Game game;
	
	private ConsoleMenuView consoleMenuView;
	
	public MenuController(Game game) {
		this.game = game;
		this.consoleMenuView = new ConsoleMenuView(this.game);
	}
	
	@Override
	public EController run() {
		return this.consoleMenuView.onSelectOption();
	}

}
