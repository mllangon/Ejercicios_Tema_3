import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Persona {
    enum Sexo {
        HOMBRE, MUJER
    }

    private String nombre;
    private int edad;
    private String dni;
    private Sexo sexo;
    private double peso;
    private double altura;

    public Persona(String nombre, int edad, Sexo sexo, double peso, double altura) {
        this("", 0, Sexo.MUJER, 0, 0);
    }

    public Persona(String nombre, int edad, Sexo sexo, double altura, int i) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = 0;
        this.dni = generaDNI();
    }

    public double calcularIMC() {
        if (peso == 0 || altura == 0) {
            return 0;
        }
        return peso / (altura * altura);
    }

    public int valorarPesoCorporal() {
        double imc = calcularIMC();
        if (imc < 18) {
            return -1;
        } else if (imc > 25) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Edad: %d, DNI: %s, Sexo: %s, Peso: %.2f, Altura: %.2f",
                nombre, edad, dni, sexo, peso, altura);
    }

    private String generaDNI() {
        int numero = (int)(Math.random() * 100000000);
        return String.format("%08d", numero);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Información de Persona");
        frame.setLayout(new FlowLayout());

        JTextField txtNombre = new JTextField(10);
        JTextField txtEdad = new JTextField(10);
        JComboBox<Sexo> cbSexo = new JComboBox<>(Sexo.values());
        JTextField txtPeso = new JTextField(10); // Campo para ingresar el peso
        JTextField txtAltura = new JTextField(10);
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JButton btnCrear = new JButton("Crear Persona");

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                Sexo sexo = (Sexo) cbSexo.getSelectedItem();
                double peso = Double.parseDouble(txtPeso.getText());
                double altura = Double.parseDouble(txtAltura.getText());

                Persona persona = new Persona(nombre, edad, sexo, peso, altura);
                String info = persona.toString() + "\n";
                info += "IMC: " + persona.calcularIMC() + ", Valoración: " + persona.valorarPesoCorporal() + "\n";
                info += "Mayor de edad: " + (persona.esMayorDeEdad() ? "Sí" : "No");
                textArea.setText(info);
            }
        });

        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        txtNombre.setBackground(new Color(173, 216, 230));
        txtEdad.setBackground(new Color(173, 216, 230));
        cbSexo.setBackground(new Color(173, 216, 230));
        txtPeso.setBackground(new Color(173, 216, 230)); // Establecer el color de fondo del campo de peso
        txtAltura.setBackground(new Color(173, 216, 230));
        btnCrear.setBackground(new Color(173, 216, 230));
        textArea.setBackground(new Color(173, 216, 230));

        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(new JLabel("Edad:"));
        frame.add(txtEdad);
        frame.add(new JLabel("Sexo:"));
        frame.add(cbSexo);
        frame.add(new JLabel("Peso:")); // Etiqueta para el campo de peso
        frame.add(txtPeso); // Agregar el campo de peso a la interfaz
        frame.add(new JLabel("Altura:"));
        frame.add(txtAltura);
        frame.add(btnCrear);
        frame.add(new JScrollPane(textArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}