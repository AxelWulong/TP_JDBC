package ent.etrs.evaluations.model.facades;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FacadeFactory {

    public static IFacadeMatiere getFacadeMatiere() {
        return new FacadeMatiere();
    }

    public static IFacadeStagiaire getFacadeStagiaire() {
        return new FacadeStagiaire();
    }

    public static IFacadeDomaine getFacadeDomaine() {
        return new FacadeDomaine();
    }

    public static IFacadeGrade getFacadeGrade() {
        return new FacadeGrade();
    }
}
