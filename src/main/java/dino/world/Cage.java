package dino.world;

import java.util.ArrayList;

public abstract class Cage {
    public String name;
    public ArrayList<Dino> dinos = new ArrayList<>();
    public short space;
    Trophic foodType;
    public int food = 0;
    public long price = 0;

    public Cage(short space, String name) {
        this.space = space;
        this.name = name;
    }

    public String toString(){
        return name + " | " + space + " | " + foodType + " | " + food;
    }


}
