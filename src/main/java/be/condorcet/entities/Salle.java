package be.condorcet.entities;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "EXO1_COURS", schema = "ORA47", catalog = "ORCL")
public class Salle
{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cours_generator")
    @SequenceGenerator(name = "cours_generator", sequenceName = "EXO1_COURS_SEQ",allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @NonNull
    @Column(name = "SIGLE")
    private String sigle;
    @NonNull
    @Column(name = "CAPACITE")
    private Integer capacite;
}
