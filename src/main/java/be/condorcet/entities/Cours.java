package be.condorcet.entities;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "EXO1_COURS", schema = "ORA47", catalog = "ORCL")
public class Cours
{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cours_generator")
    @SequenceGenerator(name = "cours_generator", sequenceName = "COURS_GENERATOR",allocationSize = 1)
    private Integer idcours;
    @NonNull
    private String code;
    @NonNull
    private String intitule;


}
