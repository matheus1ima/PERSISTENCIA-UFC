package trabalho2.app;

import trabalho2.dao.AtorDAO;
import trabalho2.dao.FilmeDAO;
import trabalho2.entity.Ator;
import trabalho2.entity.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ComponentScan("trabalho2")
public class AtorCRUD implements CommandLineRunner {

    @Autowired
    private AtorDAO atorDAO;
    @Autowired
    private FilmeDAO filmeDAO;

    @Transactional
    public void run(String... args) {
        label:
        while (true) {
            Ator a = new Ator();
            String op = menu();

            if(op==null){
                break;
            } else if(op.isEmpty()){
                continue;
            }

            switch (op) {
                case "1": {//INSERIR ATOR
                    setAtor(a);
                    atorDAO.save(a);
                    break;
                }
                //a) Obter ator e filme a partir de seus respectivos ids.
                case "2": {//BUSCAR ATOR POR ID
                    String id = JOptionPane.showInputDialog("Digite o id do Ator:");
                    a = atorDAO.findAtorId(Integer.parseInt(id));
                    listAtor(a);
                    break ;
                }
                case "3": {//UPDATE POR ID
                    String id = JOptionPane.showInputDialog(null, "Digite o id do ator a ser alterado:");
                    a = atorDAO.findAtorId(Integer.parseInt(id));
                    if (find(a)) {
                        setAtor(a);
                        atorDAO.save(a);
                    }
                    break;
                }
                case "4":{//EXCLUIR ATOR POR ID
                    String id = JOptionPane.showInputDialog("Digite o id do ator:");
                    a = atorDAO.findAtorId(Integer.parseInt(id));
                    if(find(a)) {
                        atorDAO.delete(a);
                    }
                    break;
                }
                case "5": {//CADASTRAR ATOR EM FILMES
                    String id = JOptionPane.showInputDialog("Digite o id do ator:");
                    a = atorDAO.findAtorId(Integer.parseInt(id));
                    if(find(a)){
                        Set<Filme> filmes = cadastrar();
                        if(a.getFilmes()==null)
                            a.setFilmes(filmes);
                        else
                            a.getFilmes().addAll(filmes);
                        atorDAO.save(a);
                    }
                    break;
                }
                //b) Listar todos os títulos de filmes de um determinado ator.
                case "6":{//LISTAR FILMES DE UM ATOR
                    String nome = JOptionPane.showInputDialog("Digite o nome do ator:");
                    List<Ator> lista = atorDAO.findAtorAndFilmesByNomeContainingIgnoreCase(nome);
                    listFilmesPorAtor(lista);
                    break;
                }
                case "7": {//Fechar menu
                    break label;
                }
                default:
                    JOptionPane.showMessageDialog(null, "Comando inválido.");
                    break;

            }
        }
    }

    public static String menu() {
        return JOptionPane.showInputDialog("""
                Selecione uma opção:
                1 - Cadastrar Ator
                2 - Consultar cadastro de um Ator
                3 - Atualizar cadastro de um Ator
                4 - Excluir cadastro de um Ator
                5 - Cadastrar Ator em filme
                6 - Consultar filmes de um Ator
                7 - Voltar para o menu principal
                """);
    }

    public static boolean find(Ator a) {
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Ator não encontrado");
            return false;
        }else{
            return true;
        }
    }

    public static void listFilmesPorAtor(List<Ator> lista){
        StringBuilder sb = new StringBuilder();
        for (Ator a: lista) {
            if(!a.getFilmes().isEmpty()) {
                sb.append("Ator(a) ").append(a.getNome());
                sb.append(" com o ID ").append("("+a.getId()+")").append(" fez os seguintes filmes:\n");
                for (Filme f: a.getFilmes()) {
                    sb.append(f.toString()).append("\n");
                }
            }else{
                sb.append("Ator(a) ").append(a.getNome()).append(" com o ID ").append(a.getId());
                sb.append(" não fez nehum filme.\n");
            }
            sb.append("\n");
        }
        if(!sb.isEmpty()) {
            JOptionPane.showMessageDialog(null, sb.toString());
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum ator fez nenhum filme.");
        }
    }

    public static void listAtores(List<Ator> lista){
        StringBuilder sb = new StringBuilder();
        for (Ator a : lista) {
            sb.append(a.toString());
            sb.append("\n");
        }
        if(sb.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum ator encontrado.");
        }else{
            JOptionPane.showMessageDialog(null, sb);
        }
    }

    public static void listAtor(Ator a){
        if(find(a)){
            JOptionPane.showMessageDialog(null, a.toString());
        }else{
            JOptionPane.showMessageDialog(null, "Ator não encontrado");
        }
    }

    public static void setAtor(Ator a){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String nome = JOptionPane.showInputDialog("Nome", a.getNome());
        String data_nascimento = JOptionPane.showInputDialog("Data de nascimento", a.getDataNascimento());

        LocalDate dataFormatada = LocalDate.parse(data_nascimento, formato);

        a.setNome(nome);
        a.setDataNascimento(dataFormatada);
    }

    public Set<Filme> cadastrar(){
        boolean isTrue = true;
        Set<Filme> filmes = new HashSet<>();
        while(isTrue) {
            Filme filme;
            String id = JOptionPane.showInputDialog(null, "Digite o ID do filme a ser cadastrado. (Digite 0 para sair)");
            if(Integer.parseInt(id) != 0){
                filme = filmeDAO.findFilmeById(Integer.parseInt(id));
                if(filme != null){
                    JOptionPane.showMessageDialog(null, "Ator cadastrado em " + filme);
                    filmes.add(filme);
                }else{
                    JOptionPane.showMessageDialog(null,"Filme não encontrada.");
                }
            }else{
                isTrue = false;
            }
        }
        return filmes;
    }
}