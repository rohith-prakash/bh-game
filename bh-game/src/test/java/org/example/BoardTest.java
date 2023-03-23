package org.example;

import org.example.bank.Bank;
import org.example.board.Board;
import org.example.board.BoardPiece;
import org.example.board.peices.EmptyCell;
import org.example.board.peices.Hotel;
import org.example.board.peices.Jail;
import org.example.board.peices.Lottery;
import org.example.dice.Dice;
import org.example.dice.DummyDice;
import org.example.player.DummyPlayer;
import org.example.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BoardTest {
    private static Board board;
    private static Bank bank;
    private static Dice dice;

    private static Player player1;

    private static Player player2;
    private static Player player3;

    @BeforeAll
    public static void setUp() {
        board = new Board();
        bank = Bank.getInstance();
        player1 = new DummyPlayer();
        player2 = new DummyPlayer();
        player3 = new DummyPlayer();
        dice = new DummyDice();
    }

    @Test
    public void test() {
        player1.setCurrentAmount(1000);
        player2.setCurrentAmount(1000);
        player3.setCurrentAmount(1000);
        List<Player> players = Arrays.asList(player1, player2, player3);
        board.setPlayers(players);
        board.setDice(dice);
        List<BoardPiece> pieces = Arrays.asList(new Jail(), new Hotel(), new Lottery(), new Hotel(), new EmptyCell(), new Lottery(), new Hotel(), new Lottery(), new Hotel(), new Jail());
        board.setPieces(pieces);

        board.initializeForGame();
        bank.setAmount(5000);
        int winner = board.playGame();
        player1.printAssets(1);
        player2.printAssets(2);
        player3.printAssets(3);
        System.out.println(board.toString());
//        assertEquals(1,winner);
    }
}
