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
    }
}
