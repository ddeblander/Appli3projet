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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classe_generator")
    @SequenceGenerator(name = "classe_generator", sequenceName = "EXO1_CLASSES_SEQ",allocationSize = 1)
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
}
