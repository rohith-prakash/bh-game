package org.example.bank;

public class Bank {
    private static Bank instance;
    private Bank(){}

    private long totalAmount;

    public static Bank getInstance(){
        if(instance == null) {
            return new Bank();
        }
        return instance;
    }

    public long getAmount(){return totalAmount;}
    public void setAmount(long amount){
        if(amount < 0) throw new NoMoneyInBankException("Net amount in Bank is negative");
        this.totalAmount = amount;
    }

    public void depositAmount(long amount){this.totalAmount += amount;}
    public void takeLoan(long amount){
        if(amount > this.totalAmount) throw new NoMoneyInBankException("Net amount in Bank is negative");
        this.totalAmount -= amount;
    }
}
