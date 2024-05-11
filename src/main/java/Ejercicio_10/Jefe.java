package Ejercicio_10;

public class Jefe extends Empleado {
    private int anosJefe;

    public Jefe(int anosJefe) {
        this.anosJefe = anosJefe;
    }

    @Override
    public double calcularSalario() {
        return sueldoBase + anosJefe * 500;
    }
}