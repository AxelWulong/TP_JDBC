package ent.etrs.evaluations.model.entities;


import ent.etrs.evaluations.model.entities.references.C;
import ent.etrs.evaluations.model.entities.references.Grade;
import ent.etrs.evaluations.model.exceptions.StagiaireException;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.SortedMap;

/**
 * Classe representant un Stagaire.
 */
@EqualsAndHashCode(of = {"nid"})
@ToString(of = {"nid", "garde", "nom", "prenom", "notes"})
@Getter
@Setter
@RequiredArgsConstructor
public class Stagiaire implements Comparable<Stagiaire> {
    private Integer id;
    @NonNull
    @Pattern(regexp = "[\\d]{10}")
    private String nid;

    @NonNull
    @NotBlank
    private Grade grade;
    @NonNull
    @NotBlank
    @Max(20)
    private String nom;
    @NonNull
    @NotBlank
    @Max(20)
    private String prenom;

    private SortedMap<Matiere, Integer> notes;

    // METHODES //

    /**
     * Compare deux objets de classe Stagiaire.
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Stagiaire o) {
        if (this.equals(o))
            return 0;
        else
            return 1;
    }

    /**
     * Ajoute une note à la map.
     *
     * @param matiere
     * @param note
     */
    public void ajouterUneNote(Matiere matiere, Integer note) throws StagiaireException {
        if (Objects.isNull(matiere))
            throw new StagiaireException(String.format(C.PATTERN_PARAMS_NULL, "matiere"));
        if (Objects.isNull(note) || note < 0 || note > 20)
            throw new StagiaireException(String.format(C.PATTERN_NOTE_INVALIDE, "note"));
        notes.put(matiere, note);
    }
}
