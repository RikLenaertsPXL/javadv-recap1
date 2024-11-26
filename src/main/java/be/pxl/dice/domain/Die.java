package be.pxl.dice.domain;

import be.pxl.dice.exceptions.InvalidDieValueException;

import java.util.Random;

public class Die implements Rollable {

    private final int sides;
    private int value;

    public Die(int sides) {
        if (sides < 4) {
            throw new IllegalArgumentException("Number of sides must be at least 4. You have: " + sides);
        }
        this.sides = sides;
        value = 1;
    }

    @Override
    public void roll() {
        value = new Random().nextInt(1,sides+1);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 1 || value > sides) {
            throw new InvalidDieValueException("Value of die can't be less than 1 or greater than number of sides. You have: " + value);
        }
        this.value = value;
    }

    public int getSides() {
        return sides;
    }

    @Override
    public String toString() {
        return String.format("[%d]", value);
    }
}
