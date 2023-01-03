import java.io.*;
import java.util.Scanner;

/*
    Questão 01 -
    
    Crie uma aplicação Java para receber via argumento de linha de comando um nome de arquivo texto e uma string S. 
    A aplicação deve exibir todas as linhas que tenham S como substring, independente dos caracteres estarem em caixa 
    alta ou baixa (case-insensitive).
 */

public class Questao1 {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo: ");
        String firstFile = input.next();

        System.out.println("Insira o nome da sub cadeia de caracteres");
        String subString = input.next();

        InputStream fileOne = new FileInputStream(firstFile);
        Scanner reader = new Scanner(fileOne);

        for(int i = 0; reader.hasNextLine(); i++){
            String aux = reader.nextLine();

            if(aux.contains(subString.toUpperCase()) || aux.contains(subString.toLowerCase())){
                System.out.println(aux);
            }
        }
 
        reader.close();
        input.close();
    }
}
