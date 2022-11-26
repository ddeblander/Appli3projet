package be.condorcet.repositories;

import be.condorcet.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CoursRepository extends JpaRepository<Cours,Integer> {
    public List<Cours> findByIntituleLike(String intitule);
    public Cours findCoursByCodeAndIntitule(String code,String intitule);
}
