import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumeroComplejo {
    private double parteReal;
    private double parteImaginaria;

    // Constructor por defecto que inicializa un número complejo en 0 + 0i
    public NumeroComplejo() {
        this(0, 0);
    }

    // Constructor que acepta parte real e imaginaria
    public NumeroComplejo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    // Método para sumar dos números complejos
    public NumeroComplejo sumar(NumeroComplejo otro) {
        return new NumeroComplejo(
                this.parteReal + otro.parteReal,
                this.parteImaginaria + otro.parteImaginaria
        );
    }

    // Método para multiplicar dos números complejos
    public NumeroComplejo multiplicar(NumeroComplejo otro) {
        double nuevaParteReal = this.parteReal * otro.parteReal - this.parteImaginaria * otro.parteImaginaria;
        double nuevaParteImaginaria = this.parteReal * otro.parteImaginaria + this.parteImaginaria * otro.parteReal;
        return new NumeroComplejo(nuevaParteReal, nuevaParteImaginaria);
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", parteReal, parteImaginaria);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Números Complejos");
        frame.setLayout(new FlowLayout());

        NumeroComplejo c1 = new NumeroComplejo(3, 2);
        NumeroComplejo c2 = new NumeroComplejo(1, 7);

        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JButton btnSuma = new JButton("Sumar (3+2i) + (1+7i)");
        JButton btnMultiplicacion = new JButton("Multiplicar (3+2i) * (1+7i)");

        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroComplejo resultado = c1.sumar(c2);
                textArea.setText("Suma: " + resultado.toString());
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroComplejo resultado = c1.multiplicar(c2);
                textArea.setText("Multiplicación: " + resultado.toString());
            }
        });

        frame.add(btnSuma);
        frame.add(btnMultiplicacion);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
