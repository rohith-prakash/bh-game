package org.example.board;

import org.example.bank.Bank;
import org.example.player.Player;

public class EmptyCell implements BoardPiece{

    @Override
    public void action(Player player, Bank bank){

    }

    public String toString(){
        return "E";
    }
}
