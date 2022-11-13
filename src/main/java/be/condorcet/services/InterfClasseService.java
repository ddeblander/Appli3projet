package be.condorcet.services;

import be.condorcet.entities.Classe;

import java.util.List;

public interface InterfClasseService  extends InterfService<Classe>
{
    public List<Classe> read(String sigle);

}
