package zotov;

public class Account {
    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENTAGE_DIVISOR = 100;

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
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR;
        float interest = balance * (monthlyInterestRate / PERCENTAGE_DIVISOR);
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
