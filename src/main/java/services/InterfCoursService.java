package services;

import entities.Cours;

import java.util.List;

public interface InterfCoursService extends InterfService<Cours>{
    public List<Cours> read(String nom);
}

