package org.pmovieland;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener {
    private Film[] films;
    private String[] sFilms;
    private JLabel pAffichage;

    private JButton filmAleatoire;

    public Fenetre(Film[] films, String[] sFilms){
        this.films = films;
        this.sFilms = sFilms;

        //Propriétés fenêtre
        this.setTitle("Projet Movieland");
        this.setSize(500, 500);

        //Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Panel gauche (boutons et affichage résultat)
        JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new BorderLayout());

        //Espace de texte
        pAffichage = new JLabel();
        panelGauche.add(pAffichage, BorderLayout.CENTER);
        pAffichage.setText("COUCOU");

        //Boutons
        filmAleatoire = new JButton("Film aléatoire");
        filmAleatoire.addActionListener(this);
        panelGauche.add(filmAleatoire, BorderLayout.NORTH);

        //Liste de tous les films
        JList liste = new JList(sFilms);

        panel.add(liste, BorderLayout.CENTER);
        panel.add(panelGauche, BorderLayout.WEST);

        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        System.out.println("Action Performed");

        if(source == filmAleatoire){
            System.out.println("Vous avez cliqué ici.");
            Film filmGenere = Generation.aleatoire(this.films);
            pAffichage.setText(filmGenere.getTitre());
        }
    }
}