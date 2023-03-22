package org.example.player;

public class PlayersNotSetException extends RuntimeException{
    public PlayersNotSetException(String message){
        super(message);
    }
}
