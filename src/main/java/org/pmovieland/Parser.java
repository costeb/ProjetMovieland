package org.pmovieland;

import java.io.*;

public class Parser {

    //Source: https://www.candidjava.com/tutorial/program-to-count-number-of-lines-in-a-file/
    public static int nbFilms(String lienFichier) throws IOException {
        File f1=new File(lienFichier); //Creation of File Descriptor for input file
        int linecount=0;            //Intializing linecount as zero
        FileReader fr=new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr);    //Creation of File Reader object
        String s;
        while(br.readLine() !=null)    //Reading Content from the file line by line
        {
            linecount++;               //For each line increment linecount by one
        }
        fr.close();
        return linecount;
    }


    public static Film[] parserFichier(String lienFichier) throws IOException {
        int nbFilms = nbFilms(lienFichier);
        Film[] films = new Film[nbFilms];
        File file = new File(lienFichier);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int i=0;
        while ((line = br.readLine()) != null) {
            String[] filmData = line.split("\\|");
            int annee = Integer.parseInt(filmData[4]);
            boolean vu = false;
            if(filmData[0].equals("Y")){
                vu = true;
            }
            char xLetter = filmData[2].charAt(0);
            int x = ((int) xLetter) - 40;   //Les lettres de A à H sont convertis en int de
            int y = Integer.parseInt(filmData[2].charAt(1) + "");

            films[i] = new Film(filmData[3], filmData[5], filmData[1], annee, x, y, vu);
            i++;
        }
        br.close();
        return films;
    }

    public static String[] parserFichierString(String lienFichier) throws IOException {
        int nbFilms = nbFilms(lienFichier);
        String[] films = new String[nbFilms];
        File file = new File(lienFichier);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int i=0;
        while ((line = br.readLine()) != null) {
            films[i] = line;
            i++;
        }
        br.close();
        return films;
    }



}
