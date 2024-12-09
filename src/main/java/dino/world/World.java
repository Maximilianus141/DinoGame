package dino.world;

import java.util.ArrayList;

public class World {
	public ArrayList<Cage> cages = new ArrayList<>();
	public long moneyIncrement = 1000;
	public short day = 0;
	public long money = 0;
	public int cageId = 0;
	public boolean firstCageDino = true;


	public void addCage(Cage cage)
	{
		cages.add(cage);
	}

	public ArrayList<Cage> getCages(Category category)
	{
		ArrayList<Cage> cages = new ArrayList<>();
		switch (category) {
			case LAND -> {
				for (Cage cage : cages) {
					if (cage instanceof LandCage) {
						cages.add(cage);
					}
				}
				return cages;
			}
			case WATER -> {
				for (Cage cage : cages) {
					if (cage instanceof WaterCage) {
						cages.add(cage);
					}
				}
				return cages;
			}

		}
		return null;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (Cage cage : cages) {
			sb.append(cage.toString() + "\n");
		}
		return sb.toString();
	}

	//    public String toString(Category category) {
	//        StringBuilder sb = new StringBuilder();
	//        switch (category) {
	//            case LAND:
	//                for (Cage cage : cages) {
	//                    if (cage instanceof LandCage) {
	//                        sb.append(cage.toString() + "\n");
	//                    }
	//                }
	//                break;
	//            case WATER:
	//                for (Cage cage : cages) {
	//                    if (cage instanceof WaterCage) {
	//                        sb.append(cage.toString() + "\n");
	//                    }
	//                }
	//                break;
	//        }
	//        return sb.toString();
	//    }

	public void buyCage(Category cage, String name, int maxFood, long price, short space)
	{
		if (price <= money) {
			money -= price;
		} else {
			System.out.println("You don't have enough money!");
			return;
		}
		switch (cage) {
			case Category.LAND:
				addCage(new LandCage(space, name, maxFood, cageId));
				break;
			case Category.WATER:
				addCage(new WaterCage(space, name, maxFood, cageId));
				break;
			default:
				System.out.println("Something went wrong while buying a cage!");
		}
		cageId++;
	}

	public Cage getCage(int cageId)
	{
		return cages.get(cageId);
	}


}
