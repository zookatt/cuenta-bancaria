package zotov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavingsAccountTest {

    @Test
    void shouldDepositWhenAccountIsActive() {
        SavingsAccount account = new SavingsAccount(10500.50f, 0.0f);
        account.deposit(500);
        assertEquals(11000.50f, account.balance, 0.001f);
        assertEquals(1, account.numberOfDeposits);
    }

    @Test
    void shouldNotDepositWhenAccountIsInactive() {
        SavingsAccount account = new SavingsAccount(9999.50f, 0.0f);
        account.deposit(500);
        assertEquals(9999.50f, account.balance, 0.001f);
        assertEquals(0, account.numberOfDeposits);
    }

    @Test
    void shouldWithdrawWhenAccountIsActive() {
        SavingsAccount account = new SavingsAccount(10500, 0.0f);
        account.withdraw(500);
        assertEquals(10000, account.balance, 0.001f);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void shouldNotWithdrawWhenAccountIsInactive() {
        SavingsAccount account = new SavingsAccount(9999, 0.0f);
        account.withdraw(500);
        assertEquals(9999, account.balance, 0.001f);
        assertEquals(0, account.numberOfWithdrawals);
    }

    @Test
    void shouldChargeCommissionForAdditionalWithdrawals() {
        SavingsAccount account = new SavingsAccount(20000, 12);
        for (int i = 0; i < 6; i++) {
            account.withdraw(1000);
        }
        account.calculateMonthlyStatement();
        assertEquals(2000.0f, account.monthlyFee);
    }

    @Test
    void shouldBecomeInactiveAfterMonthlyStatement() {
        SavingsAccount account = new SavingsAccount(10500, 12);
        account.withdraw(1000);
        account.calculateMonthlyStatement();
        account.deposit(500);
        assertEquals(9595.0f, account.balance);
    }

    @Test
    void printShouldReturnAccountInformation() {
        SavingsAccount account = new SavingsAccount(15000, 12);
        String result = account.print();
        assertTrue(result.contains("Balance: 15000.0"));
        assertTrue(result.contains("Monthly fee: 0.0"));
        assertTrue(result.contains("Number of transactions: 0"));
    }
}
