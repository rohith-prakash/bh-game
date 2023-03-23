package org.example.dice;

import org.example.common.Constants;

public class RandomDice implements Dice {
    @Override
    public int getNum() {
        return (int) ((Math.random() * (Constants.diceMaximumVal - Constants.diceMinimumVal)) + Constants.diceMinimumVal);
    }
}
