package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.view.ConsoleMenuView;

public class MenuController implements IController {
	
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
