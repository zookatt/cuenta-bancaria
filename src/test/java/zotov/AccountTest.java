package zotov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    @Test
    void depositShouldIncreaseBalanceAndCount() {
        Account account = new Account(100.0f, 3.0f);
        account.deposit(50.0f);
        assertEquals(150.0f, account.balance, 0.0001f);
        assertEquals(1, account.numberOfDeposits);
    }

    @Test
    void withdrawShouldDecreaseBalanceAndCount() {
        Account account = new Account(200.0f, 3.0f);
        account.withdraw(80.0f);
        assertEquals(120.0f, account.balance, 0.0001f);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void withdrawMoreThanBalanceShouldNotChangeAccount() {
        Account account = new Account(50.0f, 3.0f);
        account.withdraw(100.0f);
        assertEquals(50.0f, account.balance, 0.0001f);
        assertEquals(0, account.numberOfWithdrawals);
    }

    @Test
    void calculateMonthlyStatementShouldApplyFeeAndInterest() {
        Account account = new Account(1000.0f, 12.0f);
        account.monthlyFee = 10.0f;
        account.calculateMonthlyStatement();
        float expectedBalance = (1000.0f - 10.0f) + ((1000.0f - 10.0f) * (12.0f / 12) / 100);
        assertEquals(expectedBalance, account.balance, 0.0001f);
    }

    @Test
    void printShouldContainAccountSummary() {
        Account account = new Account(500.0f, 5.0f);
        account.monthlyFee = 4.0f;
        account.deposit(100.0f);
        account.withdraw(50.0f);
        String printed = account.print();
        assertTrue(printed.contains("Balance: 550.0"));
        assertTrue(printed.contains("Number of deposits: 1"));
        assertTrue(printed.contains("Number of withdrawals: 1"));
        assertTrue(printed.contains("Annual interest rate: 5.0"));
        assertTrue(printed.contains("Monthly fee: 4.0"));
    }
}
