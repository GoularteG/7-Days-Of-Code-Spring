package _daysofcode.demo.infra;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuperHeroisRepository extends JpaRepository<SuperHerois,Long> {

    @Query("SELECT s FROM SuperHerois s WHERE LOWER(s.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<SuperHerois> findByNome(@Param("nome") String nome);

}
