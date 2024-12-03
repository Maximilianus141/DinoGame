package dino.world;

import java.util.ArrayList;

public class LandCage extends Cage {
    ArrayList<LandDino> landDinos = new ArrayList<>();

    public void addDino(LandDino dino) {
        landDinos.add(dino);
        dinos.add(dino);
    }
    public LandCage(short space, String name, int maxFood, int id) {
        super(space, name,maxFood, id);
    }
}
