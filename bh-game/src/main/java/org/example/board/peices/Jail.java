package org.example.board.peices;

import org.example.bank.Bank;
import org.example.board.BoardPiece;
import org.example.common.Constants;
import org.example.player.Player;

public class Jail implements BoardPiece {
    private static final int fineAmount = Constants.jailFineAmount;

    @Override
    public void action(Player player, Bank bank) {
        player.setCurrentAmount(player.getCurrentAmount() - fineAmount);
        bank.depositAmount(fineAmount);
    }

    public String toString(){
        return "J";
    }

}
