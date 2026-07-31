# Cuenta Bancaria

Proyecto Java desarrollado con Maven para modelar una cuenta bancaria con herencia y comportamiento diferenciado entre una cuenta de ahorros y una cuenta corriente.

## Descripción del ejercicio

Se implementa una clase base llamada `Account` con los siguientes atributos protegidos:

- saldo (`float`)
- número de consignaciones (`int`), inicializado en `0`
- número de retiros (`int`), inicializado en `0`
- tasa anual (`float`)
- comisión mensual (`float`), inicializada en `0`

La clase base incluye operaciones para:

- consignar dinero,
- retirar dinero si existe saldo suficiente,
- calcular el interés mensual,
- generar el extracto mensual,
- imprimir los datos de la cuenta.

## Clases del proyecto

### Cuenta base

- `Account.java`: define el comportamiento general de una cuenta bancaria.

### Cuenta de ahorros

- `SavingsAccount.java`: representa una cuenta de ahorros con estado activo/inactivo según el saldo.
- Si el saldo es menor a $10000, la cuenta se considera inactiva.
- El método de consignar y retirar solo funciona si la cuenta está activa.
- El extracto mensual aplica una comisión adicional si hay más de 4 retiros.

### Cuenta corriente

- `CurrentAccount.java`: representa una cuenta corriente con soporte para sobregiro.
- Permite retirar más de lo que hay en saldo, dejando el exceso como sobregiro.
- Al consignar dinero, el sobregiro se reduce si existe.

## Requisitos técnicos

- Java 21
- Maven
- JUnit

## Estructura del proyecto

- `src/main/java/zotov/`: clases principales del modelo.
- `src/test/java/zotov/`: pruebas unitarias.
- `diagramm-uml.drawio`: diagrama UML del proyecto.

## Pruebas unitarias

El proyecto incluye pruebas unitarias para verificar el comportamiento de las clases principales. La cobertura mínima esperada es del 70%.

## Capturas y recursos

#### Diagrama UML:

![Diagrama UML](../cuenta-bancaria/docs/images/diagramm-uml.png)

#### Cobertura de los tests:

![Cobertura de los tests](../cuenta-bancaria/docs/images/test-coverage.png)
