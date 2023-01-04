import java.io.IOException;
import java.io.*;
import java.util.List;

public class Desserializa {
    public static void main(String[] args) throws IOException ,ClassNotFoundException {

        try {
            FileInputStream fileIn = new FileInputStream("filme.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            List<Filme> filmes = (List<Filme>) in.readObject();
            System.out.println(filmes);

            in.close();
            fileIn.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String inputStreamToString(FileInputStream is) throws IOException {

        StringBuilder builder = new StringBuilder();
        String line;
        BufferedReader buffered = new BufferedReader(new InputStreamReader(is));

        while((line = buffered.readLine()) != null) {
            builder.append(line);
        }

        buffered.close();
        return builder.toString();
    }
}
