package com.contents;


public class Character {
    //declaring variables
    private String name;
    private int lifePoints;

    //constructor
    public Character(String name, int lifePoints) {
        //initializing variables using the input values
        this.name = name;
        this.lifePoints = lifePoints;
    }
    public Character(String name) {
        this.name = name;
        this.lifePoints = 100;
    }

    //empty constructor
    public Character() {
        this.name = " ";
        this.lifePoints = 100;
    }

    //copy constructor
    public Character(Character c) {
        this.name = c.name;
        this.lifePoints = c.lifePoints;
    }

    //methods to retrieve the values
    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }


    //methods to set values
    public void setName(String name) {
        this.name = name;
    }

    public void setLifePoints(int lifePoints) {
        //setting the value if positive
        if (lifePoints > 0) {
            this.lifePoints = lifePoints;
        }
    }


    //overriding the ToString method for displaying the details

    @Override
    public String toString() {
        return "Name: " + this.getName() + "; remaining health: " + this.getLifePoints();
    }
}
