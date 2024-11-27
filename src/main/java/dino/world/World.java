package dino.world;

import java.util.ArrayList;

public class World {
    public ArrayList<Cage> cages = new ArrayList<>();
    public short day = 0;
    public long money = 0;


    public void addCage(Cage cage) {
        cages.add(cage);
    }
}
