package zotov;

public class SavingsAccount extends Account {
    private boolean active;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        active = balance >= 10000;
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

    // Cuenta de ahorros: posee un atributo para determinar si la cuenta de ahorros
    // está activa (tipo boolean). Si el saldo es menor a $10000, la cuenta está
    // inactiva, en caso contrario se considera activa. Los siguientes métodos se
    // redefinen:
    // Consignar: se puede consignar dinero si la cuenta está activa. Debe invocar
    // al método heredado.
    // Retirar: es posible retirar dinero si la cuenta está activa. Debe invocar al
    // método heredado.
    // Extracto mensual: si el número de retiros es mayor que 4, por cada retiro
    // adicional, se cobra $1000 como comisión mensual. Al generar el extracto, se
    // determina si la cuenta está activa o no con el saldo.
    // Un nuevo método imprimir que retorna el saldo de la cuenta, la comisión
    // mensual y el número de transacciones realizadas (suma de cantidad de
    // consignaciones y retiros).
}
