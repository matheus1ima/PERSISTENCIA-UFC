package trabalho2.dao;


import trabalho2.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeDAO extends JpaRepository<Filme, Integer> {

    public Filme findFilmeById(int parseInt);

    public List<Filme> findByNomeContainingIgnoreCase(String palavra);

    public List<Filme> findByAnoLancamento(Integer anoLancamento);

    @Query(value = "select count (id) from filmes as quant", nativeQuery = true)
    public int findQuantFilmes();
}
