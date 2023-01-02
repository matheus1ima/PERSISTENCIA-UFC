import java.io.*;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo de entrada: ");
        String arquivo1 = input.next();

        System.out.println("Digite o nome do arquivo de saída: ");
        String arquivo2 = input.next();

        InputStream in = new FileInputStream(arquivo1);
        InputStreamReader inStream = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(inStream);

        OutputStream out = new FileOutputStream(arquivo2);
        OutputStreamWriter outStream = new OutputStreamWriter(out);
        BufferedWriter writer = new BufferedWriter(outStream);
    
        boolean answer = true;

        while(answer == true){
            String termo = "";
            termo = reader.readLine();
            if(termo != null){
                writer.write(termo + "\n");
                answer = true;
            } else {
                answer = false;
            }
        }

        input.close();
        reader.close();
        writer.close();
    }
}