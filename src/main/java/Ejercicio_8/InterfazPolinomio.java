package Ejercicio_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterfazPolinomio {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Resolvedor de Raíces para Polinomios");
        frame.setLayout(new FlowLayout());

        JTextField inputCoeficientes = new JTextField(20);
        JTextField inputX0 = new JTextField(5);
        JTextField inputX1 = new JTextField(5);
        JTextField inputEps = new JTextField(5);
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        JButton btnCalcular = new JButton("Calcular Raíz");
        JButton btnRepresentar = new JButton("Representar Polinomio");
        btnRepresentar.setBackground(new Color(173, 216, 230)); // RGB para azul claro

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Double> coeficientes = new ArrayList<>();
                    String[] parts = inputCoeficientes.getText().split(",");
                    for (String part : parts) {
                        coeficientes.add(Double.parseDouble(part.trim()));
                    }
                    Polinomio polinomio = new Polinomio(coeficientes);
                    ResolvedorDeRaices resolvedor = new ResolvedorDeRaices();

                    double x0 = Double.parseDouble(inputX0.getText());
                    double x1 = Double.parseDouble(inputX1.getText());
                    double eps = Double.parseDouble(inputEps.getText());

                    double raiz = resolvedor.encontrarRaiz(polinomio, x0, x1, eps);
                    textArea.setText("Raíz encontrada: " + raiz);
                } catch (Exception ex) {
                    textArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        btnRepresentar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Double> coeficientes = new ArrayList<>();
                    String[] parts = inputCoeficientes.getText().split(",");
                    for (String part : parts) {
                        coeficientes.add(Double.parseDouble(part.trim()));
                    }
                    Polinomio polinomio = new Polinomio(coeficientes);
                    ResolvedorDeRaices resolvedor = new ResolvedorDeRaices();

                    double x0 = Double.parseDouble(inputX0.getText());
                    double x1 = Double.parseDouble(inputX1.getText());
                    double eps = Double.parseDouble(inputEps.getText());

                    double raiz = resolvedor.encontrarRaiz(polinomio, x0, x1, eps);
                    textArea.setText("Polinomio: " + polinomio.representar() + "\nRaíz encontrada: " + raiz);
                } catch (Exception ex) {
                    textArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        frame.add(new JLabel("Coeficientes (sep. por comas):"));
        frame.add(inputCoeficientes);
        frame.add(new JLabel("x0:"));
        frame.add(inputX0);
        frame.add(new JLabel("x1:"));
        frame.add(inputX1);
        frame.add(new JLabel("Eps:"));
        frame.add(inputEps);
        frame.add(btnCalcular);
        frame.add(btnRepresentar);
        frame.add(new JScrollPane(textArea));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}