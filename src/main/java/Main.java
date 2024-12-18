import dino.tui.TUI;
import dino.world.Thread;
import dino.world.World;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	static World world = new World();

	public static void clearScreen()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void main(String[] args)
	{
		dino.world.Thread mainThread = new dino.world.Thread(world);
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(mainThread , 0, 50, TimeUnit.MILLISECONDS);
		TUI tui = new TUI(world);
		mainThread.skipDay();
	}
}
