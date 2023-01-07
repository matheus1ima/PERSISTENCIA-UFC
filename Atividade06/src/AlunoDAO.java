import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {
    public void insert(Aluno aluno, Connection connection) {
        try {
            Class.forName("org.postgresql.Driver");

            String insert = "insert into aluno (id, cpf, matricula, nome, email, telefone) values (?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            
            preparedStatement.setString(1, aluno.getId());
            preparedStatement.setString(2, aluno.getCpf());
            preparedStatement.setString(3, aluno.getMatricula());
            preparedStatement.setString(4, aluno.getNome());
            preparedStatement.setString(5, aluno.getEmail());
            preparedStatement.setString(6, aluno.getTelefone());

            preparedStatement.execute();
            preparedStatement.close(); 

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void list(Connection connection){
        try {
            String select = "select * from aluno";
            PreparedStatement preparedStatement = connection.prepareStatement(select);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                Aluno aluno = new Aluno();
                aluno.setId(result.getString("id"));
                aluno.setCpf(result.getString("cpf"));
                aluno.setMatricula(result.getString("matricula"));
                aluno.setNome(result.getString("nome"));
                aluno.setEmail(result.getString("email"));
                aluno.setTelefone(result.getString("telefone"));

                System.out.println(aluno);
            }

            result.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}