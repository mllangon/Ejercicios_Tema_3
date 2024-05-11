package Ejercicio_11;

import java.util.Date;

public class CuentaVip extends CuentaBancaria {
    private double saldoNegativoMaximo;

    public CuentaVip(String titular, Date fechaApertura, String numeroCuenta, double saldo, double saldoNegativoMaximo) {
        super(titular, fechaApertura, numeroCuenta, saldo);
        this.saldoNegativoMaximo = saldoNegativoMaximo;
    }

    @Override
    public void retirarDinero(double cantidad) {
        if (saldo - cantidad >= -saldoNegativoMaximo) {
            saldo -= cantidad;
        } else {
            System.out.println("No se puede retirar esa cantidad, se superaría el saldo negativo máximo.");
        }
    }

    @Override
    public void transferirDinero(CuentaBancaria otraCuenta, double cantidad) {
        if (saldo - cantidad >= -saldoNegativoMaximo) {
            saldo -= cantidad;
            otraCuenta.ingresarDinero(cantidad);
        } else {
            System.out.println("No se puede transferir esa cantidad, se superaría el saldo negativo máximo.");
        }
    }
    public double getSaldoNegativoMaximo() {
        return saldoNegativoMaximo;
    }
}