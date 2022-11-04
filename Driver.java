import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Crop.Crop;
import Crop.Flowers.*;
import Player.*;
import Player.Tools.*;

public class Driver {
    public static void main(String[] args) throws InterruptedException, IOException {
        MyFarm farm = new MyFarm();
        Player player = new Player();
        ArrayList<Tools> tools = new ArrayList<Tools>();
        boolean loop = true;

        tools.add(new Shovel());
        tools.add(new WaterCan());
        tools.add(new Pickaxe());
        tools.add(new Fertilizer());
        tools.add(new Plow());

        System.out.println("Welcome to the farm!");
        while (loop) {
            int choice;
            Scanner in = new Scanner(System.in);
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(String.format("Farmer level: %d", player.getLevel()));
            System.out.println(String.format("Farmer experience: %.2f", player.getExperience()));
            System.out.println(String.format("Wallet: %.2f", player.getObjectcoins()));
            System.out.println(String.format("Current day: %d", farm.getCurrentDay()));
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("What do you want to do?");
            System.out.println("1. Check the tile");
            System.out.println("2. Buy Seed");
            System.out.println("3. Use tools");
            System.out.println("4. Register New Farmer Level");

            choice = in.nextInt();
            if (choice == 1) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("----------------------------------------------------------------------------");
                System.out.println(farm.getTile().getStatus());
                System.out.println("Press enter to return to menu...");
                System.out.println("----------------------------------------------------------------------------");
                new Scanner(System.in).nextLine();
            } else if (choice == 2) {
                int seed;
                Scanner seedChoice = new Scanner(System.in);
                System.out.println("Seeds available:");
                System.out.println("1. Tulips");
                seed = seedChoice.nextInt();
                do {
                    if (seed != 1) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println(
                                "----------------------------------------------------------------------------");
                        System.out.println("That seed does not exist");
                        System.out.println("Please enter a new choice.");
                        System.out.println(
                                "----------------------------------------------------------------------------");
                        System.out.println("Seeds available:");
                        System.out.println("1. Tulips");

                        seed = seedChoice.nextInt();
                    }
                } while (seed != 1);

                if (seed == 1) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("----------------------------------------------------------------------------");
                    farm.getTile().plantCrop(new Tulip(farm.getCurrentDay()));
                    System.out.println("----------------------------------------------------------------------------");
                }

                System.out.println("Please press enter to continue");
                new Scanner(System.in).nextLine();
            }

            else if (choice == 3) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                int[] choices = { 1, 2, 3, 4, 5 };
                Scanner userChoice = new Scanner(System.in);
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("The tools available: ");
                for (int i = 0; i < tools.size(); i++) {
                    System.out.println(String.format("%d: %s", i + 1, tools.get(i).getToolName()));
                }
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("Please pick a tool to use:");
                int toolChoice = userChoice.nextInt();
                do {
                    if ((toolChoice > choices.length) || (toolChoice < 0)) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("----------------------------------------------------------------------------");
                        System.out.println("The tools available: ");
                        for (int i = 0; i < tools.size(); i++) {
                            System.out.println(String.format("%d: %s", i + 1, tools.get(i).getToolName()));
                        }
                        System.out.println("----------------------------------------------------------------------------");
                        System.out.println("Please pick a tool to use:");
                        System.out.println("Your choice was part of the choices.");
                        System.out.println("Please try again.");
                        toolChoice = userChoice.nextInt();
                    }
                } while ((toolChoice > choices.length) || (toolChoice < 0));

                tools.get(toolChoice-1).useTool(farm.getTile(), player, farm.getCurrentDay());
                System.out.println("Please press enter to continue.");
                new Scanner(System.in).nextLine();
            }

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
}
