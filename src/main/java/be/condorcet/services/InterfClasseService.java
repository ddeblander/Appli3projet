package be.condorcet.services;

import be.condorcet.entities.Classe;
import be.condorcet.entities.Cours;

import java.util.List;

public interface InterfClasseService  extends InterfService<Classe>
{
    public List<Classe> read(String sigle);

    public Classe read(int id, String sigle);

    public List<Classe> readS(String specialite);

}
