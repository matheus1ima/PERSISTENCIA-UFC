import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/alunos",
                    "postgres","masterkey");
            System.out.println("Conexão bem sucedida.");
            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println("Falha na conexão");
            throw new SQLException(e.getMessage());
        }
    }

}
