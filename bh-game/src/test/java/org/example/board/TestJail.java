package org.example.board;

import org.example.bank.Bank;
import org.example.board.peices.Jail;
import org.example.common.Constants;
import org.example.player.DummyPlayer;
import org.example.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJail {
    @Test
    public void test() {
        BoardPiece jail = new Jail();
        Bank bank = Bank.getInstance();
        Player player = new DummyPlayer();

        assertEquals(Constants.playerInitialAmount, player.getCurrentAmount());
        assertEquals(Constants.bankInitialAmount, bank.getAmount());

        jail.action(player, bank);

        assertEquals(Constants.bankInitialAmount + Constants.jailFineAmount, bank.getAmount());
        assertEquals(Constants.playerInitialAmount - Constants.jailFineAmount, player.getCurrentAmount());
    }
}
