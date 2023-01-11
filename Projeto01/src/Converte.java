import java.io.File;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

/*
    Questão 03 - 
    
    Crie uma classe Java que recebe via linha de comando o nome de um arquivo qualquer em formato JSON e o converte 
    para os formatos CSV e XML. 
*/

public class Converte {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Insira o nome do arquivo .json: ");
        File arquivo1 = new File(input.next());

        ObjectMapper om = new ObjectMapper();
        Filmes filmes = om.readValue(arquivo1, Filmes.class);

        File arquivo2 = new File("Filme.xml");
        XmlMapper xm = new XmlMapper();
        
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(arquivo2, filmes);
        
        Writer writer = Files.newBufferedWriter(Paths.get("Filme.csv"));
        StatefulBeanToCsv<Filmes> beanToCsv = new StatefulBeanToCsvBuilder<Filmes>(writer).build();
        beanToCsv.write(filmes);

        writer.flush();
        writer.close();
        input.close();
    }
}
