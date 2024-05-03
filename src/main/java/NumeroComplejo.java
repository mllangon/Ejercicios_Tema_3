import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumeroComplejo {
    private double parteReal;
    private double parteImaginaria;

    public NumeroComplejo() {
        this(0, 0);
    }

    public NumeroComplejo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public NumeroComplejo(NumeroComplejo otro) {
        this.parteReal = otro.parteReal;
        this.parteImaginaria = otro.parteImaginaria;
    }

    public NumeroComplejo sumar(NumeroComplejo otro) {
        return new NumeroComplejo(
                this.parteReal + otro.parteReal,
                this.parteImaginaria + otro.parteImaginaria
        );
    }

    public NumeroComplejo restar(NumeroComplejo otro) {
        return new NumeroComplejo(
                this.parteReal - otro.parteReal,
                this.parteImaginaria - otro.parteImaginaria
        );
    }

    public NumeroComplejo multiplicar(NumeroComplejo otro) {
        double nuevaParteReal = this.parteReal * otro.parteReal - this.parteImaginaria * otro.parteImaginaria;
        double nuevaParteImaginaria = this.parteReal * otro.parteImaginaria + this.parteImaginaria * otro.parteReal;
        return new NumeroComplejo(nuevaParteReal, nuevaParteImaginaria);
    }

    public NumeroComplejo dividir(NumeroComplejo otro) {
        double nuevaParteReal = (this.parteReal * otro.parteReal + this.parteImaginaria * otro.parteImaginaria) / (Math.pow(otro.parteReal, 2) + Math.pow(otro.parteImaginaria, 2));
        double nuevaParteImaginaria = (this.parteImaginaria * otro.parteReal - this.parteReal * otro.parteImaginaria) / (Math.pow(otro.parteReal, 2) + Math.pow(otro.parteImaginaria, 2));
        return new NumeroComplejo(nuevaParteReal, nuevaParteImaginaria);
    }

    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", parteReal, parteImaginaria);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Números Complejos");
        frame.setLayout(new FlowLayout());

        JTextField txtComplejo1 = new JTextField(10);
        JTextField txtComplejo2 = new JTextField(10);
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JButton btnSuma = new JButton("Sumar");
        JButton btnResta = new JButton("Restar");
        JButton btnMultiplicacion = new JButton("Multiplicar");
        JButton btnDivision = new JButton("Dividir");

        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroComplejo c1 = parseComplejo(txtComplejo1.getText());
                NumeroComplejo c2 = parseComplejo(txtComplejo2.getText());
                NumeroComplejo resultado = c1.sumar(c2);
                textArea.setText("Suma: " + resultado.toString());
            }
        });

        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroComplejo c1 = parseComplejo(txtComplejo1.getText());
                NumeroComplejo c2 = parseComplejo(txtComplejo2.getText());
                NumeroComplejo resultado = c1.restar(c2);
                textArea.setText("Resta: " + resultado.toString());
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroComplejo c1 = parseComplejo(txtComplejo1.getText());
                NumeroComplejo c2 = parseComplejo(txtComplejo2.getText());
                NumeroComplejo resultado = c1.multiplicar(c2);
                textArea.setText("Multiplicación: " + resultado.toString());
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NumeroComplejo c1 = parseComplejo(txtComplejo1.getText());
                NumeroComplejo c2 = parseComplejo(txtComplejo2.getText());
                NumeroComplejo resultado = c1.dividir(c2);
                textArea.setText("División: " + resultado.toString());
            }
        });

        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        txtComplejo1.setBackground(new Color(173, 216, 230));
        txtComplejo2.setBackground(new Color(173, 216, 230));
        btnSuma.setBackground(new Color(173, 216, 230));
        btnResta.setBackground(new Color(173, 216, 230));
        btnMultiplicacion.setBackground(new Color(173, 216, 230));
        btnDivision.setBackground(new Color(173, 216, 230));
        textArea.setBackground(new Color(173, 216, 230));

        frame.add(new JLabel("Complejo 1 (x+yi):"));
        frame.add(txtComplejo1);
        frame.add(new JLabel("Complejo 2 (x+yi):"));
        frame.add(txtComplejo2);
        frame.add(btnSuma);
        frame.add(btnResta);
        frame.add(btnMultiplicacion);
        frame.add(btnDivision);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static NumeroComplejo parseComplejo(String s) {
        String[] parts = s.split("\\+");
        double parteReal = Double.parseDouble(parts[0]);
        double parteImaginaria = Double.parseDouble(parts[1].replace("i", ""));
        return new NumeroComplejo(parteReal, parteImaginaria);
    }
}