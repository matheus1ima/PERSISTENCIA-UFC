public class Filme {
    String titulo;
    String diretor;
    String elenco;
    String nota;

    Filme() { }

    Filme(String titulo, String diretor, String elenco, String nota) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.elenco = elenco;
        this.nota = nota;
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

    @Override
    public String toString() {
        return "Filme [Título: " + titulo + ", Diretor: " + diretor + ", Elenco: " + elenco + ", Nota: " + nota + "]";
    }
}