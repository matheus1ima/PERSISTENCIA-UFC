import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ListaDeFilmes")
public class Filmes {
    private List<Filme> filme;

    public Filmes() {

    }

    public Filmes(List<Filme> filme) {
        this.filme = filme;
    }

    @JacksonXmlElementWrapper(localName = "Filmes")
    @JacksonXmlProperty(localName = "filme")

    public List<Filme> getFilme() {
        return filme;
    }

    public void setFilme(List<Filme> filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return this.filme.toString();        
    }

}
