package dino.world;

public class Megalodon extends WaterDino {
    public Megalodon(String name) {
        super(name , Trophic.CARNIVORE);
        maxHeight = 5;
        maxSpeed = 200;
        maxWeight = 4000;
        price = 0;
    }
}
