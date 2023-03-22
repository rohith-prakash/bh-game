package org.example.board;

public class PlayersNotSetException extends RuntimeException{
    public PlayersNotSetException(String message){
        super(message);
    }
}
