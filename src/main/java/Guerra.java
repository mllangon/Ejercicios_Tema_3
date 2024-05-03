import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Guerra {
    private List<NaveMarciano> navesMarcianas;
    private List<NaveTerricola> navesTerricolas;
    private GamePanel gamePanel;

    public Guerra(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        navesMarcianas = new ArrayList<>();
        navesTerricolas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            navesMarcianas.add(new NaveMarciano());
        }
        for (int i = 0; i < 10; i++) {
            navesTerricolas.add(new NaveTerricola());
        }
    }

    public void simularGuerra() {
        Random rand = new Random();
        while (!navesMarcianas.isEmpty() && !navesTerricolas.isEmpty()) {
            for (NaveMarciano naveMarciano : navesMarcianas) {
                if (!navesTerricolas.isEmpty()) {
                    NaveTerricola naveTerricola = navesTerricolas.get(rand.nextInt(navesTerricolas.size()));
                    naveTerricola.recibirDaño(naveMarciano.atacar());
                    gamePanel.narrar("Nave marciana ataca a nave terrícola. Vida restante de la nave terrícola: " + naveTerricola.vida);
                    if (!naveTerricola.estaViva()) {
                        navesTerricolas.remove(naveTerricola);
                        gamePanel.narrar("Nave terrícola ha sido destruida.");
                    }
                }
            }

            for (NaveTerricola naveTerricola : navesTerricolas) {
                if (!navesMarcianas.isEmpty()) {
                    NaveMarciano naveMarciano = navesMarcianas.get(rand.nextInt(navesMarcianas.size()));
                    naveMarciano.recibirDaño(naveTerricola.atacar());
                    gamePanel.narrar("Nave terrícola ataca a nave marciana. Vida restante de la nave marciana: " + naveMarciano.vida);
                    if (!naveMarciano.estaViva()) {
                        navesMarcianas.remove(naveMarciano);
                        gamePanel.narrar("Nave marciana ha sido destruida.");
                    }
                }
            }
        }

        if (navesMarcianas.isEmpty()) {
            gamePanel.narrar("Las naves terrícolas han ganado la guerra.");
        } else {
            gamePanel.narrar("Las naves marcianas han ganado la guerra.");
        }
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.pack();
        frame.getContentPane().setBackground(new Color(173, 216, 230)); // RGB para azul claro
        Guerra guerra = new Guerra(panel);
        guerra.simularGuerra();
    }
}