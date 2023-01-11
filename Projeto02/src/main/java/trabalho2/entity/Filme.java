package trabalho2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @Getter @Setter private Integer id;

    @Getter @Setter private String nome;

    @Column(name = "ano_lancamento")
    @NonNull @Getter @Setter private Integer anoLancamento;

    @ManyToMany(mappedBy = "filmes")
    @Getter @Setter private Set<Ator> atores;

//    @ManyToMany(mappedBy = "filmes")
//    @Getter @Setter private Set<Ator> atores;

    @Transient
    @Getter @Setter private long quant;


    @Override
    public String toString() {
        return "Filme{" +
                " id: " + id +
                " - nome: " + nome +
                " - ano de lançamento: " + anoLancamento + " }";
    }

}
