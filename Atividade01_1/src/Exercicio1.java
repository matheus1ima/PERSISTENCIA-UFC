import java.io.*;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String n1, n2;
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o endereço do arquivo de texto: ");
        String arquivo = input.nextLine();

        System.out.println("Insira o primeiro número: ");
        n1 = input.nextLine();

        System.out.println("Insira o segundo número: ");
        n2 = input.nextLine();

        int nn1 = n1.isEmpty() ? 0 : Integer.parseInt(n1);
        int nn2 = n2.isEmpty() ? 0 : Integer.parseInt(n2); 

        InputStream is = new FileInputStream(arquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String str = "";
        
        if(nn2 == 0){
            for (int i = 0; str != null; i++) {
                if(i >= (nn1))System.out.println(str);
                str = br.readLine();
            }
        } else if(nn1 == 0) {
            for (int i = 0; i <= nn2; i++) {
                System.out.println(str);
                str = br.readLine();
            }
        } else if(nn1 < nn2) {
            for (int i = 0; i <= nn2; i++) {
                if(i >= (nn1))System.out.println(str);
                str = br.readLine();
            }
        } else if(nn1 > nn2) {
            System.out.println("Operação invalida");
        }

        br.close();
        input.close();
    }
}
