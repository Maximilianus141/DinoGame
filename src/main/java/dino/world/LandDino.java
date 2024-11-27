package dino.world;

public class LandDino extends Dino {

    public LandDino(String name, Trophic trophic) {
        super(name, trophic);
    }

    @Override
    void eat() {
        System.out.println("Error, does not know what to eat");
    }
}
