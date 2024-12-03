package dino.tui;

import Main.Main;
import dino.world.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TUI {
    private World world;

    public TUI(World world) {
        this.world = world;
        if (world.cages.isEmpty()) {
            System.out.println("You don't have any cages!");
            System.out.println("Buy one?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                cageShop();
            }
        }
        dinoShop();

    }


    private String makeStringDesiredLength(String stringToChange, int desiredLength) {
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

    public String getTable(String[][] table) {

        int[] biggestStrings = new int[table[0].length];


        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].length() > biggestStrings[j]) {
                    biggestStrings[j] = table[i][j].length() + 2;
                }
                if (table[i][j].charAt(0) != ' ') {
                    table[i][j] = " " + table[i][j];
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
                sb.append(table[i][j] + "|");
            }
            sb.append("\n");
            if (i == 0) {
                sb.append(top);
            }
        }
        sb.append(top);
        return sb.toString();
    }

    public void cageShop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the cage shop!");
        System.out.println(getTable(new String[][]{
                {"nr.", "Cage name", "Cage type", "Space", "price"},
                {"1", "Simple paddock", "Land cage", "3", "0$"},
                {"2", "Simple aquarium", "Water cage", "3", "0$"}
        }));
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                world.buyCage(Category.LAND, "Simple paddock",100, 0L, (short) 3);
                break;
            case "2":
                world.buyCage(Category.WATER, "Simple aquarium",100, 0L, (short) 3);
                break;
            default:
                System.out.println("No Cage bought!");
                break;
        }
    }

    public void dinoShop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the dino shop!");
        System.out.println(getTable(new String[][]{
                {"nr.", "Dino species", "price"},
                {"1", "T-Rex", "0$"}
        }));

        String input = scanner.nextLine();
        switch (input) {
            case "1":
                if (world.money >= TRex.price) {
                    System.out.println("Which cage do you want to add the Dino too?");
                    displayCages(true).addDino(new TRex("T-Rex"));
                }
                break;
            default:
                System.out.println("No Dino bought!");
        }
    }

    public void displayCage(Cage cage) {
        ArrayList<String[]> dinos = new ArrayList<>();
        dinos.add(new String[]{"Name", "Hunger", "Speed"});
        for (Dino dino : cage.dinos){
            dinos.add(dino.toString().split("\\|"));
        }
        String[][] table = new String[dinos.size()][dinos.getFirst().length];
        getTable(dinos.toArray(new String[dinos.size()][]));
    }

    private Cage displayCages(boolean bool) {
        Scanner scanner = new Scanner(System.in);
        String world = this.world.toString();
        if (world.isEmpty()) {
            System.out.println("Something went wrong!");
        }
        String[] cages = world.split("\n");
        String[][] table = new String[cages.length + 1][cages[0].split("\\|").length];
        table[0][0] = "Id";
        table[0][1] = "Name";
        table[0][2] = "Space";
        table[0][3] = "Food";
        table[0][4] = "Food type";


        for (int i = 0; i < cages.length; i++) {
            table[i + 1][0] = cages[i].split("\\|")[cages[i].split("\\|").length - 1];
            for (int j = 0; j < cages[i].split("\\|").length; j++) {
                table[i + 1][j] = cages[i].split("\\|")[j];
            }
        }
        System.out.println(getTable(table));
        if (bool) {
            System.out.println("Which cage do you want to add the Dino too?");
            int input = scanner.nextInt();
            return this.world.getCage(input);
        } else {
            return null;
        }
    }


}


