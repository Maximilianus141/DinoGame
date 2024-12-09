package dino.world;

import java.util.ArrayList;

public class WaterCage extends Cage {
    ArrayList<WaterDino> waterDinos = new ArrayList<>();

    public boolean addDino(Dino dino) {
        if (dino instanceof WaterDino) {
            waterDinos.add((WaterDino) dino);
            dinos.add(dino);
        } else {
            return false;
        }
        return true;
    }
    public WaterCage(short space, String name, int maxFood, int id) {
        super(space, name, maxFood, id);
    }
}