package Ejercicio_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class NewtonRaphsonGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Newton-Raphson");
        frame.setLayout(new FlowLayout());

        JTextField inputX0 = new JTextField(10);
        JTextField inputEpsilon = new JTextField(10);
        JTextField inputMaxIter = new JTextField(10);

        JButton btnCalcular = new JButton("Calcular");

        btnCalcular.setBackground(new Color(173, 216, 230));

        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double x0 = Double.parseDouble(inputX0.getText());
                double epsilon = Double.parseDouble(inputEpsilon.getText());
                int maxIter = Integer.parseInt(inputMaxIter.getText());

                Function<Double, Double> f = x -> Math.pow(x, 3) - x - 2;
                Function<Double, Double> df = x -> 3 * Math.pow(x, 2) - 1;
                try {
                    double raiz = newtonRaphson(x0, epsilon, maxIter, f, df);
                    textArea.setText("Raíz encontrada: " + raiz);
                } catch (IllegalArgumentException ex) {
                    textArea.setText(ex.getMessage());
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230));
        panel.add(new JLabel("x0:"));
        panel.add(inputX0);
        panel.add(new JLabel("Epsilon:"));
        panel.add(inputEpsilon);
        panel.add(new JLabel("Máx. Iteraciones:"));
        panel.add(inputMaxIter);
        panel.add(btnCalcular);
        panel.add(new JScrollPane(textArea));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static double newtonRaphson(double x0, double epsilon, int maxIter, Function<Double, Double> f, Function<Double, Double> df) {
        double x = x0;
        int iter = 0;
        while (Math.abs(f.apply(x)) > epsilon && iter < maxIter) {
            x = x - f.apply(x) / df.apply(x);
            iter++;
        }
        if (iter == maxIter) {
            throw new IllegalArgumentException("El algoritmo no convergió después de " + maxIter + " iteraciones.");
        }
        return x;
    }
}