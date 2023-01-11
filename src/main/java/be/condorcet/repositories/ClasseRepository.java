package be.condorcet.repositories;

import be.condorcet.entities.Classe;
import be.condorcet.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClasseRepository extends JpaRepository<Classe,Integer> {
    public List<Classe> findBySigleLike(String sigle);

    public Classe findByIdAndSigleLike(int id,String sigle);

    public List<Classe> findBySpecialiteLike(String specialite);
}
