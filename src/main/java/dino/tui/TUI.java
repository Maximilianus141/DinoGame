package dino.tui;

import Main.Main;
import dino.world.*;

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

    public String getTable(String[][] table){

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
                if(j == 0){
                    sb.append("|");
                }
                sb.append(table[i][j] + "|");
            }
            sb.append("\n");
            if (i == 0){
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
                {"nr.", "Cage name" ,"Cage type", "Space", "price"},
                {"1", "Simple Paddock", "Land cage", "3", "0$"}
        }));
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                world.buyCage("LandCage", "Simple paddock", 0L, (short) 3);
        }
    }

    public void dinoShop(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the dino shop!");
        System.out.println(getTable(new String[][]{
                {"nr.", "Dino species", "price"},
                {"1", "T-Rex", "0$"}
        }));

        String input = scanner.nextLine();
        switch (input) {
            case "1":
                if (world.money >= TRex.price){
                    System.out.println("Which cage do you want to add the Dino too?");
                    displayCages(Category.LAND);
                }
        }
    }
        private Cage displayCages(Category category, boolean bool) {
        Scanner scanner = new Scanner(System.in);
        String world = this.world.toString(category);
        String[] cages = world.split("\n");
        String[][] table = new String[cages.length + 1][cages[0].split("\\|").length];
        table[0][0] = "Name";
        table[0][1] = "Space";
        table[0][2] = "Food type";
        for (int i = 1; i < cages.length; i++) {
            for (int j = 0; j < cages[i].split("\\|").length; j++) {
                table[i][j] = cages[i].split("\\|")[j];
            }
        }
        System.out.println(getTable(table));
        if (bool) {
            System.out.println("Which cage do you want to add the Dino too?");
            int input = scanner.nextInt();

        }

    }

}


