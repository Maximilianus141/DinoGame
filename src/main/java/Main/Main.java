package Main;

import dino.tui.TUI;
import dino.world.Dino;
import dino.world.LandCage;
import dino.world.LandDino;
import dino.world.World;

public class Main {

    static World world = new World();



    public static void main(String[] args) {
        TUI tui = new TUI(world);
        tui.displayWorld();
    }

    public static void buyCage(){
        LandCage landCage = new LandCage((short) 1, 100, "Cage1");
        world.addCage(landCage);
    }

    public static void addDinoTooCage(LandDino dino, LandCage cage)
    {

        cage.addDino(dino);
    }

}
