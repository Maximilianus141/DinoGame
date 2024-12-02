package dino.world;


public class WaterDino extends Dino {

    public WaterDino(String name, Trophic trophic) {
        super(name, trophic);
    }

    @Override
    void eat() {
        System.out.println("Error, does not know what to eat");
    }
}

