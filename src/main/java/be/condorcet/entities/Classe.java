package be.condorcet.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "EXO1_CLASSES", schema = "ORA47", catalog = "ORCL")
public class Classe
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classe_generator")
    @SequenceGenerator(name = "classe_generator", sequenceName = "EXO1_CLASSES_SEQ",allocationSize = 1)
    Integer id;

    @NonNull
    String sigle,specialite;

    int annee,nbEleves;
}
