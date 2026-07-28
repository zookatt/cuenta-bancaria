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
}

// Desarrollar un programa que modele una cuenta bancaria que tiene
// los siguientes atributos, que deben ser de acceso protegido:

// Saldo, de tipo float.
// Número de consignaciones con valor inicial cero, de tipo int.
// Número de retiros con valor inicial cero, de tipo int.
// Tasa anual (porcentaje), de tipo float.
// Comisión mensual con valor inicial cero, de tipo float.

// La clase Cuenta tiene un constructor que inicializa los atributos saldo y
// tasa anual con valores pasados como parámetros.

// La clase Cuenta tiene los
// siguientes métodos:
// - Consignar una cantidad de dinero en la cuenta actualizando su saldo.
// - Retirar una cantidad de dinero en la cuenta actualizando su saldo. El valor
// a retirar no debe superar el saldo.
// - Calcular el interés mensual de la cuenta y actualiza el saldo
// correspondiente.
// - Extracto mensual: actualiza el saldo restándole la comisión mensual y
// calculando el interés mensual correspondiente (invoca el método anterior).
// - Imprimir: retorno los valores de los atributos