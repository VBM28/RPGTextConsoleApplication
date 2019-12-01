package com.contents;


import java.util.Random;

public class Player extends Character {
    private String weapon;
    private int healthPotion;

    //constructor
    public Player(String name, int lifePoints, String weapon, int healthPotion) {
        super(name, lifePoints);
        this.weapon = weapon;
        this.healthPotion = healthPotion;
    }

    public Player(String name, String weapon, int healthPotion){
        super(name);
        this.weapon = weapon;
        this.healthPotion = healthPotion;
    }

    //empty constructor
    public Player() {
        super();
        this.weapon = " ";
        this.healthPotion = 3 + new Random().nextInt(2);
    }

    //copy constructor
    public Player(Player c) {
        super(c);
        this.weapon = c.weapon;
        this.healthPotion = c.healthPotion;
    }

    //methods to retrieve the values
    public String getWeapon() {
        return weapon;
    }

    public int getHealthPotion() {
        return healthPotion;
    }

    //methods to set values

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setHealthPotion(int healthPotion) {
        //checking if the number is positive, and setting it if so
        if (healthPotion > 0) {
            this.healthPotion = healthPotion;
        }
    }

    //overriding the ToString method do display the player's details


    @Override
    public String toString() {
        return "Player name: " + this.getName() +
                "\tWeapon: " + this.getWeapon() +
                "\t Remaining health: " + this.getLifePoints()
                + "\t Health potions: " + this.getHealthPotion();
    }

    public boolean playerDamage(int damage) {
        //checking if the damage is higher than the remaining life
        if (this.getLifePoints() - damage <= 0) {
            //if so, set life to 0 and return false
            this.setLifePoints(0);
            System.out.println("DEAD");
            return false;
        } else {
            //else updating the life points and confirming it
            this.setLifePoints(this.getLifePoints() - damage);
            return true;
        }
    }

    //overloading the initial method
    public int playerDamage() {
        //generating a random number for damage
        int random = new Random().nextInt(20) + 10;
        //setting life points after taking damage and returning an int to check if HP is 0 or not
        if (this.getLifePoints() - random < 0) {
            this.setLifePoints(0);
            return -1;
        } else {
            this.setLifePoints((this.getLifePoints() - random));
            return random;
        }
    }

    public void usePotion() {
        //checking if there are health potions left
        if (this.healthPotion - 1 > 0) {
            //updating the life points and number of potions
            //in case the use of potion exceeds the maximum health value, set life points to 100
            if (this.getLifePoints() + 50 > 100) {
                this.setLifePoints(100);
            } else {
                this.setLifePoints(this.getLifePoints() + 50);
            }
            this.healthPotion--;
            System.out.println("Health potion used. " + this.healthPotion
                    + " potions remaining. Current HP: " + this.getLifePoints());
        } else {
            System.out.println("You are don't have any health potions left");
        }
    }
}
