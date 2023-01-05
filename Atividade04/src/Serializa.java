import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Serializa {
    public static void main (String [] args) throws Exception {

        Serie serie1 = new Serie("Euphoria", "The teen drama based on the Israeli series of the same name about a group of teenagers including Rue (Zendaya), a 17-year-old drug addict, as they deal with school, love, friendship, sex and drugs.", "Sam Levisson", "Zendaya, Hunter Schafer, Angus Cloud, Alexa Demi, Barbie Ferreira, Jacob Elordi.");

        Serie serie2 = new Serie("The Sandman", "Morpheus/Dream escapes from a 100+ years sleep and seeks to revive his kingdom in this series adaptation of Neil Gaiman's comic book series of the same name.", "Neil Gaiman", " Tom Sturridge, Boyd Holbrook, Kirby Howell, David Thewlis, Stephen Fry, Gwendoline Christie.");

        Serie serie3 = new Serie("The Wheel Of Time", "Moiraine, a member of a powerful all-female organization and five young people, one who is prophesied to be the one who could save or destroy the world, begin a long journey in this adaptation of the Robert Jordan's novel series of the same name.", "Uta Briesewitz", "Rosamund Pike, Josha Stradowski, Priyanka Bose, Barney Harris, Marcus Rutherford, Madeleine Madden.");

        List<Serie> lista = new ArrayList<Serie>();

        lista.add(serie1);
        lista.add(serie2);
        lista.add(serie3);
        
        Series series = new Series(lista);
        File s = new File("Series.xml");

        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(s, series);
    }
}
