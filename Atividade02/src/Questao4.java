import java.io.*;
import java.util.Properties;

public class Questao4 {

    private static Properties config = new Properties();
    private static String root = "src\\config.properties";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        config.load(new FileInputStream(root));
    
        InputStream stream = new FileInputStream(config.getProperty("arquivo"));
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader bufferead = new BufferedReader(reader);

        String str = "";

        int linhaInicial = Integer. parseInt(config.getProperty("linhaInicial"));
        int linhaFinal = Integer. parseInt(config.getProperty("linhaFinal"));

        if (linhaFinal == 0){
            for (int i = 0; str != null; i++) {
                if (i >= (linhaInicial))
                    System.out.println(str);
                str = bufferead.readLine();
            }
        } else if (linhaInicial < linhaFinal){
            for (int i = 0; i <= (linhaFinal); i++) {
                if (i >= (linhaInicial))
                    System.out.println(str);
                str = bufferead.readLine();
            }
        } else {
            System.out.println("Operação invalida");
        } 

        bufferead.close();
    }
}
