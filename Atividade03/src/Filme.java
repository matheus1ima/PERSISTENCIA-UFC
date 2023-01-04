public class Filme implements java.io.Serializable {
    int id;
    String titulo;
    String sinopse;
    String diretor;

    Filme(int id, String titulo, String sinopse, String diretor) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.diretor = diretor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Filme [id: " + id + ", Título: " + titulo + ", Sinopse: " + sinopse + ", Diretor: " + diretor + "]";
    }
}
