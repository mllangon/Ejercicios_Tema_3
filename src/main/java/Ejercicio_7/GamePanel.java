package Ejercicio_7;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Guerra guerra;
    private JTextArea textArea;

    public GamePanel() {
        this.guerra = guerra;
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        add(new JScrollPane(textArea));
        setPreferredSize(new Dimension(600, 400));
    }

    public void narrar(String texto) {
        textArea.append(texto + "\n");
    }
}