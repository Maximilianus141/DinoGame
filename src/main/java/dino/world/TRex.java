package dino.world;

public class TRex extends LandDino{

    public TRex(String name) {
        super(name , Trophic.CARNIVORE);
        maxHeight = 5;
        maxSpeed = 200;
        maxWeight = 4000;
    }

}
