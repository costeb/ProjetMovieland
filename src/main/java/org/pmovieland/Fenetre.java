package org.pmovieland;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    String[] films;

    public Fenetre(String[] films){
        this.setTitle("Projet Movieland");
        this.setSize(100, 150);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new BorderLayout());
        JButton jb1 = new JButton("WEST");
        panelGauche.add(jb1, BorderLayout.NORTH);

        JList liste = new JList(films);

        panel.add(liste, BorderLayout.CENTER);
        panel.add(panelGauche, BorderLayout.WEST);

        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setVisible(true);
    }
}