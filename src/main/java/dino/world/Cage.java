package dino.world;

import java.util.ArrayList;

public abstract class Cage {
    public String name;
    public ArrayList<Dino> dinos = new ArrayList<>();
    public short space;
    Trophic foodType;
    public int food = 0;
    public int maxFood;

    public Cage(short space, int maxFood, String name) {
        this.space = space;
        this.maxFood = maxFood;
        this.name = name;
    }



}
