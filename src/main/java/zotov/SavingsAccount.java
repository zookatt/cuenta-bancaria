package zotov;

public class SavingsAccount extends Account {
    private static final float MINIMUM_ACTIVE_BALANCE = 10000.0f;
    private static final int FREE_WITHDRAWALS_LIMIT = 4;
    private static final float EXTRA_WITHDRAWAL_FEE = 1000.0f;

    private boolean active;

    private void updateActiveStatus() {
        active = balance >= MINIMUM_ACTIVE_BALANCE;
    }

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        updateActiveStatus();
    }

    public void deposit(float amount) {
        if (active) {
            super.deposit(amount);
        } else {
            System.err.println("The account is inactive");
        }
    }

    public void withdraw(float amount) {
        if (active) {
            super.withdraw(amount);
        } else {
            System.err.println("The account is inactive");
        }
    }

    public void calculateMonthlyStatement() {
        if (numberOfWithdrawals > FREE_WITHDRAWALS_LIMIT) {
            monthlyFee += (numberOfWithdrawals - FREE_WITHDRAWALS_LIMIT) * EXTRA_WITHDRAWAL_FEE;
        }

        super.calculateMonthlyStatement();
        updateActiveStatus();
    }

    public String print() {
        int transactions = numberOfDeposits + numberOfWithdrawals;

        return "Balance: " + balance +
                "\nMonthly fee: " + monthlyFee +
                "\nNumber of transactions: " + transactions;
    }
}
