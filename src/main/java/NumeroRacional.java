import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumeroRacional {
    private int numerador;
    private int denominador;

    public NumeroRacional() {
        this(1, 1);
    }

    public NumeroRacional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    public NumeroRacional(NumeroRacional otro) {
        this.numerador = otro.numerador;
        this.denominador = otro.denominador;
    }

    public NumeroRacional sumar(NumeroRacional otro) {
        int nuevoNumerador = this.numerador * otro.denominador + this.denominador * otro.numerador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new NumeroRacional(nuevoNumerador, nuevoDenominador);
    }

    public NumeroRacional restar(NumeroRacional otro) {
        int nuevoNumerador = this.numerador * otro.denominador - this.denominador * otro.numerador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return new NumeroRacional(nuevoNumerador, nuevoDenominador);
    }

    public NumeroRacional multiplicar(NumeroRacional otro) {
        return new NumeroRacional(this.numerador * otro.numerador, this.denominador * otro.denominador);
    }

    public NumeroRacional dividir(NumeroRacional otro) {
        return new NumeroRacional(this.numerador * otro.denominador, this.denominador * otro.numerador);
    }

    private void simplificar() {
        int gcd = gcd(numerador, denominador);
        numerador /= gcd;
        denominador /= gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerador, denominador);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Números Racionales");
        frame.setLayout(new FlowLayout());

        NumeroRacional r1 = new NumeroRacional(1, 2);
        NumeroRacional r2 = new NumeroRacional(2, 3);

        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JButton btnSuma = new JButton("Sumar 1/2 + 2/3");
        JButton btnResta = new JButton("Restar 1/2 - 2/3");
        JButton btnMultiplicacion = new JButton("Multiplicar 1/2 * 2/3");
        JButton btnDivision = new JButton("Dividir 1/2 / 2/3");

        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional resultado = r1.sumar(r2);
                textArea.setText("Suma: " + resultado.toString());
            }
        });

        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional resultado = r1.restar(r2);
                textArea.setText("Resta: " + resultado.toString());
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional resultado = r1.multiplicar(r2);
                textArea.setText("Multiplicación: " + resultado.toString());
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional resultado = r1.dividir(r2);
                textArea.setText("División: " + resultado.toString());
            }
        });

        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        btnSuma.setBackground(new Color(173, 216, 230));
        btnResta.setBackground(new Color(173, 216, 230));
        btnMultiplicacion.setBackground(new Color(173, 216, 230));
        btnDivision.setBackground(new Color(173, 216, 230));
        textArea.setBackground(new Color(173, 216, 230));

        frame.add(btnSuma);
        frame.add(btnResta);
        frame.add(btnMultiplicacion);
        frame.add(btnDivision);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}