import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        Connection connection = ConnectionFactory.getConnection();
        AlunoDAO alunos = new AlunoDAO();
        
        int esc = 0;
        int aux = 0;
        
        while(aux == 0){
            String id = "", matricula = "", cpf = "", nome = "", email = "", telefone = "";

            System.out.println("Digite 1 para inserir um aluno.");
            System.out.println("Digite 2 para consultar a lista de alunos.");
            System.out.println("Digite 3 para sair.");

            esc = input.nextInt();
            System.out.print("\033[H\033[2J");
            if(esc == 1){
                System.out.println("Digite o id:");
                id = input.next();
                System.out.println("Digite o CPF:");
                cpf = input.next();
                System.out.println("Digite a matrícula:");
                matricula = input.next();
                System.out.println("Digite o nome:");
                nome = input.next();
                System.out.println("Digite o email:");
                email = input.next();
                System.out.println("Digite o telefone:");
                telefone = input.next();

                alunos.insert(new Aluno(id, cpf, matricula, nome, email, telefone), connection);
            }

            if(esc == 2){
                alunos.list(connection);
            }

            if(esc == 3){
                aux = 1;
            }

        }
        input.close();
        connection.close();
    }
}
