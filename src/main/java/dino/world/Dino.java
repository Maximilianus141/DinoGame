package dino.world;

public abstract class Dino {
    public String name;

    double weight;
    double maxWeight;

    double height;
    double maxHeight;

    int speed;
    double maxSpeed;

    public int hunger = 100;
    public int maxHunger = 100;

    boolean carnivore;
    boolean herbivore;
    boolean piscivore;

    abstract void eat();

    public Dino(String name,  Trophic trophic) {
        this.name = name;
        switch(trophic) {
            case CARNIVORE -> carnivore = true;
            case HERBIVORE -> herbivore = true;
            case PISCIVORE -> piscivore = true;
            default -> throw new IllegalStateException("Unexpected value: " + trophic);
        }
    }


}