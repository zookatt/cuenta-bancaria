package zotov;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    void shouldWithdrawWithoutOverdraft() {
        CurrentAccount account = new CurrentAccount(1000.0f, 0.0f);
        account.withdraw(300.0f);
        assertEquals(700.0f, account.balance, 0.001f);
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void shouldCreateOverdraftWhenWithdrawalExceedsBalance() {
        CurrentAccount account = new CurrentAccount(1000.0f, 0.0f);
        account.withdraw(1500.0f);
        assertEquals(0.0f, account.balance, 0.001f);
        String result = account.print();
        assertTrue(result.contains("Overdraft: 500.0"));
        assertEquals(1, account.numberOfWithdrawals);
    }

    @Test
    void shouldDepositNormallyWhenThereIsNoOverdraft() {
        CurrentAccount account = new CurrentAccount(1000.0f, 0.0f);
        account.deposit(500.0f);
        assertEquals(1500.0f, account.balance, 0.001f);
        assertEquals(1, account.numberOfDeposits);
    }

    @Test
    void shouldReduceOverdraftWhenDepositing() {
        CurrentAccount account = new CurrentAccount(1000.0f, 0.0f);
        account.withdraw(1500.0f);
        account.deposit(300.0f);
        assertEquals(0.0f, account.balance, 0.001f);
        String result = account.print();
        assertTrue(result.contains("Overdraft: 200.0"));
    }

    @Test
    void shouldEliminateOverdraftWhenDepositingEnoughMoney() {
        CurrentAccount account = new CurrentAccount(1000.0f, 0.0f);
        account.withdraw(1500.0f);
        account.deposit(800.0f);
        assertEquals(300.0f, account.balance, 0.001f);
        assertEquals(1, account.numberOfWithdrawals);
        assertEquals(1, account.numberOfDeposits);
        String result = account.print();
        assertTrue(result.contains("Overdraft: 0.0"));
    }

    @Test
    void printShouldReturnCurrentAccountInformation() {
        CurrentAccount account = new CurrentAccount(1500.0f, 12.0f);
        String result = account.print();
        assertTrue(result.contains("Balance: 1500.0"));
        assertTrue(result.contains("Monthly fee: 0.0"));
        assertTrue(result.contains("Number of transactions: 0"));
        assertTrue(result.contains("Overdraft: 0.0"));
    }
}
