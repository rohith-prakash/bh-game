package org.example.player;

import java.util.Comparator;

public class ComparePlayerWealth implements Comparator<Player> {
    public int compare(Player player1, Player player2) {
        return (player1.getCurrentAmount() + player1.getMoneyFromProperty()) - (player2.getCurrentAmount() + player1.getMoneyFromProperty());
    }
}
