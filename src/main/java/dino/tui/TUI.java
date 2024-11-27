package dino.tui;

import Main.Main;
import dino.world.*;

import java.util.Scanner;

public class TUI {
    private World world;

    public TUI(World world) {
        this.world = world;
        if (world.cages.isEmpty()) {
            Main.buyCage();
        }
    }


    public void displayWorld() {
        for (Cage cage : world.cages) {
            displayCage(cage);
        }
    }

    public void displayCage(Cage cage) {
        System.out.println(cage.name + " has: " + cage.food + "kg of food");
        if (cage.dinos.isEmpty()) {
            System.out.println("This cage is empty! Buy a Dino!");
            Main.addDinoTooCage((LandDino) buyDino(), (LandCage) cage);
            System.out.println();
        }
        for (Dino dino : cage.dinos) {
            System.out.println(dino.name + " " + dino.hunger);
        }
        System.out.println();
    }

    public Dino buyDino() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can buy: ");
        System.out.println("Nr.0\t T-Rex - 0$\n");
        System.out.println("Which one?");
        int storeInput = scanner.nextInt();
        switch (storeInput) {
            case 0:
                TRex dino = new TRex("trex1");
                return dino;
            default:
                System.out.println("Error! Buy again!");
                buyDino();
                break;
        }
        return null;
    }
}


