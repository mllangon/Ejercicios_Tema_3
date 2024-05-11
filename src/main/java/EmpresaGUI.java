import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class EmpresaGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Empresa");
        frame.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        JButton btnCalcular = new JButton("Calcular Salarios");
        btnCalcular.setBackground(new Color(173, 216, 230));

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                Empleado[] empleados = new Empleado[22];
                for (int i = 0; i < 2; i++) {
                    empleados[i] = new Jefe(rand.nextInt(11));
                }
                for (int i = 2; i < 7; i++) {
                    empleados[i] = new Viajante(rand.nextInt(11));
                }
                for (int i = 7; i < 22; i++) {
                    empleados[i] = new Empleado();
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < empleados.length; i++) {
                    sb.append("Salario del empleado ").append(i + 1).append(": ").append(empleados[i].calcularSalario()).append("\n");
                }
                textArea.setText(sb.toString());
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230));
        panel.add(btnCalcular);
        panel.add(new JScrollPane(textArea));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}