package Ejercicio_2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Fecha {
    private int dia, mes, ano;

    public Fecha() {
        this(1, 1, 2000);
    }

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAño() { return ano; }

    public void setDia(int dia) { this.dia = dia; }
    public void setMes(int mes) { this.mes = mes; }
    public void setAño(int año) { this.ano = año; }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, ano);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Manejo de Fechas");
        JButton botonMostrar = new JButton("Mostrar Fecha Actual");
        JButton botonCambiar2019 = new JButton("Cambiar Año a 2019");
        JButton botonCambiar2020 = new JButton("Cambiar Año a 2020");
        JTextArea areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false);

        Fecha fecha = new Fecha(20, 10, 2018);

        botonMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText("Fecha: " + fecha.toString());
            }
        });

        botonCambiar2019.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fecha.setAño(2019);
                areaTexto.setText("Nueva Fecha: " + fecha.toString());
            }
        });

        botonCambiar2020.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fecha.setAño(2020);
                areaTexto.setText("Nueva Fecha: " + fecha.toString());
            }
        });

        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        botonMostrar.setBackground(new Color(173, 216, 230));
        botonCambiar2019.setBackground(new Color(173, 216, 230));
        botonCambiar2020.setBackground(new Color(173, 216, 230));
        areaTexto.setBackground(new Color(173, 216, 230));

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(botonMostrar);
        frame.add(botonCambiar2019);
        frame.add(botonCambiar2020);
        frame.add(new JScrollPane(areaTexto));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}