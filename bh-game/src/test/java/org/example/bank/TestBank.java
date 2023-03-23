package org.example.bank;

import org.example.common.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBank {
    private static Bank bank;

    @BeforeAll
    public static void setUp() {
        bank = Bank.getInstance();
    }

    @Test
    public void test() {
        assertNotNull(bank);
        assertEquals(Constants.bankInitialAmount, bank.getAmount());

        int deposited = 500;
        bank.depositAmount(500);
        assertEquals(Constants.bankInitialAmount + 500, bank.getAmount());

        int loanTaken = 300;
        bank.takeLoan(300);
        assertEquals(Constants.bankInitialAmount + 200, bank.getAmount());

        bank.setAmount(0);
        assertEquals(0, bank.getAmount());

        Throwable exception = assertThrows(NoMoneyInBankException.class, () -> bank.takeLoan(1));
    }
}
