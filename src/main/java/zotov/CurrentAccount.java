package zotov;

public class CurrentAccount extends Account {
    private float overdraft = 0.0f;

    public CurrentAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            overdraft = amount - balance;
            balance = 0;
        }
        numberOfWithdrawals++;
    }

    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
                super.deposit(amount);
            } else {
                overdraft -= amount;
                numberOfDeposits++;
            }
        } else {
            super.deposit(amount);
        }
    }

    public void calculateMonthlyStatement() {
        super.calculateMonthlyStatement();
    }

    public String print() {
        int numberOfTransactions = numberOfDeposits + numberOfWithdrawals;
        return "Balance: " + balance +
                "\nMonthly fee: " + monthlyFee +
                "\nNumber of transactions: " + numberOfTransactions +
                "\nOverdraft: " + overdraft;
    }

}