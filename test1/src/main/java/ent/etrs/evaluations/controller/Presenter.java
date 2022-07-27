package ent.etrs.evaluations.controller;

import ent.etrs.evaluations.model.facades.IFacadeDomaine;
import ent.etrs.evaluations.model.facades.IFacadeGrade;
import ent.etrs.evaluations.model.facades.IFacadeMatiere;
import ent.etrs.evaluations.model.facades.IFacadeStagiaire;
import ent.etrs.evaluations.view.IView;

public class Presenter {

    private final IFacadeMatiere facadeMatiere;
    private final IFacadeDomaine facadeDomaine;
    private final IFacadeGrade facadeGrade;
    private final IFacadeStagiaire facadeStagiaire;

    private final IView view;

    public Presenter(IFacadeMatiere facadeMatiere, IFacadeDomaine facadeDomaine, IFacadeStagiaire facadeStagiaire, IFacadeGrade facadeGrade, IView view) {
        this.facadeMatiere = facadeMatiere;
        this.facadeDomaine = facadeDomaine;
        this.facadeGrade = facadeGrade;
        this.facadeStagiaire = facadeStagiaire;
        this.view = view;
    }

    public void run() {
        boolean exit = false;

        while (!exit) {

            int choixMenuPrincipal = this.view.choisirMenuPrincipal();

            switch (choixMenuPrincipal) {
                case 1:
                    this.creerMatiere();
                    break;
                case 2:
                    this.creerStagiaire();
                    break;
                case 3:
                    this.ajouterNote();
                    break;
                case 4:
                    this.supprimerUnStagiaire();
                    break;
                case 5:
                    this.supprimerUneMatiere();
                    break;
                case 6:
                    this.afficherLesStagiaires();
                    break;
                case 7:
                    this.afficherLesMatieres();
                    break;
                case 0:
                    this.view.afficherMessage("Aurevoir");
                    exit = true;
                    break;
                default:
                    this.view.afficherErreur("Choix incorrect");
                    break;
            }

        }

    }

    private void ajouterNote() {
        try {
            this.view.afficherMessage("Choisissez le stagiaire sur lequel vous voulez ajouter une note");
            Stagiaire stagiaire = this.view.choisirStagiaire(this.facadeStagiaire.getAllStagiaires());

            this.view.afficherMessage("Choisissez la matière");
            Matiere matiere = this.view.choisirMatiere(this.facadeMatiere.getAllMatieres());

            boolean noteOk = false;
            int note = 0;
            do {
                this.view.afficherMessage("Quel est la note ?");
                note = this.view.demanderUnNombre();
                if (note >= 0 && note <= 20) {
                    noteOk = true;
                } else {
                    this.view.afficherErreur("La note doit être comprise entre 0 et 20.");
                }
            } while (!noteOk);

            stagiaire.ajouterNote(matiere, note);
            this.facadeStagiaire.updateStagiaire(stagiaire);

        } catch (Exception e) {
            this.view.afficherErreur("Erreur lors de l'ajout de la note");
        }
    }

    private void supprimerUneMatiere() {
        try {
            this.view.afficherMessage("Choisissez la matière à supprimer");
            Matiere matiere = this.view.choisirMatiere(this.facadeMatiere.getAllMatieres());
            this.facadeMatiere.removeMatiere(matiere);
        } catch (Exception e) {
            this.view.afficherErreur("Erreur lors de la suppression d'une matière");
        }
    }

    private void supprimerUnStagiaire() {
        try {
            this.view.afficherMessage("Choisissez le stagiaire à supprimer");
            Stagiaire stagiaire = this.view.choisirStagiaire(this.facadeStagiaire.getAllStagiaires());
            this.facadeStagiaire.removeStagiaire(stagiaire);
        } catch (Exception e) {
            this.view.afficherErreur("Erreur lors de la suppression d'un stagiaire");
        }
    }

    private void creerStagiaire() {
        try {
            Stagiaire stagiaire = this.view.creationStagiaire(this.facadeGrade.getAllGrades());
            this.facadeStagiaire.addStagiaire(stagiaire);
        } catch (Exception e) {
            this.view.afficherErreur("Erreur lors de l'ajout du stagiaire");
        }
    }

    private void afficherLesMatieres() {
        try {
            this.view.afficherLesMatieres(this.facadeMatiere.getAllMatieres());
        } catch (Exception e) {
            this.view.afficherErreur("Erreur lors du listing des matières");
        }
    }

    private void afficherLesStagiaires() {
        try {
            this.view.afficherLesStagiaires(this.facadeStagiaire.getAllStagiaires());
        } catch (Exception e) {
            this.view.afficherErreur("Erreur lors du listing des stagiaires");
        }
    }

    private void creerMatiere() {
        try {
            Matiere newMatiere = this.view.creationMatiere(this.facadeDomaine.getAllDomaines());
            this.facadeMatiere.addMatiere(newMatiere);
        } catch (Exception e) {
            this.view.afficherErreur("Erreur lors de l'ajout d'une matière'");
        }
    }
}
