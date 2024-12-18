package dino.world;


public class LandCage extends Cage {

	public boolean addDino(Dino dino)
	{
		if (dino instanceof LandDino) {
			dinos.add(dino);
		} else {
			return false;
		}
		return true;
	}

	public LandCage(short space, String name, int maxFood, int id)
	{
		super(space, name, maxFood, id);
	}
}
