package org.example.board;

import org.example.bank.Bank;
import org.example.board.peices.Hotel;
import org.example.common.Constants;
import org.example.player.DummyPlayer;
import org.example.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHotel {
    @Test
    public void test() {
        BoardPiece hotel = new Hotel();
        Player player1 = new DummyPlayer();
        Player player2 = new DummyPlayer();
        Bank bank = Bank.getInstance();

        assertEquals(0, player1.getMoneyFromProperty());
        assertEquals(0, player2.getMoneyFromProperty());

        assertEquals(Constants.bankInitialAmount, bank.getAmount());
        assertEquals(Constants.playerInitialAmount, player1.getCurrentAmount());

        hotel.action(player1, bank);

        assertEquals(Constants.playerInitialAmount - Constants.silverHotelValue, player1.getCurrentAmount());
        assertEquals(Constants.bankInitialAmount + Constants.silverHotelValue, bank.getAmount());
        assertEquals(Constants.silverHotelValue, player1.getMoneyFromProperty());

        assertEquals(Constants.playerInitialAmount, player2.getCurrentAmount());

        int player1Amount = player1.getCurrentAmount();
        hotel.action(player2, bank);
        assertEquals(Constants.playerInitialAmount - Constants.silverHotelRent, player2.getCurrentAmount());
        assertEquals(player1Amount + Constants.silverHotelRent, player1.getCurrentAmount());

        player1Amount = player1.getCurrentAmount();
        int bankAmount = bank.getAmount();
        hotel.action(player1, bank);
        assertEquals(player1Amount - Constants.goldHotelValue + Constants.silverHotelValue, player1.getCurrentAmount());
        assertEquals(bankAmount + Constants.goldHotelValue - Constants.silverHotelValue, bank.getAmount());
        assertEquals(Constants.goldHotelValue, player1.getMoneyFromProperty());

        player1Amount = player1.getCurrentAmount();
        int player2Amount = player2.getCurrentAmount();
        hotel.action(player2, bank);
        assertEquals(player2Amount - Constants.goldHotelRent, player2.getCurrentAmount());
        assertEquals(player1Amount + Constants.goldHotelRent, player1.getCurrentAmount());

    }
}
