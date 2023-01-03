import java.io.*;
import java.util.Scanner;

/*  
    Questão 02 -

    Escreva uma aplicação Java para receber via argumentos de linha de comando três nomes de arquivos. 
    Deve-se gerar um novo arquivo a partir da concatenação dos dois primeiros arquivos. O nome do novo arquivo 
    gerado é o último dos três nomes de arquivos recebidos como entrada. 
*/

public class Questao2 {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        String firstFile, secondFile, thirdFile;

        System.out.println("Digite o nome do arquivo 1:");
        firstFile = input.next();

        System.out.println("Digite o nome do arquivo 2:");
        secondFile = input.next();

        System.out.println("Digite o nome do arquivo 3:");
        thirdFile = input.next();

        InputStream fileOne = new FileInputStream(firstFile);
        InputStream fileTwo = new FileInputStream(secondFile);

        Scanner readerOne = new Scanner(fileOne);
        Scanner readerTwo = new Scanner(fileTwo);

        PrintStream write = new PrintStream(thirdFile);

        for(int i = 0; readerOne.hasNextLine() ||readerTwo.hasNextLine(); i++) {
            if(readerOne.hasNextLine()) {
                write.println(readerOne.nextLine());
            } else {
                write.println(readerTwo.nextLine());
            }
        }

        write.close();
        readerTwo.close();
        readerOne.close();
        input.close();
    }
}
