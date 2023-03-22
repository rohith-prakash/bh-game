package org.example.board;

import org.example.bank.Bank;
import org.example.common.Constants;
import org.example.player.Player;

public class Lottery implements BoardPiece{
    private final long prizeAmount = Constants.lotteryPrizeAmount;
    public void action(Player player, Bank bank){
        bank.takeLoan(prizeAmount);
        player.setCurrentAmount(player.getCurrentAmount()+prizeAmount);
    }
}
