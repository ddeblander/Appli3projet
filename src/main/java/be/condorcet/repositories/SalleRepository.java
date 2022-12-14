package be.condorcet.repositories;

import be.condorcet.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Integer>
{
    public List<Salle> findBySigleLike(String sigle);

    public Salle findByIdAndSigleLike(int id,String sigle);
}
