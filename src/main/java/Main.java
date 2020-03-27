import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {
        Film[] films = Parser.parserFichier("Movieland.txt");

        for (int i = 0; i < films.length; i++) {
            System.out.println(films[i].getTitre());
        }
    }

}
