package zotov;

public class Account {
    protected float balance;
    protected int numberOfDeposits = 0;
    protected int numberOfWithdrawals = 0;
    protected float annualInterestRate;
    protected float monthlyFee;

    public Account(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            numberOfDeposits++;
        }
    }

    public void withdraw(float amount) {
        if (amount <= 0) {
            System.err.println("Incorrect amount of withdraw");
        } else if (amount > balance) {
            System.err.println("No balance available to withdraw");
        } else {
            balance -= amount;
            numberOfWithdrawals++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyInterestRate = annualInterestRate / 12;
        float interest = balance * (monthlyInterestRate / 100);
        balance += interest;
    }

    public void calculateMonthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }

    public String print() {
        return "Balance: " + balance +
                "\nNumber of deposits: " + numberOfDeposits +
                "\nNumber of withdrawals: " + numberOfWithdrawals +
                "\nAnnual interest rate: " + annualInterestRate +
                "\nMonthly fee: " + monthlyFee;
    }
}