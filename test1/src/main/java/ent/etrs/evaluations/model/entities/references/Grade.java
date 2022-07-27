package ent.etrs.evaluations.model.entities.references;

import lombok.Getter;

public enum Grade {

    AV2("Aviateur de seconde classe"),
    AV1("Aviateur de première classe"),
    CAL("Caporal"),
    CLC("Caporal-Chef"),
    SGT("Sergent"),
    SGC("Sergent-Chef"),
    ADJ("Adjudant"),
    ADC("Adjudant-Chef"),
    MAJ("Major"),
    ASP("Aspirant"),
    SLT("Sous-Lieutenant"),
    LTT("Lieutenant"),
    CNE("Capitaine"),
    CDT("Commandant"),
    LCL("Lieutenant-Colonel"),
    COL("Colonel"),
    GBA("Général de brigade Aérienne"),
    GDA("Général de division Aérienne"),
    GCA("Général de corps Aérien"),
    GAA("Général d'armée Aérienne");

    @Getter
    private String nom;

    Grade(String pNom) {
        this.nom = pNom;
    }

}