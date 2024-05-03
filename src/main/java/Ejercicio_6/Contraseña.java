package Ejercicio_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Contraseña {
    private int longitud;
    private String contraseña;

    public Contraseña() {
        this.longitud = 8;
        this.contraseña = "password";
    }

    public Contraseña(int longitud) {
        this.longitud = longitud;
        this.contraseña = generarContraseña();
    }

    private String generarContraseña() {
        String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++)
            sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
        return sb.toString();
    }

    public boolean esFuerte() {
        int cuentasMayus = 0, cuentasMinus = 0, cuentasNums = 0;
        for (char c : contraseña.toCharArray()) {
            if (Character.isUpperCase(c)) cuentasMayus++;
            if (Character.isLowerCase(c)) cuentasMinus++;
            if (Character.isDigit(c)) cuentasNums++;
        }
        return cuentasMayus > 2 && cuentasMinus > 1 && cuentasNums > 2;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
        this.contraseña = generarContraseña();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Generador de Contraseñas");
        frame.setLayout(new FlowLayout());

        JTextField longitudInput = new JTextField(5);
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);

        JButton btnGenerar = new JButton("Generar Contraseña");
        JButton btnEvaluar = new JButton("Evaluar Fortaleza");

        Contraseña ctr = new Contraseña();

        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int longitud = Integer.parseInt(longitudInput.getText());
                    ctr.setLongitud(longitud);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(frame, "Por favor, introduzca un número válido.");
                    return;
                }
                textArea.setText("Contraseña generada: " + ctr.getContraseña());
            }
        });

        btnEvaluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean esFuerte = ctr.esFuerte();
                textArea.append("\nFortaleza: " + (esFuerte ? "Fuerte" : "Débil"));
            }
        });

        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        longitudInput.setBackground(new Color(173, 216, 230));
        btnGenerar.setBackground(new Color(173, 216, 230));
        btnEvaluar.setBackground(new Color(173, 216, 230));
        textArea.setBackground(new Color(173, 216, 230));

        frame.add(new JLabel("Longitud:"));
        frame.add(longitudInput);
        frame.add(btnGenerar);
        frame.add(btnEvaluar);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}