package entities;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "EXO1_COURS", schema = "ORA47", catalog = "ORCL")
public class Cours
{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cours_generator")
    @SequenceGenerator(name = "cours_generator", sequenceName = "EXO1_COURS_SEQ",allocationSize = 1)
    @NonNull
    private String  code;
    @NonNull
    private String intitule;

}
