package Ejercicio_11;

import java.util.Date;

public class CuentaBancaria {
    protected String titular;
    protected Date fechaApertura;
    protected String numeroCuenta;
    protected double saldo;

    public CuentaBancaria(String titular, Date fechaApertura, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void retirarDinero(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("No hay suficiente saldo para retirar.");
        }
    }

    public void ingresarDinero(double cantidad) {
        saldo += cantidad;
    }

    public void transferirDinero(CuentaBancaria otraCuenta, double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            otraCuenta.ingresarDinero(cantidad);
        } else {
            System.out.println("No hay suficiente saldo para transferir.");
        }
    }

}