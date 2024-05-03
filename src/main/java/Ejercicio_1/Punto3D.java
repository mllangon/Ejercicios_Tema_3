package Ejercicio_1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Punto3D {
    private int x, y, z;

    public Punto3D() {
        this(0, 0, 0);
    }

    public Punto3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("Punto(%d, %d, %d)", x, y, z);
    }

    public static void main(String[] args) {
        JButton boton1 = new JButton("Mostrar Punto (12, 13, 18)");
        JButton boton2 = new JButton("Mostrar Punto (8, 14, 0)");

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Punto3D punto = new Punto3D(12, 13, 18);
                System.out.println("Punto 1: " + punto.toString());
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Punto3D punto = new Punto3D(8, 14, 0);
                System.out.println("Punto 2: " + punto.toString());
            }
        });

        JFrame frame = new JFrame("Visualización de Punto3D");
        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        boton1.setBackground(new Color(173, 216, 230));
        boton2.setBackground(new Color(173, 216, 230));
        frame.setLayout(new java.awt.FlowLayout());
        frame.add(boton1);
        frame.add(boton2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}