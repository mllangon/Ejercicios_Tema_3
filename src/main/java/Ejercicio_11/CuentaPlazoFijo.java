package Ejercicio_11;

import java.util.Date;

public class CuentaPlazoFijo extends CuentaBancaria {
    private Date fechaVencimiento;

    public CuentaPlazoFijo(String titular, Date fechaApertura, String numeroCuenta, double saldo, Date fechaVencimiento) {
        super(titular, fechaApertura, numeroCuenta, saldo);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public void retirarDinero(double cantidad) {
        if (new Date().before(fechaVencimiento)) {
            cantidad += cantidad * 0.05; // Penalización del 5%
        }
        super.retirarDinero(cantidad);
    }
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
}