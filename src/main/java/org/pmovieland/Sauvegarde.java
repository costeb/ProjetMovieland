package org.pmovieland;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("Since15")
public class Sauvegarde {

    public static void sauvegarder(Film[] films, DefaultListModel<CheckList.CheckListItem> chFilms) throws IOException {
        File file = new File("Movieland.txt");
        FileWriter fileWriter = new FileWriter(file, false); // true pour aller à la suite, false pour remplacer


        int i=0;
        for(Film film: films){
            String vu = "";
            if(film.isVu()){
                vu = "Y";
            }else{
                vu = "N";
            }
            String line = vu + "|" + film.getPays() + "|" + film.getXy() + "|" + film.getTitre() + "|" + film.getAnnee() + "|" + film.getRealisateur()+"\n";
            fileWriter.write("New Contents\n");
            i++;
        }

        fileWriter.close();
    }

}
