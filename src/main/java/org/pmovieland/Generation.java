package org.pmovieland;

import java.util.Random;

public class Generation {

    public static Film aleatoire(Film[] films){
        Random r = new Random();
        return films[r.nextInt(films.length)];
    }
}
