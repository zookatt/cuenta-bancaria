package zotov;

public class SavingsAccount extends Account {
    private boolean active;

    private void updateActiveStatus() {
        active = balance >= 10000;
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
        if (numberOfWithdrawals > 4) {
            monthlyFee += (numberOfWithdrawals - 4) * 1000;
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
