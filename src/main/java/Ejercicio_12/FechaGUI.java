package Ejercicio_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FechaGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fecha");
        frame.setLayout(new FlowLayout());

        JTextField inputDia = new JTextField(2);
        JTextField inputMes = new JTextField(2);
        JTextField inputAno = new JTextField(4);

        JButton btnSetFecha = new JButton("Establecer Fecha");

        btnSetFecha.setBackground(new Color(173, 216, 230));

        Fecha fecha = new Fecha(1, 1, 2000);

        btnSetFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int dia = Integer.parseInt(inputDia.getText());
                    int mes = Integer.parseInt(inputMes.getText());
                    int ano = Integer.parseInt(inputAno.getText());
                    fecha.setDia(dia);
                    fecha.setMes(mes);
                    fecha.setAno(ano);
                    JOptionPane.showMessageDialog(frame, "Fecha establecida: " + fecha.toString());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230));
        panel.add(new JLabel("Día:"));
        panel.add(inputDia);
        panel.add(new JLabel("Mes:"));
        panel.add(inputMes);
        panel.add(new JLabel("Año:"));
        panel.add(inputAno);
        panel.add(btnSetFecha);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}