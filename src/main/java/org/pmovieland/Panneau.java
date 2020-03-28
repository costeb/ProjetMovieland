package org.pmovieland;

import java.awt.Graphics;
import javax.swing.*;

public class Panneau extends JPanel {

    public void paintComponent(String[] films){
        //Vous verrez cette phrase chaque fois que la méthode sera invoquée
        System.out.println("Je suis exécutée !");
        this.add(new JList(films));
    }
}