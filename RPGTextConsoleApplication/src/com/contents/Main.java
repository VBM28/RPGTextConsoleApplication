package com.contents;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //initializing method to read console input
    static Scanner scanner = new Scanner(System.in);

    //creating a vector of possible monsters and the choice for weapons from the String
    static String s1 = "Axe Sword Hammer Shield Lance Bow";
    static String[] string1 = s1.split(" ");
    //creating vector of options for possible monsters
    static String s2 = "Dragon Wyvern Zombie Skeleton Demon Wolf Ghost Giant";
    static String[] string2 = s2.split(" ");
    //initializing the Player as static in order to access if from the methods outside of main
    static Player player = new Player();

    //declaring variables
    static int playerStatus;
    static int monsterStatus;


    public static void main(String[] args) {

        //initializing the boolean state as true for the initial while method
        boolean state = true;

        //setting the name of the player from the console
        System.out.println("Choose character name:");
        player.setName(scanner.nextLine());

        //selecting the weapon
        weaponList();
        int choice = scanner.nextInt();

        if (choice <= string1.length) {

            //if the option is valid, set the selected weapon
            player.setWeapon(string1[choice - 1]);
        } else {

            //else display the option is invalid and set random weapon
            System.out.println("Invalid choice. Default weapon will be used.");
            player.setWeapon(string1[new Random().nextInt(string1.length - 1)]);
        }

        //showing message that the game started
        gameOpening();

        //setting a random number for the maximum number of waves and using i as a counter for current wave
        int wave = new Random().nextInt(10) + 5;
        int i = 0;

        //printing the player's information
        System.out.println(player.toString());

        //selecting random element from the string
        int randomMonster = new Random().nextInt(string2.length - 1);

        //initializing new Monster element
        Monster monster = new Monster();

        //setting the name using the random value
        monster.setName(string2[randomMonster]);

        //running until the state switches to false
        while (state) {

            //checking if the monster was defeated
            if (monsterStatus <= 0) {
                //increasing the current
                i++;
                if (i > wave) {
                    //exit the program if all the waves were completed
                    System.out.println("You have completed all " + wave + " waves. You have cleared the game!");
                    state = false;
                    return;
                }
                //generating a new random value for the monster for the next wave
                randomMonster = new Random().nextInt(string2.length - 1);

                //generating new monster
                monster = new Monster(string2[randomMonster]);
            }

            //printing the current wave and the details of the monster
            System.out.println("Wave " + i + " out of " + wave);
            System.out.println(monster.toString());

            // initializing the boolean monsterLife for 2nd while
            boolean monsterLife = true;

            while (monsterLife) {

                //initializing the variables at each run
                playerStatus = 1;
                monsterStatus = 1;

                //displaying the options
                menuList();

                //reading the option from the console
                choice = scanner.nextInt();

                //using switch to implement the user's choice
                switch (choice) {
                    case 1:
                        //calling the function to update the variables
                        attack(player, monster);

                        //checking the changes made by the functions
                        if (playerStatus != -1 && monsterStatus != -1) {
                            //if both the player and the monster have HP left, display the updated details
                            System.out.print("Damage dealt: " + monsterStatus + "\t");
                            System.out.print("Damage received: " + playerStatus + "\n");
                            System.out.println("Remaining player HP: " + player.getLifePoints() + "\t Monster HP: " + monster.getLifePoints());
                        } else if (playerStatus == -1) {
                            //if the player died, close the game
                            System.out.println(player.getName() + " died. Game over!\n");
                            monsterStatus = 0;
                            state = false;
                            return;
                        } else if (monsterStatus == -1) {
                            //if the monster died, display message
                            System.out.println(monster.getName() + " defeated. Remaining HP: " + player.getLifePoints() + "\n");
                            break;
                        }
                        break;
                    case 2:
                        player.usePotion();
                        break;
                    case 3:
                        //displaying message that the game finished and changing variables to stop the run of the while methods
                        System.out.println("You have quit the game. Thank you for playing.");
                        monsterStatus = -1;
                        state = false;
                        return;
                    default:
                        System.out.println("Invalid option.");
                        break;

                }
                //checking if the monster was defeated\ game was closed and changing boolean
                if (monsterStatus <= 0) {
                    monsterLife = false;
                }

            }
        }
    }

    public static void gameOpening() {
        System.out.println("Welcome to the Dungeon Stream! \n");
    }

    public static void menuList() {
        System.out.println("\nWhat do you do?\n" +
                "1. Attack.\t" +
                "2. Drink Health Potion.\t" +
                "3. Quit.");
    }

    public static void weaponList() {
        //printing the list of available weapons using the for method
        System.out.println("Available weapons:");
        for (int j = 0; j < string1.length; j++) {
            System.out.println(j + 1 + ". " + string1[j]);
        }
        System.out.println("Select option: ");
    }

    public static void attack(Player p, Monster m) {
        //calling the functions and saving the values
        playerStatus = p.playerDamage();
        monsterStatus = m.monsterDamage();
    }


}
