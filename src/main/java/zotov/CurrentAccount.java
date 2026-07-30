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

}
// Cuenta corriente: posee un atributo de sobregiro,
// el cual se inicializa en cero.

// Se redefinen los siguientes métodos:
// Retirar: se retira dinero de la cuenta actualizando su saldo.
// Se puede retirar dinero superior al saldo. El dinero
// que se debe queda como sobregiro.
// Consignar: invoca al método heredado. Si hay sobregiro,
// la cantidad consignada reduce el sobregiro.
// Extracto mensual: invoca al método heredado.
// Un nuevo método imprimir que retorna el saldo de la cuenta,
// la comisión mensual, el número de transacciones realizadas
// (suma de cantidad de consignaciones y retiros) y el valor de sobregiro.