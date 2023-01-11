package trabalho2.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NamedQuery(name = "Ator.findById", query = "select a from Ator a where a.id = :id")

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "atores")
public class Ator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @Getter @Setter private Integer id;

    @NonNull @Getter @Setter private String nome;

    @Column(name = "data_nascimento")
    @NonNull @Getter @Setter private LocalDate dataNascimento;

    @ManyToMany
    @Getter @Setter private Set<Filme> filmes;

//    @ManyToMany
//    @Getter @Setter private Set<Filme> filmes;

    @Override
    public String toString() {
        return "Ator{" +
                " id: " + id +
                " - nome: " + nome +
                " - data de nascimento: " + dataNascimento + " }";
    }
}
