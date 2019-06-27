package za.co.wethinkcode;

import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.model.RenderMode;
import za.co.wethinkcode.model.Controller;
import za.co.wethinkcode.controller.IController;
import za.co.wethinkcode.controller.MenuController;
import za.co.wethinkcode.controller.SelectHeroController;
import za.co.wethinkcode.controller.GameController;

import java.util.Map;
import java.util.HashMap;

public class App {
	
    public static void main( String[] args )
    {
    	RenderMode renderMode;
    	
    	if (args.length == 0) {
    		System.out.println("Proper usage is: java -jar swingy.jar [console|gui]");
    		return;
    	}
    	
    	switch (args[0].toUpperCase()) {
    	case "CONSOLE":
    		renderMode = RenderMode.CONSOLE;
    		break;
    	case "GUI":
    		renderMode = RenderMode.GUI;
    		break;
    	default:
    		return;
    	}
    	
    	Map<Controller, IController> controllers = new HashMap<>();
    	Controller currentController = Controller.MAIN_MENU;
    	Game game = new Game(RenderMode.CONSOLE);
    	
    	if (game.heroes == null)
    		currentController = Controller.CREATE_HERO;
    	
    	MenuController menuController = new MenuController();
    	SelectHeroController selectHeroController = new SelectHeroController(game);
    	GameController gameController = new GameController(game);
    	
    	controllers.put(Controller.MAIN_MENU, menuController);
    	controllers.put(Controller.SELECT_HERO, selectHeroController);
    	controllers.put(Controller.GAME, gameController);
    	
    	while (currentController != Controller.QUIT) {
    		currentController = controllers.get(currentController).run();
    	}
    }
    
}