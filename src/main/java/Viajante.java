public class Viajante extends Empleado {
    private int viajesRealizados;

    public Viajante(int viajesRealizados) {
        this.viajesRealizados = viajesRealizados;
    }

    @Override
    public double calcularSalario() {
        return sueldoBase + viajesRealizados * 300;
    }
}