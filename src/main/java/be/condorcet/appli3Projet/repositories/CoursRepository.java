package be.condorcet.appli3Projet.repositories;

import entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;


@Repository
public interface CoursRepository extends JpaRepository<Cours,Integer> {
    public List<Cours> findByNomLike(String nom);
}
