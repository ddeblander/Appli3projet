package be.condorcet.services;

import be.condorcet.entities.Classe;
import be.condorcet.entities.Salle;

import java.util.List;

public interface InterfSalleService extends InterfService<Salle>
{
    public List<Salle> read(String sigle);

    public Salle read(int id, String sigle);
}
