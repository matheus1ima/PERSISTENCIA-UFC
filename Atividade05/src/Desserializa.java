import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Desserializa {
    public static void main(String[] args) throws Exception {
        File file = new File("Filmes.json");
        Filmes show = new ObjectMapper().readValue(file, Filmes.class);
        System.out.println(show);
    }

}
