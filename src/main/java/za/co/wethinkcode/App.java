package za.co.wethinkcode;

import za.co.wethinkcode.model.World;

public class App {
    public static void main( String[] args )
    {
        World world = new World(1);
        
        world.printBoard();
    }
}
