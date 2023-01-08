import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        Connection connection = ConnectionFactory.getConnection();

        DAO alunos = new AlunoDAO();
        int esc = 0;
        int aux = 0;
        
        while(aux == 0){
            String matricula = "", cpf = "", nome = "", email = "", telefone = "";
            int id = 0;
            
            System.out.println("Digite 1 para inserir um novo aluno. /n Digite 2 para consultar a lista de alunos cadastrados. /n Digite 3 para atualizar dados cadastrados. /n Digite 4 para deletar alunos cadastrados. /n Digite 5 para sair do sistema.");
            esc = input.nextInt();
            
            if(esc == 1){
                System.out.println("Digite o id:");
                id = input.nextInt();
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
                System.out.println("Digite o id:");
                id = input.nextInt();
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
                
                alunos.update(connection, new Aluno(id, cpf, matricula, nome, email, telefone));
            }

            if(esc == 4){
                System.out.println("Digite o id:");
                alunos.delete(connection, input.nextInt());
            }

            if(esc == 5){
                aux = 1;
            }
        }

        input.close();
        connection.close();
    }
}
