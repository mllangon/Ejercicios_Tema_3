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

        JTextField txtRacional1 = new JTextField(10);
        JTextField txtRacional2 = new JTextField(10);
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JButton btnSuma = new JButton("Sumar");
        JButton btnResta = new JButton("Restar");
        JButton btnMultiplicacion = new JButton("Multiplicar");
        JButton btnDivision = new JButton("Dividir");

        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional r1 = parseRacional(txtRacional1.getText());
                NumeroRacional r2 = parseRacional(txtRacional2.getText());
                NumeroRacional resultado = r1.sumar(r2);
                textArea.setText("Suma: " + resultado.toString());
            }
        });

        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional r1 = parseRacional(txtRacional1.getText());
                NumeroRacional r2 = parseRacional(txtRacional2.getText());
                NumeroRacional resultado = r1.restar(r2);
                textArea.setText("Resta: " + resultado.toString());
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional r1 = parseRacional(txtRacional1.getText());
                NumeroRacional r2 = parseRacional(txtRacional2.getText());
                NumeroRacional resultado = r1.multiplicar(r2);
                textArea.setText("Multiplicación: " + resultado.toString());
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroRacional r1 = parseRacional(txtRacional1.getText());
                NumeroRacional r2 = parseRacional(txtRacional2.getText());
                NumeroRacional resultado = r1.dividir(r2);
                textArea.setText("División: " + resultado.toString());
            }
        });

        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        txtRacional1.setBackground(new Color(173, 216, 230));
        txtRacional2.setBackground(new Color(173, 216, 230));
        btnSuma.setBackground(new Color(173, 216, 230));
        btnResta.setBackground(new Color(173, 216, 230));
        btnMultiplicacion.setBackground(new Color(173, 216, 230));
        btnDivision.setBackground(new Color(173, 216, 230));
        textArea.setBackground(new Color(173, 216, 230));

        frame.add(new JLabel("Racional 1 (x/y):"));
        frame.add(txtRacional1);
        frame.add(new JLabel("Racional 2 (x/y):"));
        frame.add(txtRacional2);
        frame.add(btnSuma);
        frame.add(btnResta);
        frame.add(btnMultiplicacion);
        frame.add(btnDivision);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static NumeroRacional parseRacional(String s) {
        String[] parts = s.split("/");
        int numerador = Integer.parseInt(parts[0]);
        int denominador = Integer.parseInt(parts[1]);
        return new NumeroRacional(numerador, denominador);
    }
}