package org.example.board;

import org.example.bank.Bank;
import org.example.common.Constants;
import org.example.player.Player;

public class Jail implements BoardPiece{
    private static final long fineAmount = Constants.jailFineAmount;
    public void action(Player player, Bank bank){
        player.setCurrentAmount(player.getCurrentAmount()-fineAmount);
        bank.depositAmount(fineAmount);
    }

}
