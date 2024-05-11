package Ejercicio_9;

import java.util.function.Function;

class ResolvedorDeRaicesAdaptativo {
    public double encontrarRaiz(Function<Double, Double> f, double eps) {
        double incrementoInicial = 0.1;
        double x0 = 0;
        double x1 = incrementoInicial;
        double f0 = f.apply(x0);
        double f1 = f.apply(x1);

        while (f0 * f1 > 0) {
            x0 = x1;
            f0 = f1;
            x1 += incrementoInicial;
            f1 = f.apply(x1);
            if (Math.abs(x1) > 1e6) {
                throw new IllegalArgumentException("No se encontró un intervalo adecuado.");
            }
        }

        return resolverBiseccion(f, x0, x1, eps);
    }

    private double resolverBiseccion(Function<Double, Double> f, double x0, double x1, double eps) {
        double f0 = f.apply(x0);
        double f1 = f.apply(x1);
        if (f0 * f1 >= 0) {
            throw new IllegalArgumentException("Los valores en los extremos deben tener signos opuestos.");
        }

        double x2 = x0;
        while ((x1 - x0) / 2 > eps) {
            x2 = (x0 + x1) / 2;
            double f2 = f.apply(x2);

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