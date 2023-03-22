package org.example.board;

import org.example.bank.Bank;
import org.example.player.Player;

public interface BoardPiece {
    public void action(Player player, Bank bank);
}
