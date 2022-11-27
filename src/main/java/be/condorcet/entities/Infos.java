package be.condorcet.entities;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "EXO1_INFOS", schema = "ORA47", catalog = "ORCL")
public class Infos
{
/*  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cours_generator")
    @SequenceGenerator(name = "cours_generator", sequenceName = "EXO1_COURS_SEQ",allocationSize = 1)
    private Integer idcours;
    @NonNull
    private String code;
    @NonNull
    private String intitule;*/

    @Id
    private Integer ID_classes,IDcours_cours;
}
