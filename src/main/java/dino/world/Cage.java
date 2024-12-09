package dino.world;

import java.util.ArrayList;

public abstract class Cage {
    public int id;
    public String name;
    public ArrayList<Dino> dinos = new ArrayList<>();
    public short space = 0;
    Trophic foodType = Trophic.CARNIVORE;
    public int food = 0;
    public int maxFood;

    public Cage(short space, String name, int maxFood, int id) {
        this.space = space;
        this.name = name;
        this.maxFood = maxFood;
        this.id = id;
    }

    public String toString(){
        return id + " | " + name + " | " + space + " | " + food + "/" + maxFood + " | " + foodType;
    }

    abstract public boolean addDino(Dino dino);


}
