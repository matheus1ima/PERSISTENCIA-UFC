import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/*
    Questão 02 - 
    
    Crie uma classe Java para cadastrar dados relacionados à entidade definida na questão 1. A classe deve receber dados 
    via teclado e os salvar em um arquivo JSON. 
*/

public class Serializa {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        
        String titulo;
        String diretor;
        String elenco;
        String nota;
        String lancamento;

        List<Filme> lista = new ArrayList<Filme>();

        for(int i = 1; i != 0; ) {
            System.out.println("Você deseja cadastrar um filme? (Sim ou Não)");
            String answer = input.nextLine();

            if(answer.equals("Sim")) {
                System.out.printf("Insira o nome do filme: ");
                titulo = input.nextLine();
                
                System.out.printf("Insira o nome do diretor do filme: ");
                diretor = input.nextLine();

                System.out.printf("Insira o nome do elenco principal do filme: ");
                elenco = input.nextLine();

                System.out.printf("Insira o nome da nota do filme: ");
                nota = input.nextLine();

                System.out.printf("Insira o ano de lançamento do filme: ");
                lancamento = input.nextLine();
                
                Filme filme = new Filme(titulo, diretor, elenco, nota, lancamento);
                lista.add(filme);
            } else {
                break;
            }
        }

        
   
        Filmes filmes = new Filmes(lista);
        File n = new File("Filme.json");
        ObjectMapper js = new ObjectMapper();
        input.close();

        js.enable(SerializationFeature.INDENT_OUTPUT);
        js.writeValue(n, filmes);
    }
}
