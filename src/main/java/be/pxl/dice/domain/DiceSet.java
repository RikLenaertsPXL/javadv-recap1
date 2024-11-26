package be.pxl.dice.domain;

import java.util.ArrayList;
import java.util.List;

public class DiceSet implements Rollable {
    private final int sidesOnEachDie;
    private final int numberOfDice;
    private Die[] diceSet;

    public DiceSet(int sidesOnEachDie, int numberOfDice) {
        this.sidesOnEachDie = sidesOnEachDie;
        if (numberOfDice < 2) {
            throw new IllegalArgumentException("Number of dice must be at least 2. You have: " + numberOfDice);
        }
        this.numberOfDice = numberOfDice;

        diceSet = new Die[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {
            diceSet[i] = new Die(this.sidesOnEachDie);
        }
    }

    public String getDescripton() {
        return String.format("%dd%d", numberOfDice, sidesOnEachDie);
    }

    public int sum() {
        int sum = 0;
        for (Die die : diceSet) {
            sum += die.getValue();
        }
        return sum;
    }

    @Override
    public void roll() {
        for (Die die : diceSet) {
            die.roll();
        }
    }

    public void rollIndividual(int i) {
        if (i < 0 || i >= diceSet.length){
            throw new IllegalArgumentException("Index must be greater than zero and less than length of diceset. You have: " + i);
        }
        diceSet[i].roll();
    }

    public int getIndividual(int i) {
        if (i < 0 || i >= diceSet.length){
            throw new IllegalArgumentException("Index must be greater than zero and less than length of diceset. You have: " + i);
        }
        return diceSet[i].getValue();
    }

    public void setIndividual(int i, int value) {
        if (i < 0 || i >= diceSet.length) {
            throw new IllegalArgumentException("Index must be greater than zero and less than length of diceset. You have: " + i);
        }
        diceSet[i].setValue(value);
    }

    public List<Integer> values() {
        List<Integer> values = new ArrayList<>();
        for (Die die : diceSet) {
            values.add(die.getValue());
        }
        return values;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Die die : diceSet) {
            sb.append(die.toString());
        }
       return sb.toString();
    }
}
