package com.contents;

import java.util.Random;

public class Monster extends Character {

    //constructors
    public Monster(String name, int lifePoints) {
        //calling the constructor from the Character class to initialize
        super(name, lifePoints);
    }

    public Monster(String name){
        super(name);
    }

    //empty constructor
    public Monster() {
        super();
    }

    //copy constructor
    public Monster(Monster c) {
        super(c);
    }

    @Override
    public String toString() {
        return "A " + this.getName() + " has appeared. HP: " + this.getLifePoints();
    }

    public boolean monsterDamage(int damage) {
        //checking if the damage is greater than the remaining life
        int value = this.getLifePoints() - damage;
        if (value <= 0) {
            //if so, set life points to 0 and return false
            this.setLifePoints(0);
            System.out.println(this.getName() + " defeated.");
            return false;
        } else {
            //else updating life points and return true
            this.setLifePoints(value);
            return true;
        }
    }

    //overloading the initial method
    public int monsterDamage() {
        //generating a random number for damage
        Random r = new Random();
        int random = r.nextInt(30) + 40;
        //setting life points after taking damage and returning an int to check if HP is 0 or not
        if (this.getLifePoints() - random < 0) {
            this.setLifePoints(0);
            return -1;
        } else {
            this.setLifePoints((this.getLifePoints() - random));
            return random;
        }
    }
}
