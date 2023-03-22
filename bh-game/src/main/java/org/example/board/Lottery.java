package org.example.board;

import org.example.bank.Bank;
import org.example.common.Constants;
import org.example.player.Player;

public class Lottery implements BoardPiece {
    private final int prizeAmount = Constants.lotteryPrizeAmount;

    private boolean completed;

    public Lottery(){
        completed = false;
    }

    @Override
    public void action(Player player, Bank bank) {
        if(!completed){
            completed = true;
            bank.takeLoan(prizeAmount);
            player.setCurrentAmount(player.getCurrentAmount() + prizeAmount);
        }
    }
    public String toString(){
        return "L";
    }
}
