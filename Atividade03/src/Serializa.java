import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serializa {
    public static void main (String [] args) {

        Filme filme1 = new Filme(1, "X - A Marca da Morte", "Um grupo de atores se propõe a fazer um filme adulto na zona rural do Texas, sob o nariz de seus anfitriões reclusos. Quando os donos do local pegam seus jovens convidados no ato, o elenco se vê em uma luta desesperada por suas vidas.", "Ti West");

        Filme filme2 = new Filme(2, "Pearl", "Pearl é um filme de slasher americano dirigido e produzido por Ti West, co-escrito por West e Mia Goth, que reprisa seu papel como personagem-título, e apresentando David Corenswet, Tandi Wright, Matthew Sunderland e Emma Jenkins-Purro em papéis coadjuvantes.", "Ti West");

        Filme filme3 = new Filme(3, "MAXXXINE", "MaXXXine é a sequência (cronológica) de X – A Marca da Morte e é o terceiro filme depois de Pearl. Dessa vez, o novo longa vai focar em Maxine, a personagem vivida por Mia Goth. O longa deve mostrar como ficou a carreira da jovem e sua corrida em busca da fama após os chocantes eventos vividos por ela anos antes.", "Ti West");

        List<Filme> lista = new ArrayList<>();
        
        lista.add(filme1); 
        lista.add(filme2); 
        lista.add(filme3);

        FileOutputStream fileOut = null;

        try {
            fileOut = new FileOutputStream("filme.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lista);

            out.close();
            fileOut.close();

            System.out.println("Serializado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
