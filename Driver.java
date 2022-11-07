/*
 * Wray Nathan Andres
 * Ana Muriel Veron
 * 
 * S22
 * Group - 22
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Crop.RootCrops.Turnip;
import Player.*;
import Player.Tools.*;

/*
 * This is the driver class for the whole game. This driver class contains the main loop for the 
 * whole game.
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException, IOException {
        MyFarm farm = new MyFarm();
        Player player = new Player();
        ArrayList<Tools> tools = new ArrayList<Tools>();
        boolean loop = true;
        int mainLoop = 1;

        // adds the tools to a list.
        tools.add(new Shovel());
        tools.add(new WaterCan());
        tools.add(new Pickaxe());
        tools.add(new Fertilizer());
        tools.add(new Plow());

        do { // main game loop
            System.out.println("Welcome to the farm!");
            while (loop) { // sub game loop
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
                System.out.println("4. Harvest crop");
                System.out.println("5. level up");
                System.out.println("6. Register New Farmer Level");
                System.out.println("7. Check farmer status");
                System.out.println("8. Advance day...");

                choice = in.nextInt();
                if (choice == 1) { // shows the status of the farm.
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println(farm.getTile().getStatus(farm.getCurrentDay()));
                    System.out.println("Press enter to return to menu...");
                    System.out.println("----------------------------------------------------------------------------");
                    new Scanner(System.in).nextLine();
                } else if (choice == 2) { // shows the buy menu and for the buying of seeds.
                    int seed;
                    Scanner seedChoice = new Scanner(System.in);
                    System.out.println("Seeds available:");
                    System.out.println("1. Turnip [5C]"); //use methods in MCO2
                    seed = seedChoice.nextInt();
                    do { // error checker.
                        if (seed != 1) {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            System.out.println(
                                    "----------------------------------------------------------------------------");
                            System.out.println("That seed does not exist");
                            System.out.println("Please enter a new choice.");
                            System.out.println(
                                    "----------------------------------------------------------------------------");
                            System.out.println("Seeds available:");
                            System.out.println("1. Turnip [5C]"); //use methods in MCO2

                            seed = seedChoice.nextInt();
                        }
                    } while (seed != 1);

                    if (seed == 1) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println(
                                "----------------------------------------------------------------------------");
                        player.buySeed(farm.getTile(), farm.getCurrentDay(), new Turnip(farm.getCurrentDay()));
                        System.out.println(
                                "----------------------------------------------------------------------------");
                    }

                    System.out.println("Please press enter to continue");
                    new Scanner(System.in).nextLine();
                }

                else if (choice == 3) { // shows the tool menu
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    int[] choices = { 1, 2, 3, 4, 5 };
                    Scanner userChoice = new Scanner(System.in);
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("The tools available: ");
                    for (int i = 0; i < tools.size(); i++) { // prints all the available tools.
                        System.out.println(String.format("%d: %s", i + 1, tools.get(i).getToolName()));
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("Please pick a tool to use:");
                    int toolChoice = userChoice.nextInt();
                    do {
                        if ((toolChoice > choices.length) || (toolChoice < 0)) {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            System.out.println(
                                    "----------------------------------------------------------------------------");
                            System.out.println("The tools available: ");
                            for (int i = 0; i < tools.size(); i++) {
                                System.out.println(String.format("%d: %s", i + 1, tools.get(i).getToolName()));
                            }
                            System.out.println(
                                    "----------------------------------------------------------------------------");
                            System.out.println("Please pick a tool to use:");
                            System.out.println("Your choice was part of the choices.");
                            System.out.println("Please try again.");
                            toolChoice = userChoice.nextInt();
                        }
                    } while ((toolChoice > choices.length) || (toolChoice < 0));

                    tools.get(toolChoice - 1).useTool(farm.getTile(), player, farm.getCurrentDay()); // uses the tools.
                    System.out.println("Please press enter to continue.");
                    new Scanner(System.in).nextLine();
                }

                else if (choice == 4) { // harvests the crop based on the tile.
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    player.harvestTile(farm.getTile(), farm.getCurrentDay());
                    System.out.println("Please press enter to continue...");
                    new Scanner(System.in).nextLine();
                }

                else if (choice == 5) { // levels up the player
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    player.levelUp();
                    System.out.println("Please press enter to continue...");
                    new Scanner(System.in).nextLine();
                }

                else if (choice == 6) { // shows the registered farmer menu
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    Scanner userIn = new Scanner(System.in);
                    int userInput;
                    System.out.println("Please pick a farmer registration:");
                    System.out.println("1. Registered Farmer");
                    System.out.println("2. Distinguished Farmer");
                    System.out.println("3. Legendary Farmer");
                    userInput = userIn.nextInt();
                    if (userInput <= 3 && userInput > 0)
                        player.register(userInput);
                    else
                        System.out.println("Wrong input...");

                    System.out.println("Please press enter to continue...");
                    new Scanner(System.in).nextLine();
                }

                else if (choice == 7) { // checks the farmer type
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println(
                            String.format("Your farmer registration is: %s", player.getFarmerType().getFarmerType()));

                    System.out.println("Please press enter to continue...");
                    new Scanner(System.in).nextLine();
                }

                else if (choice == 8) {// advances the day.
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    farm.advanceDay();
                    System.out.println("The day was finally over...");
                    System.out.println("You sleep...");
                    System.out.println("A new day arises!");
                    loop = !farm.checkGameOver(player);

                    System.out.println("Please press enter to continue...");
                    new Scanner(System.in).nextLine();

                }

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            if (!farm.getTile().checkPlanted()) { // game ending reason 1
                System.out.println(
                        "You did not plant a crop and had no active crop growing during the night, you lose...");
            } else if (player.getObjectcoins() < 5) { // game ending reason 2
                System.out.println("You do not have enough money to buy any seeds. You lose...");
            }
            Scanner go = new Scanner(System.in);
            System.out.println("Do you want to start a new game?");
            System.out.println("Enter 1 if yes."); // asks the player if they want to go again
            System.out.println("Enter any number if no.");
            mainLoop = go.nextInt();
            if (mainLoop == 1) {
                loop = true;
                farm.gameReset(player); // resets the game
            }
        } while (mainLoop == 1);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Thank you for playing."); // game finished print.
    }
}
