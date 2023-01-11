import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

/*
    Questão 05- Crie uma classe Java que recebe via linha de comando o nome de um file qualquer e exibe no console 7
    o hash SHA1 desse file. Dica: você pode se basear no exemplo a seguir, que gera o hash md5 e adaptá-lo para gerar 
    o hash SHA1: https://www.baeldung.com/java-md5  
*/

public class Sha1 {
    public static void main(String[] args)throws Exception { 
        
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do arquivo: ");
        String arquivo = input.nextLine();
        
        input.close();

        MessageDigest msg = MessageDigest.getInstance("sha-1");
        byte[] pegabytes = arquivo.getBytes(); 
        msg.update(pegabytes);


        String hash = new BigInteger(1, msg.digest()).toString(16);
        System.out.println("Número de Hash : " + hash);
        
    }
}