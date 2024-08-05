package _daysofcode.demo.infra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroisRepository extends JpaRepository<SuperHerois,Long> {
    Page<SuperHerois> findAllByAtivoTrue(Pageable paginacao);
}
