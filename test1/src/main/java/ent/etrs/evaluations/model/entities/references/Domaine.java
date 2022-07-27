package ent.etrs.evaluations.model.entities.references;

import lombok.Getter;

public enum Domaine {

    HORS_FORMATION_SPE("Hors formation de spécialité"),
    PRE_REQUIS_METIER("Pré-requis métier"),
    FONDAMENTAUX_SPE("Fondamentaux spécialité"),
    DEV_AVANCE("Développement avancé"),
    TRAVAIL_COLLABORATIF("Travail collaboratif");

    @Getter
    private String nom;

    Domaine(String pNom) {
        this.nom = pNom;
    }

}