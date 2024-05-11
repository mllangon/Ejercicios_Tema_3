package Ejercicio_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResolvedorInteractivo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Resolvedor de Raíces Adaptativo");
        frame.setLayout(new FlowLayout());

        JTextField inputEps = new JTextField("0.001", 5);
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);


        JButton btnCalcular = new JButton("Calcular Raíz");
        btnCalcular.setBackground(new Color(173, 216, 230));// RGB para azul claro

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double eps = Double.parseDouble(inputEps.getText());

                    ResolvedorDeRaicesAdaptativo resolvedor = new ResolvedorDeRaicesAdaptativo();
                    double raiz = resolvedor.encontrarRaiz(x -> x * x * x - 1, eps);
                    textArea.setText("Raíz encontrada: " + raiz);
                } catch (Exception ex) {
                    textArea.setText("Error: " + ex.getMessage());
                }
            }
        });
        frame.add(new JLabel("Eps:"));
        frame.add(inputEps);
        frame.add(btnCalcular);
        frame.add(new JScrollPane(textArea));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}