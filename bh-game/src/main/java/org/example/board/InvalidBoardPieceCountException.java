package org.example.board;

public class InvalidBoardPieceCountException extends RuntimeException{
    public InvalidBoardPieceCountException(String message){
        super(message);
    }
}
