package _daysofcode.demo.infra;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroisRepository extends JpaRepository<SuperHerois,Long> {
    void deleteAllById(Long id);
}
