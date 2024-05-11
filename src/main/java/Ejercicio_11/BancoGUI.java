package Ejercicio_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BancoGUI {
    private static Map<String, CuentaBancaria> cuentas = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Banco");
        frame.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        JTextField inputCantidad = new JTextField(10);
        JTextField inputNumeroCuenta = new JTextField(10);

        JComboBox<String> cuentasComboBox = new JComboBox<>();

        JButton btnCrearCuentas = new JButton("Crear Cuentas");
        JButton btnRetirarDinero = new JButton("Retirar Dinero");
        JButton btnIngresarDinero = new JButton("Ingresar Dinero");
        JButton btnTransferirDinero = new JButton("Transferir Dinero");

        btnCrearCuentas.setBackground(new Color(173, 216, 230));
        btnRetirarDinero.setBackground(new Color(173, 216, 230));
        btnIngresarDinero.setBackground(new Color(173, 216, 230));
        btnTransferirDinero.setBackground(new Color(173, 216, 230));

        btnCrearCuentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                CuentaBancaria[] cuentasArray = new CuentaBancaria[3];
                cuentasArray[0] = new CuentaBancaria("Titular 1", new Date(), "123456", 1000);
                cuentasArray[1] = new CuentaPlazoFijo("Titular 2", new Date(), "234567", 2000, new Date(System.currentTimeMillis() + 86400000L * rand.nextInt(30)));
                cuentasArray[2] = new CuentaVip("Titular 3", new Date(), "345678", 3000, 500);

                for (CuentaBancaria cuenta : cuentasArray) {
                    cuentas.put(cuenta.numeroCuenta, cuenta);
                    cuentasComboBox.addItem(cuenta.numeroCuenta);
                }

                StringBuilder sb = new StringBuilder();
                for (CuentaBancaria cuenta : cuentasArray) {
                    sb.append("Cuenta: ").append(cuenta.numeroCuenta).append("\n");
                    sb.append("Titular: ").append(cuenta.titular).append("\n");
                    sb.append("Fecha de apertura: ").append(cuenta.fechaApertura).append("\n");
                    sb.append("Saldo: ").append(cuenta.saldo).append("\n");
                    if (cuenta instanceof CuentaPlazoFijo) {
                        sb.append("Fecha de vencimiento: ").append(((CuentaPlazoFijo) cuenta).getFechaVencimiento()).append("\n");
                    }
                    if (cuenta instanceof CuentaVip) {
                        sb.append("Saldo negativo máximo: ").append(((CuentaVip) cuenta).getSaldoNegativoMaximo()).append("\n");
                    }
                    sb.append("\n");
                }
                textArea.setText(sb.toString());
            }
        });

        btnRetirarDinero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double cantidad = Double.parseDouble(inputCantidad.getText());
                String numeroCuenta = (String) cuentasComboBox.getSelectedItem();
                CuentaBancaria cuentaSeleccionada = cuentas.get(numeroCuenta);
                cuentaSeleccionada.retirarDinero(cantidad);
                textArea.setText("Se retiró " + cantidad + " de la cuenta " + numeroCuenta + ". Saldo actual: " + cuentaSeleccionada.saldo);
            }
        });

        btnIngresarDinero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double cantidad = Double.parseDouble(inputCantidad.getText());
                String numeroCuenta = (String) cuentasComboBox.getSelectedItem();
                CuentaBancaria cuentaSeleccionada = cuentas.get(numeroCuenta);
                cuentaSeleccionada.ingresarDinero(cantidad);
                textArea.setText("Se ingresó " + cantidad + " a la cuenta " + numeroCuenta + ". Saldo actual: " + cuentaSeleccionada.saldo);
            }
        });

        btnTransferirDinero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double cantidad = Double.parseDouble(inputCantidad.getText());
                String numeroCuentaOrigen = (String) cuentasComboBox.getSelectedItem();
                String numeroCuentaDestino = inputNumeroCuenta.getText();
                CuentaBancaria cuentaOrigen = cuentas.get(numeroCuentaOrigen);
                CuentaBancaria cuentaDestino = cuentas.get(numeroCuentaDestino);
                if (cuentaDestino != null) {
                    cuentaOrigen.transferirDinero(cuentaDestino, cantidad);
                    textArea.setText("Se transfirió " + cantidad + " de la cuenta " + numeroCuentaOrigen + " a la cuenta " + numeroCuentaDestino + ". Saldo actual de la cuenta origen: " + cuentaOrigen.saldo);
                } else {
                    textArea.setText("Número de cuenta destino no válido.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230));
        panel.add(btnCrearCuentas);
        panel.add(btnRetirarDinero);
        panel.add(btnIngresarDinero);
        panel.add(btnTransferirDinero);
        panel.add(new JScrollPane(textArea));
        panel.add(new JLabel("Número de cuenta:"));
        panel.add(cuentasComboBox);
        panel.add(new JLabel("Cantidad:"));
        panel.add(inputCantidad);
        panel.add(new JLabel("Número de cuenta destino:"));
        panel.add(inputNumeroCuenta);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}