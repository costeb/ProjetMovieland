package org.pmovieland;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenetre extends JFrame implements ActionListener {
    private Film[] films;
    private String[] sFilms;
    private JLabel pAffichage;

    private JButton filmAleatoire;

    public Fenetre(Film[] films, String[] sFilms, CheckList.CheckListItem[] chFilms){
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

        //Liste de tous les films sélectionnable
        //Source: http://www.java2s.com/Tutorials/Java/Swing_How_to/JList/Create_JList_of_CheckBox.htm
        JList liste = new JList(chFilms);
        liste.setCellRenderer(new CheckList.CheckListRenderer());
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        liste.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                JList list = (JList) event.getSource();
                int index = list.locationToIndex(event.getPoint());// Get index of item
                // clicked
                CheckList.CheckListItem item = (CheckList.CheckListItem) list.getModel()
                        .getElementAt(index);
                item.setSelected(!item.isSelected()); // Toggle selected state
                list.repaint(list.getCellBounds(index, index));// Repaint cell
            }
        });


        panel.add(new JScrollPane(liste), BorderLayout.CENTER);
        panel.add(panelGauche, BorderLayout.WEST);

        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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