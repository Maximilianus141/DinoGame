package dino.world;

import java.util.ArrayList;

public class WaterCage extends Cage {
    ArrayList<WaterDino> waterDinos = new ArrayList<>();

    public void addDino(WaterDino dino) {
        waterDinos.add(dino);
        dinos.add(dino);
    }
    public WaterCage(short space, String name, int maxFood, int id) {
        super(space, name, maxFood, id);
    }
}