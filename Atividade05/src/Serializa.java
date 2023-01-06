import java.io.File;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Serializa {
    public static void main (String [] args) throws Exception{

        Filme filme1 = new Filme("Thor: Amor e Trovão", "Taika Waititin", "Chris Hemsworth, Natalie Portman, Christian Bale.", "57/100");

        Filme filme2 = new Filme("Pinóquio", "Robert Zemeckis.", "Tom Hanks, Cynthia Erivo, Sheila Atim.", "39/100");

        Filme filme3 = new Filme("Uncharted: Fora do Mapa", "Ruben Fleischer", "Tom Holland, Mark Wahlberg, Tati Gabrielle.", "45/100");
        
        List<Filme> lista = new ArrayList<Filme>();

        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);

        Filmes filmes = new Filmes(lista);
        File file = new File("Filmes.json");

        ObjectMapper js = new ObjectMapper();
        
        js.enable(SerializationFeature.INDENT_OUTPUT);
        js.writeValue(file, filmes);
    }
}