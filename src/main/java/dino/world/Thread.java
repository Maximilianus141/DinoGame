package dino.world;


public class Thread implements Runnable {
	private long time = 0;
	private final World world;
	public boolean run = true;


	private void updateMoney()
	{
		world.money += world.moneyIncrement;
	}

	public Thread(World world)
	{
		this.world = world;
	}

	@Override
	public void run()
	{
		time++;
		if (time % 6000 == 0) {
			world.day++;
			updateMoney();
		}
		try {
			java.lang.Thread.sleep(50);
		} catch (Exception _) {
		}
	}
}
