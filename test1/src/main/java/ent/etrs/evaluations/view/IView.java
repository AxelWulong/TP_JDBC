package ent.etrs.evaluations.view;

import ent.etrs.evaluations.model.entities.references.Domaine;
import ent.etrs.evaluations.model.entities.references.Grade;

import java.util.SortedSet;

public interface IView {

    Integer choisirMenuPrincipal();

    Matiere creationMatiere(SortedSet<Domaine> domaines);

    Stagiaire creationStagiaire(SortedSet<Grade> grades);

    Stagiaire choisirStagiaire(SortedSet<Stagiaire> pStagiaire);

    Matiere choisirMatiere(SortedSet<Matiere> matieres);

    void afficherLesMatieres(SortedSet<Matiere> matieres);

    void afficherLesStagiaires(SortedSet<Stagiaire> pStagiaire);

    int demanderUnNombre();

    void afficherMessage(String message);

    void afficherErreur(String erreur);
}
