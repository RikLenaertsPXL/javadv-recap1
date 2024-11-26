package be.pxl.dice.service;

import be.pxl.dice.domain.DiceSet;
import org.springframework.stereotype.Service;

@Service
public class DiceSetService {
    private DiceSet diceSet;
    private int highestSum = 0;

    public void createDiceSet(int sides, int numberOfDice) {
        diceSet = new DiceSet(sides, numberOfDice);
    }

    public String getDiceSet() {
        return diceSet.toString();
    }

    public String rollAllDice() {
        diceSet.roll();
        if (highestSum < diceSet.sum()) {
            highestSum = diceSet.sum();
        }
        return diceSet.toString();
    }

    public String rollSingleDie(int index) {
        diceSet.rollIndividual(index);
        if (highestSum < diceSet.sum()) {
            highestSum = diceSet.sum();
        }
        return diceSet.toString();
    }

    public int getHighestSum() {
        return highestSum;
    }
}
