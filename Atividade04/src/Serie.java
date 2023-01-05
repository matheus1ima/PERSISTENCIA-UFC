public class Serie {
    String titulo;
    String sinopse;
    String diretor;
    String elenco;

    Serie() {}

    Serie(String titulo, String sinopse, String diretor, String elenco) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.elenco = elenco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
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

    @Override
    public String toString() {
        return "Serie [Título: " + titulo + ", Sinopse: " + sinopse + ", Diretor: " + diretor + ", Elenco: " + elenco + "]";
    }
}
