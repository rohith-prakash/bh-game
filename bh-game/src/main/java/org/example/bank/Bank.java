package org.example.bank;

import org.example.common.Constants;

public class Bank {
    private static Bank instance;

    private Bank() {
        totalAmount = Constants.bankInitialAmount;
    }

    private int totalAmount;

    public static Bank getInstance() {
        if (instance == null) {
            return new Bank();
        }
        return instance;
    }

    public int getAmount() {
        return totalAmount;
    }

    public void setAmount(int amount) {
        if (amount < 0) throw new NoMoneyInBankException("Net amount in Bank is negative");
        this.totalAmount = amount;
    }

    public void depositAmount(int amount) {
        this.totalAmount += amount;
    }

    public void takeLoan(int amount) {
        if (amount > this.totalAmount) throw new NoMoneyInBankException("Net amount in Bank is negative");
        this.totalAmount -= amount;
    }
}
