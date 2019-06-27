package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Controller;
import za.co.wethinkcode.view.ConsoleMenuView;

public class MenuController implements IController {
	
	private ConsoleMenuView consoleMenuView;
	
	public MenuController() {
		this.consoleMenuView = new ConsoleMenuView();
	}
	
	@Override
	public Controller run() {
		switch (this.consoleMenuView.onSelectOption()) {
		case SELECT:
			return Controller.SELECT_HERO;
		case CREATE:
			return Controller.CREATE_HERO;
		default:
			return Controller.QUIT;
		}
	}

}
