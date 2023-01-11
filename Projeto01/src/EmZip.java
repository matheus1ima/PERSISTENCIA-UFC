import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
    Questão 04 - 
    Crie uma classe Java que recebe como entrada de teclado o nome de um file qualquer e o compacta para o formato ZIP 
    ou outro formato de compressão à sua escolha. 
*/

public class EmZip {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        int size = 2048;
        byte[] quantidade = new byte[size];

        System.out.println("Insira o nome do Arquivo: ");
        String filename = input.nextLine();

        File recebendoarquivo = new File(filename);
        String arquivo = recebendoarquivo.getName().concat(".zip");

        BufferedInputStream bufferedInputStream = null;

        FileInputStream InputStream = null;
        FileOutputStream outputStream = null;
        
        ZipOutputStream zipOutputStream = null;
        ZipEntry zipEntry = null;

        outputStream = new FileOutputStream(arquivo);
        zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outputStream));
        InputStream = new FileInputStream(arquivo);
        
        bufferedInputStream = new BufferedInputStream(InputStream, size);
        zipEntry = new ZipEntry(recebendoarquivo.getName());
        zipOutputStream.putNextEntry(zipEntry);

        for(int i = bufferedInputStream.read(quantidade, 0, size); i != -1; ) {
            zipOutputStream.write(quantidade, 0, i);
        }
        
        bufferedInputStream.close();
        zipOutputStream.close();
        input.close();
    }
}
