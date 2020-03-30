package org.pmovieland;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Fenetre extends JFrame implements ActionListener {
    private Film[] films;
    private String[] sFilms;
    private CheckList.CheckListItem[] chFilms;
    private JLabel pAffichage;
    private JList liste;

    private JButton filmAleatoire;
    private JButton sauvegarder;

    public Fenetre(Film[] films, String[] sFilms, CheckList.CheckListItem[] chFilms){
        this.films = films;
        this.sFilms = sFilms;
        this.chFilms = chFilms;

        //Propriétés fenêtre
        this.setTitle("Projet Movieland");
        this.setSize(1280, 720);

        //Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Panel gauche (boutons et affichage résultat)
        JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new BorderLayout());

        //Espace de texte
        pAffichage = new JLabel();
        panelGauche.add(pAffichage, BorderLayout.CENTER);
        pAffichage.setText("Qu'est ce qu'on regarde ?");

        //Boutons
        Container buttonPane = new Container();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
        filmAleatoire = new JButton("Film aléatoire");
        filmAleatoire.addActionListener(this);

        sauvegarder = new JButton("Sauvegarder");
        sauvegarder.addActionListener(this);

        buttonPane.add(filmAleatoire);
        buttonPane.add(sauvegarder);
        panelGauche.add(buttonPane, BorderLayout.NORTH);

        //Liste de tous les films sélectionnable
        //Source: http://www.java2s.com/Tutorials/Java/Swing_How_to/JList/Create_JList_of_CheckBox.htm
        liste = new JList(chFilms);
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

        //On coche les cases des films vus (pas élégant mais bon, à revoir)
        int i = 0;
        while(i < films.length){
            if(films[i].isVu()) {
                CheckList.CheckListItem item = (CheckList.CheckListItem) liste.getModel().getElementAt(i);
                item.setSelected(!item.isSelected()); // Toggle selected state
                liste.repaint(liste.getCellBounds(i, i));// Repaint cell
            }
            i++;
        }


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

        if (source == filmAleatoire) {
            System.out.println("Vous avez cliqué ici.");
            Film filmGenere = Generation.aleatoire(this.films);
            pAffichage.setText(filmGenere.getTitre());
        }
        if (source == sauvegarder) {
            System.out.println("Vous avez cliqué sur sauvegarder.");
            try {
                Sauvegarde.sauvegarder(films, liste.getModel());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}