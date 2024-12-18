package dino.tui;

import dino.world.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TUI {

	private final World world;

	public TUI(World world)
	{
		this.world = world;
		if (world.firstCageDino) {
			System.out.println("You don't have any cages!");
			System.out.println("Buy one?");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
				cageShop();
			}
		}
		dinoShop();
		displayAllCages();

	}

	private String makeStringDesiredLength(String stringToChange, int desiredLength)
	{
		int stringLength = stringToChange.length();
		StringBuilder sb = new StringBuilder();
		if (stringLength < desiredLength) {
			int difference = desiredLength - stringLength;
			sb.append(stringToChange);
			sb.append(" ".repeat(difference));
			return sb.toString();
		}
		return stringToChange;
	}

	public String getTable(String[][] table)
	{

		int[] biggestStrings = new int[table[0].length];


		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j].charAt(0) != ' ') {
					table[i][j] = " " + table[i][j];
				}
				if (table[i][j].length() + 1 > biggestStrings[j]) {
					biggestStrings[j] = table[i][j].length() + 1;
				}
			}

		}
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = makeStringDesiredLength(table[i][j], biggestStrings[j]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int biggestString : biggestStrings) {
			sb.append("+");
			sb.append("-".repeat(biggestString));
		}
		sb.append("+\n");
		String top = sb.toString();
		sb = new StringBuilder();
		sb.append(top);
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (j == 0) {
					sb.append("|");
				}
				sb.append(table[i][j]).append("|");
			}
			sb.append("\n");
			if (i == 0) {
				sb.append(top);
			}
		}
		sb.append(top);
		return sb.toString();
	}

	public boolean checkMoney(long price)
	{
		return world.money >= price;
	}

	public void cageShop()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the cage shop!");
		System.out.println(getTable(new String[][]
				{
					{"nr.", "Cage name", "Cage type", "Space", "price"},
					{"1", "Simple paddock", "Land cage", "3", "0$"},
					{"2", "Simple aquarium", "Water cage", "3", "0$"}

				}));
		String input = scanner.nextLine();
		switch (input) {
			case "1":
				world.buyCage(Category.LAND, "Simple paddock", 100, 0L, (short) 3);
				break;
			case "2":
				world.buyCage(Category.WATER, "Simple aquarium", 100, 0L, (short) 3);

				break;
			default:
				System.out.println("No Cage bought!");
				break;
		}
	}

	public void defaultScreen(){

	}

	public void dinoShop()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the dino shop!");
		boolean bool = true;
		do {
			System.out.println(getTable(new String[][]
					{
						{"nr.", "Dino species", "Category", "price"},
						{"1", "T-Rex", "Land dino", TRex.price + "$"},
						{"2", "Megalodon", "Water dino", Megalodon.price + "$"}
					}));

			String input = scanner.nextLine();

			switch (input) {
				case "1":
					if (world.money >= TRex.price) {
						System.out.println("Which cage do you want to add the Dino too?");
						Cage cage = displayCages(true);
						bool = cage.addDino(new TRex("T-Rex"));
						world.money = bool ? world.money - TRex.price : world.money;
					}
					break;
				case "2":
					if (world.money >= Megalodon.price) {
						System.out.println("Which cage do you want to add the Dino too?");
						Cage cage = displayCages(true);
						bool = cage.addDino(new Megalodon("Megalodon"));
						world.money = bool ? world.money - TRex.price : world.money;
					}
					break;
				default:
					System.out.println("No Dino bought!");
					break;
			}
			System.out.print(bool ? "" : "\nCage either has not enough space or wrong cage type!\n");
		} while (!bool);
	}

	public void displayCage(Cage cage)
	{
		ArrayList<String[]> dinos = new ArrayList<>();
		dinos.add(new String[]{"Name", "Hunger", "Speed"});
		for (Dino dino : cage.dinos) {
			dinos.add(dino.toString().split("\\|"));
		}
		System.out.println(getTable(dinos.toArray(new String[dinos.size()][])));
	}

	public void displayAllCages()
	{
		for (Cage cage : world.cages) {
			displayCage(cage);
		}
	}

	public void displayAllCages(Category category)
	{
		for (Cage cage : world.getCages(category)) {
			displayCage(cage);
		}
	}

	private Cage displayCages(boolean bool)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<String[]> dinos = new ArrayList<>();
		dinos.add(new String[]{"Id", "Name", "Space", "Food", "Foodtype"});
		for (Cage cage : world.cages) {
			dinos.add(cage.toString().split("\\|"));
		}
		System.out.println(getTable(dinos.toArray(new String[dinos.size()][])));
		if (bool) {
			System.out.println("Which cage do you want to add the Dino too?");
			int input = scanner.nextInt();
			return this.world.getCage(input);
		} else {
			return null;
		}
	}


}


