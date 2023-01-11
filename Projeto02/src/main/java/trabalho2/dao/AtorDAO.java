package trabalho2.dao;

import trabalho2.entity.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtorDAO extends JpaRepository<Ator, Integer> {

    @Query(name = "Ator.findById")
    public Ator findAtorId(@Param("id") Integer id);

    public List<Ator> findAtorAndFilmesByNomeContainingIgnoreCase(String nome);



}
