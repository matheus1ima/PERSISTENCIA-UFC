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
import java.util.List;

@ComponentScan("trabalho2")
public class FilmeCRUD implements CommandLineRunner {
    @Autowired
    private FilmeDAO filmeDAO;
    @Autowired
    private AtorDAO atorDAO;

    @Transactional
    public void run(String... args) {
        label:
        while (true) {
            Filme f = new Filme();
            String op = menu();
            if (op == null) {
                break;
            } else if (op.isEmpty()) {
                continue;
            }
            switch (op) {
                case "1": {//INSERIR FILMES
                    setFilme(f);
                    filmeDAO.save(f);
                    break;
                }
                //a) Obter ator e filme a partir de seus respectivos ids.
                case "2":{//BUSCAR FILMES POR ID
                    String id = JOptionPane.showInputDialog("Digite o ID do Filme: ");
                    f = filmeDAO.findFilmeById(Integer.parseInt(id));
                    listFilme(f);
                    break ;
                }
                case "3":{//UPDATE POR ID
                    String id = JOptionPane.showInputDialog("Digite o ID do Filme: ");
                    f = filmeDAO.findFilmeById(Integer.parseInt(id));
                    if(find(f)){
                        setFilme(f);
                        filmeDAO.save(f);
                    }
                    break;
                }
                case "4": {//EXCLUIR FILMES POR ID
                    String id = JOptionPane.showInputDialog("Digite o ID do Filme: ");
                    f = filmeDAO.findFilmeById(Integer.parseInt(id));
                    if(find(f)){
                        filmeDAO.delete(f);
                        if(f != null) {
                            for (Ator ator : f.getAtores()) {
                                ator.getFilmes().remove(f);
                            }
                        }
                    }
                    break;
                }
                //c) Listar os nomes de todos os atores de um determinado filme.
                case "5": {//MOSTRAR ATORES QUE FIZERAM UM FILME
                    String id = JOptionPane.showInputDialog("Digite o ID do Filme: ");
                    f = filmeDAO.findFilmeById(Integer.parseInt(id));
                    listFilmeAndAtores(f);
                    break ;
                }
                //d) Listar os títulos de filmes lançados em determinado ano.
                case "6":{//BUSCAR FILMES LANÇADOS EM UM ANO ESPECÍFICO
                    String ano = JOptionPane.showInputDialog("Digite ano:");
                    List<Filme> lista = filmeDAO.findByAnoLancamento(Integer.parseInt(ano));
                    listFilmes(lista);
                    break ;
                }
                //g) Mostrar a quantidade total de filmes cadastrados.
                case "7": {//MOSTRAR QUANTIDADE DE FILMES CADASTRADOS
                    int quant = filmeDAO.findQuantFilmes();
                    quantFilme(quant);
                    break;
                }
                case "8": {//LISTAR POR NOME
                    String palavra = JOptionPane.showInputDialog("Digite o nome do filme:");
                    List<Filme> lista = filmeDAO.findByNomeContainingIgnoreCase(palavra);
                    listFilmes(lista);
                    break;
                }
                case "9": {//SAIR
                    break label;
                }
                default:
                    JOptionPane.showMessageDialog(null, "Comando inválido.");
                    break;
            }
        }
    }

    public static String menu(){
        return JOptionPane.showInputDialog("""
                Selecione uma opção:
                1 - Inserir filme
                2 - Buscar filme por ID
                3 - Atualizar filme por ID
                4 - Excluir filme por ID
                5 - Buscar filme e seus atores pelo ID do filme
                6 - Buscar filmes lançados em ano especifico
                7 - Mostrar a quantidade de filmes cadastrados
                8 - Listar filmes por nome
                9 - Voltar para o menu principal""");
    }

    public static boolean find(Filme f) {
        if (f == null) {
            JOptionPane.showMessageDialog(null, "Filme não encontrado");
            return false;
        }else{
            return true;
        }
    }

    public static void listFilmeAndAtores(Filme f){
        StringBuilder sb = new StringBuilder();

        if (f.getAtores()!=null) {
            sb.append("Filme: ").append(f.getNome()).append(" feitos por:\n");
            for (Ator ator : f.getAtores()) {
                sb.append(ator.toString()).append("\n");
            }
        } else {
            sb.append("Filme: ").append(f.getNome()).append(" não tem atores cadastrados.");
        }

        if(!sb.isEmpty()) {
            JOptionPane.showMessageDialog(null, sb.toString());
        }else{
            sb.append("Filme: ").append(f.getNome()).append(" não tem atores cadastrados.");
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public static void listFilmes(List<Filme> lista){
        StringBuilder sb = new StringBuilder();
        for (Filme f : lista) {
            sb.append(f.toString());
            sb.append("\n");
        }
        if(sb.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum filme encontrado.");
        }else{
            JOptionPane.showMessageDialog(null, sb);
        }
    }

    public static void quantFilme(int quant) {
        if (quant > 0){
            JOptionPane.showMessageDialog(null, "Existem "+quant+" filmes cadastrados");
        }else{
        JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado");
        }
    }
//        if(find(f)){
//            JOptionPane.showMessageDialog(null, f.getQuant());
//        }else{
//            JOptionPane.showMessageDialog(null, "Filme não encontrado");
//        }


    public static void listFilme(Filme f){
        if(find(f)){
            JOptionPane.showMessageDialog(null, f.toString());
        }else{
            JOptionPane.showMessageDialog(null, "Filme não encontrado");
        }
    }

    public static void setFilme(Filme f){
        String nome = JOptionPane.showInputDialog("Nome", f.getNome());
        String anoLancamento = JOptionPane.showInputDialog("Ano", f.getAnoLancamento());

        Integer ano_lancamento=  Integer.parseInt(anoLancamento);

        f.setNome(nome);
        f.setAnoLancamento(ano_lancamento);
    }

}
