package org.example.board;

import org.example.bank.Bank;
import org.example.board.peices.EmptyCell;
import org.example.board.peices.Hotel;
import org.example.board.peices.Jail;
import org.example.board.peices.Lottery;
import org.example.common.Constants;
import org.example.dice.Dice;
import org.example.player.ComparePlayerWealth;
import org.example.player.InvalidPlayerAmountException;
import org.example.player.Player;
import org.example.player.PlayersNotSetException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Board {
    private int countJail = -1, countHotel = -1, countLottery = -1, countEmptyCell = -1;
    private List<BoardPiece> pieces;

    private List<Player> players;
    private List<Integer> playerPositions;

    private List<Integer> playerTurnsCount;

    private int currentPlayer = 0;
    private Dice dice;
    private Bank bank = Bank.getInstance();

    public Board() {
        Random random = new Random();
        countHotel = Constants.minimumCountOfPiece + random.nextInt(Constants.maximumCountOfPiece - Constants.minimumCountOfPiece + 1);
        countHotel = Constants.minimumCountOfPiece + random.nextInt(Constants.maximumCountOfPiece - Constants.minimumCountOfPiece + 1);
        countHotel = Constants.minimumCountOfPiece + random.nextInt(Constants.maximumCountOfPiece - Constants.minimumCountOfPiece + 1);
        countEmptyCell = Constants.minimumCountOfPiece + random.nextInt(Constants.maximumCountOfPiece - Constants.minimumCountOfPiece + 1);
    }

    public Board(int countJail, int countHotel, int countLottery, int countEmptyCell) {
        if (countJail <= 0 || countHotel <= 0 || countLottery <= 0 || countEmptyCell <= 0)
            throw new InvalidBoardPieceCountException("Board Piece can only have positive integers as value");
        this.countJail = countJail;
        this.countHotel = countHotel;
        this.countLottery = countLottery;
        this.countEmptyCell = countEmptyCell;
    }

    public void setCountJail(int countJail) {
        if (countJail < 0)
            throw new InvalidBoardPieceCountException("Board Piece can only have positive integers as value");
        this.countJail = countJail;
    }

    public void setCountHotel(int countHotel) {
        if (countHotel < 0)
            throw new InvalidBoardPieceCountException("Board Piece can only have positive integers as value");
        this.countHotel = countHotel;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void setCountLottery(int countLottery) {
        if (countLottery < 0)
            throw new InvalidBoardPieceCountException("Board Piece can only have positive integers as value");
        this.countLottery = countLottery;
    }

    public void setPieces(List<BoardPiece> pieces) {
        this.pieces = pieces;
    }

    public void setRandomBoardPieces() {
        pieces = new ArrayList<>();
        for (int i = 0; i < countJail; i++)
            pieces.add(new Jail());
        for (int i = 0; i < countHotel; i++)
            pieces.add(new Hotel());
        for (int i = 0; i < countLottery; i++)
            pieces.add(new Lottery());
        for (int i = 0; i < countEmptyCell; i++)
            pieces.add(new EmptyCell());
        Collections.shuffle(pieces);
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void initializeForGame() {
        currentPlayer = 0;
        if (players == null) throw new PlayersNotSetException("Players not set exception");
        if (players.size() < 2) throw new PlayersNotSetException("Too few players to play game");
        if (dice == null) throw new PlayersNotSetException("Dice not Set");
        playerPositions = new ArrayList<Integer>(Collections.nCopies(players.size(), -1));
        playerTurnsCount = new ArrayList<Integer>(Collections.nCopies(players.size(), 0));
        if (pieces == null) setRandomBoardPieces();
    }

    private boolean gameCompleted() {
        return playerTurnsCount.stream().allMatch(turn -> turn >= Constants.maximumNumberOfTurns);
    }

    public int playGame() {
        while (!gameCompleted()) {
            if (playerTurnsCount.get(currentPlayer) < Constants.maximumNumberOfTurns) {
                Player player = players.get(currentPlayer);
                int diceNum = dice.getNum();
                int position = (playerPositions.get(currentPlayer) + diceNum) % pieces.size();
                playerPositions.set(currentPlayer, position);
                try {
                    pieces.get(position).action(player, bank);
                } catch (InvalidPlayerAmountException e) {
                    System.out.println("Player " + currentPlayer + 1 + "Doesn't have enough money and so can't do this time");
                }
                playerTurnsCount.set(currentPlayer, playerTurnsCount.get(currentPlayer) + 1);
                currentPlayer = (currentPlayer + 1) % players.size();
            }
        }
        return getWinnerIndex();
    }

    private Integer getWinnerIndex() {
        Player winner = Collections.max(players, new ComparePlayerWealth());
        return players.indexOf(winner);
    }

    @Override
    public String toString() {
        return "[" + String.join(",", pieces.stream().map(piece -> piece.toString()).collect(Collectors.toList())) + "]";
    }
}
