package Ejercicio_8;

class ResolvedorDeRaices {
    public double encontrarRaiz(Polinomio p, double x0, double x1, double eps) {
        double f0 = p.evaluar(x0);
        double f1 = p.evaluar(x1);
        if (f0 * f1 >= 0) {
            throw new IllegalArgumentException("Los valores en los extremos deben tener signos opuestos.");
        }

        double x2 = x0;
        while ((x1 - x0) / 2 > eps) {
            x2 = (x0 + x1) / 2;
            double f2 = p.evaluar(x2);

            if (Math.abs(f2) < eps) break;

            if (f2 * f0 > 0) {
                x0 = x2;
                f0 = f2;
            } else {
                x1 = x2;
            }
        }
        return x2;
    }
}