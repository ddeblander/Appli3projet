package be.condorcet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "EXO1_SALLE", schema = "ORA47", catalog = "ORCL")
public class Salle
{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salle_generator")
    @SequenceGenerator(name = "salle_generator", sequenceName = "SALLE_GENERATOR",allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @NonNull
    @Column(name = "SIGLE")
    private String sigle;
    @NonNull
    @Column(name = "CAPACITE")
    private Integer capacite;
    @JsonIgnore
    @OneToMany(mappedBy = "salle",orphanRemoval = true,cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Classe> classes = new ArrayList<>();
}
