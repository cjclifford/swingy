package za.co.wethinkcode.controller;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.EController;
import za.co.wethinkcode.view.ConsoleCreateHeroView;

import javax.validation.constraints.NotNull;

public class CreateHeroController implements IController {
	
	@NotNull
	private Game game;
	
	private ConsoleCreateHeroView consoleCreateHeroView;
	
	public CreateHeroController(Game game) {
		this.game = game;
		this.consoleCreateHeroView = new ConsoleCreateHeroView(this.game);
	}
	
	@Override
	public EController run() {
		
		Hero hero = this.consoleCreateHeroView.onCreateHero();
		
		this.game.heroes.add(hero);
		this.game.world = new World(hero, this.game.getRandomItem(hero.getLevel()));
		return EController.GAME;
	}

}
