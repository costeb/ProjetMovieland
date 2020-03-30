package org.pmovieland;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {

        Film[] films = Parser.parserFichier("Movieland.txt");
        String[] sFilms = Parser.parserFichierString("Movieland.txt");
        CheckList.CheckListItem[] chFilms = Parser.parserFichierCheckListItem("Movieland.txt");

        Fenetre fenetre = new Fenetre(films, sFilms, chFilms);

        for (Film film : films) {
            System.out.println(film.getTitre());
        }
    }

}
