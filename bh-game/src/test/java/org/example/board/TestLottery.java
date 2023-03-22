package org.example.board;

import org.example.bank.Bank;
import org.example.board.peices.Lottery;
import org.example.common.Constants;
import org.example.player.DummyPlayer;
import org.example.player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestLottery {
    @Test
    public void test(){
        Player player = new DummyPlayer();
        Player player2 = new DummyPlayer();
        BoardPiece lottery = new Lottery();
        Bank bank = Bank.getInstance();

        assertEquals(Constants.playerInitialAmount,player.getCurrentAmount());
        assertEquals(Constants.bankInitialAmount,bank.getAmount());

        lottery.action(player,bank);
        assertEquals(Constants.bankInitialAmount-Constants.lotteryPrizeAmount,bank.getAmount());
        assertEquals(Constants.playerInitialAmount+Constants.lotteryPrizeAmount,player.getCurrentAmount());

        assertEquals(Constants.playerInitialAmount,player2.getCurrentAmount());
        int bankAmount = bank.getAmount();
        lottery.action(player2,bank);
        assertEquals(bankAmount,bank.getAmount());
        assertEquals(Constants.playerInitialAmount,player2.getCurrentAmount());
    }
}
