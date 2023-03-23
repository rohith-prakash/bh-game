package org.example.player;

import org.example.bank.Bank;
import org.example.board.BoardPiece;
import org.example.board.peices.Hotel;
import org.example.common.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDummyPlayer {
    private static Player player;
    private static Bank bank;

    @BeforeAll
    public static void setUp() {
        player = new DummyPlayer();
        bank = Bank.getInstance();
    }

    @Test
    public void test() {
        assertEquals(Constants.playerInitialAmount, player.getCurrentAmount());
        int newAmount = 500;
        player.setCurrentAmount(newAmount);
        assertEquals(newAmount, player.getCurrentAmount());
        assertNotNull(player.getId());

        Property property1 = new Hotel();
        Property property2 = new Hotel();

        //The owner neds to be set before calling getMoneyFromProperty
        // So testing action which calls setOwner indirectly for testing getMoneyFromProperty
        // and addProperty together
        ((BoardPiece) property1).action(player, bank);
        ((BoardPiece) property2).action(player, bank);

        assertEquals(2 * Constants.silverHotelValue, player.getMoneyFromProperty());
    }
}
