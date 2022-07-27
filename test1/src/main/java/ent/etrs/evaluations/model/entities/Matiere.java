package ent.etrs.evaluations.model.entities;

import ent.etrs.evaluations.model.entities.references.Domaine;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Classe qui represente une matière.
 */

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "nom", "domaine", "coefficient"})
@EqualsAndHashCode(of = {"nom", "domaine"})
public class Matiere implements Comparable<Matiere> {


    private Integer id;

    @Size(min = 1, max = 20)
    @NotBlank
    @NonNull
    private String nom;

    @NotNull
    @NonNull
    private Domaine domaine;

    @NotNull
    @Positive
    @NonNull
    private Integer coefficient;


    // METHODES //

    /**
     * Compare deux objets de type Matière.
     *
     * @param o the object to be compared.
     * @return 1 si faux 0 si vrai.
     */

    @Override
    public int compareTo(Matiere o) {
        if (this.equals(o))
            return 0;
        else
            return 1;
    }


}
