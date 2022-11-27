package be.condorcet.entities;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "EXO1_CLASSES", schema = "ORA47", catalog = "ORCL")
public class Classe
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classes_generator")
    @SequenceGenerator(name = "classes_generator", sequenceName = "CLASSES_GENERATOR",allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @NonNull
    @Column(name = "SIGLE")
    private String sigle;
    @NonNull
    @Column(name = "SPECIALITE")
    private String specialite;
    @NonNull
    @Column(name = "ANNEE")
    private int annee;
    @NonNull
    @Column(name = "NBELEVES")
    private int nbEleves;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "ID_SALLE")
    private Salle salle;
}
