package za.co.wethinkcode;

import za.co.wethinkcode.model.Hero;
import za.co.wethinkcode.model.World;
import za.co.wethinkcode.model.RenderMode;
import za.co.wethinkcode.controller.GameEngine;

public class App {
    public static void main( String[] args )
    {
    	GameEngine engine = new GameEngine(RenderMode.CONSOLE);
    	engine.run();
    }
}
