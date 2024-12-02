package dino.world;

import java.util.ArrayList;

public class World {
    public ArrayList<Cage> cages = new ArrayList<>();
    public short day = 0;
    public long money = 0;


    public void addCage(Cage cage) {
        cages.add(cage);
    }

    public String toString(Category category) {
        StringBuilder sb = new StringBuilder();
        switch (category) {
            case LAND:
                for (Cage cage : cages) {
                    if (cage instanceof LandCage) {
                        sb.append(cage.toString() + "\n");
                    }
                }
                break;
            case WATER:
                for (Cage cage : cages) {
                    if (cage instanceof WaterCage) {
                        sb.append(cage.toString() + "\n");
                    }
                }
                break;
        }
        return sb.toString();
    }

    public void buyCage(String cage, String name, long price, short space) {
        if (price <= money) {
            money -= price;
        } else {
            System.out.println("You don't have enough money!");
            return;
        }
        addCage(new LandCage(space, name));
    }


}
