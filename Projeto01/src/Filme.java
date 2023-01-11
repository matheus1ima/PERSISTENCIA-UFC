/* 
    Questão 01 -

     Defina uma entidade principal com pelo menos 5 atributos e relacionada a um domínio de problema. Crie também uma 
     classe Java para representá-la. Exemplo de entidade com 9 atributos: Cliente: id, nome, cpf, endereço, email, fone, 
     cidade, uf, cep. A entidade deve estar relacionada a algo que você gosta bastante como: hobie, esporte, pet, 
     alimentação, educação, música, filmes, séries, redes sociais, etc. A entidade escolhida por você não pode ser a 
     entidade Cliente dada como exemplo. Escolha uma entidade bem diferente dela, inclusive quanto aos seus atributos.
*/

public class Filme {
    String titulo;
    String diretor;
    String elenco;
    String nota;
    String lancamento;

    Filme() {
        
    }

    Filme(String titulo, String diretor, String elenco, String nota, String lancamento) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.elenco = elenco;
        this.nota = nota;
        this.lancamento = lancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    @Override
    public String toString() {
        return "Filmes{" +
                "Título='" + titulo + '\'' +
                ", Diretor='" + diretor + '\'' +
                ", Elenco='" + elenco + '\'' +
                ", Nota='" + nota + '\'' +
                ", Lancamento='" + lancamento + '\'' +
                '}';
    }
}
