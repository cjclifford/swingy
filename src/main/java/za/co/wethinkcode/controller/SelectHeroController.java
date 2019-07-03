package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.view.ConsoleSelectHeroView;

public class SelectHeroController implements IController {
	
	private Game game;
	
	private ConsoleSelectHeroView consoleSelectHeroView;
	
	public SelectHeroController(Game game) {
		this.game = game;
		this.consoleSelectHeroView = new ConsoleSelectHeroView(this.game);
	}
	
	@Override
	public EController run() {
		Hero hero = this.consoleSelectHeroView.onSelectHero();
		if (hero == null)
			return EController.MAIN_MENU;
		this.game.world = new World(hero);
		System.out.println("wut");
		this.game.world.getBoard();
		return EController.GAME;
	}

}
