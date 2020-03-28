package org.pmovieland;

import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {
        Film[] films = Parser.parserFichier("Movieland.txt");

        for (Film film : films) {
            System.out.println(film.getTitre());
        }
    }

}
