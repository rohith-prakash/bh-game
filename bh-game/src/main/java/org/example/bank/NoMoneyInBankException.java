package org.example.bank;

public class NoMoneyInBankException extends RuntimeException {
    public NoMoneyInBankException(String message){
        super(message);
    }
}
