package com.example.exercice1_1.repositories;

import entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CoursRepository extends JpaRepository<Cours,Integer> {
    public List<Cours> findByNomLike(String nom);
}
