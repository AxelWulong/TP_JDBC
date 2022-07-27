package ent.etrs.evaluations.view.impl;

import ent.etrs.evaluations.model.entities.references.Domaine;
import ent.etrs.evaluations.model.entities.references.Grade;
import ent.etrs.evaluations.view.IView;

import java.util.*;

public class View implements IView {

    @Override
    public Integer choisirMenuPrincipal() {
        StringBuilder sb = new StringBuilder();
        sb.append("|-----------------------------------|\n");
        sb.append("|-------------- MENU ---------------|\n");
        sb.append("|-----------------------------------|\n");
        sb.append("|- 1 - CREER UNE MATIERE -----------|\n");
        sb.append("|- 2 - CREER UN STAGIAIRE ----------|\n");
        sb.append("|- 3 - AJOUTER UNE NOTE ------------|\n");
        sb.append("|- 4 - SUPPRIMER UN STAGIAIRE ------|\n");
        sb.append("|- 5 - SUPPRIMER UNE MATIERE -------|\n");
        sb.append("|- 6 - LISTER LES STAGIAIRES -------|\n");
        sb.append("|- 7 - LISTER LES MATIERES ---------|\n");
        sb.append("|-----------------------------------|\n");
        sb.append("|- 0 - QUITTER----------------------|\n");
        sb.append("|-----------------------------------|\n");

        System.out.print(sb.toString());
        System.out.print(">> Votre Choix : ");
        return this.demanderUnNombre();
    }

    @Override
    public Matiere creationMatiere(SortedSet<Domaine> domaines) {
        List<Domaine> listDomaines = new ArrayList<>(domaines);
        Domaine domaine = null;
        System.out.printf("|----------------------------| %n");
        while (domaine == null) {
            for (int i = 1; i <= listDomaines.size(); i++) {
                System.out.printf("| %3d | %-20s | %n", i, listDomaines.get(i - 1));
            }
            System.out.printf("|----------------------------| %n");
            System.out.println(">> Veuillez choisir un domaine :");
            int choix = this.demanderUnNombre();
            if (choix > 0 && choix <= listDomaines.size()) {
                domaine = listDomaines.get(choix - 1);
            } else {
                this.afficherErreur("domaine invalide");
            }
        }
        Matiere matiere = null;
        while (matiere == null) {
            System.out.printf(">> Veuillez donnez le nom de la matière (%s) : ", domaine.getNom());
            String choixNom = new Scanner(System.in).nextLine();
            System.out.printf(">> Veuillez donnez le coefficient de la matière (%s) : ", domaine.getNom() + "-" + choixNom);
            Integer choixCoeff = new Scanner(System.in).nextInt();
            if (!choixNom.trim().equals("")) {
                matiere = EntityFactory.buildMatiere(choixNom, domaine, choixCoeff);
            } else {
                this.afficherErreur("Nom ou coefficient invalide");
            }
        }
        return matiere;
    }

    @Override
    public Stagiaire creationStagiaire(SortedSet<Grade> grades) {
        List<Grade> listGrades = new ArrayList<>(grades);
        Grade grade = null;
        System.out.printf("|----------------------------| %n");
        while (grade == null) {
            for (int i = 1; i <= listGrades.size(); i++) {
                System.out.printf("| %3d | %-20s | %n", i, listGrades.get(i - 1));
            }
            System.out.printf("|----------------------------| %n");
            System.out.println(">> Veuillez choisir un grade :");
            int choix = this.demanderUnNombre();
            if (choix > 0 && choix <= listGrades.size()) {
                grade = listGrades.get(choix - 1);
            } else {
                this.afficherErreur("grade invalide");
            }
        }
        Stagiaire stagiaire = null;
        while (stagiaire == null) {
            System.out.printf(">> Veuillez donnez le nid du stagiaire : ");
            String choixNid = new Scanner(System.in).nextLine();
            System.out.printf(">> Veuillez donnez le nom du stagiaire : ");
            String choixNom = new Scanner(System.in).nextLine();
            System.out.printf(">> Veuillez donnez le prénom du stagiaire : ");
            String choixPrenom = new Scanner(System.in).nextLine();
            if (!choixNom.trim().equals("")) {
                stagiaire = EntityFactory.buildStagiaire(choixNid, grade, choixNom, choixPrenom);
            } else {
                this.afficherErreur("Nom du stagiaire invalide");
            }
        }
        return stagiaire;
    }

    @Override
    public Stagiaire choisirStagiaire(SortedSet<Stagiaire> pStagiaire) {
        List<Stagiaire> listStagiaires = new ArrayList<>(pStagiaire);
        Stagiaire stagiaire = null;
        System.out.printf("|---------------------------------------------------------------------------------------| %n");
        while (stagiaire == null) {
            for (int i = 1; i <= listStagiaires.size(); i++) {
                System.out.printf("| %3d | %-10s | %-20s | %-20s | %-20s | %n", i, listStagiaires.get(i - 1).getNid(), listStagiaires.get(i - 1).getGrade().getNom(), listStagiaires.get(i - 1).getNom(), listStagiaires.get(i - 1).getPrenom());
            }
            System.out.printf("|---------------------------------------------------------------------------------------| %n");
            System.out.println(">> Veuillez choisir une stagiaire :");
            int choix = this.demanderUnNombre();
            if (choix > 0 && choix <= listStagiaires.size()) {
                stagiaire = listStagiaires.get(choix - 1);
            } else {
                this.afficherErreur("Stagiaire invalide");
            }
        }
        return stagiaire;
    }

    @Override
    public Matiere choisirMatiere(SortedSet<Matiere> matieres) {
        List<Matiere> listeMatieres = new ArrayList<Matiere>(matieres);
        Matiere matiere = null;
        System.out.printf("|----------------------------| %n");
        while (matiere == null) {
            for (int i = 1; i <= listeMatieres.size(); i++) {
                System.out.printf("| %3d | %-20s | %n", i, listeMatieres.get(i - 1).getNom());
            }
            System.out.printf("|----------------------------| %n");
            System.out.println(">> Veuillez choisir une matière :");
            int choix = this.demanderUnNombre();
            if (choix > 0 && choix <= listeMatieres.size()) {
                matiere = listeMatieres.get(choix - 1);
            } else {
                this.afficherErreur("Matière invalide");
            }
        }
        return matiere;
    }

    @Override
    public void afficherLesMatieres(SortedSet<Matiere> matieres) {
        System.out.printf("|------------------------------------------------------------ -| %n");
        System.out.printf("| %-20s | %-20s| %-15s | %n", "DOMAINE", "NOM", "COEFFICIENT");
        System.out.printf("|------------------------------------------------------------ -| %n");
        for (Matiere matiere : matieres) {
            System.out.printf("| %-20s | %-20s| %-15d | %n", matiere.getDomaine().getNom(), matiere.getNom(), matiere.getCoefficient());
        }
        System.out.printf("|------------------------------------------------------------ -| %n");

        this.attendre();
    }

    @Override
    public void afficherLesStagiaires(SortedSet<Stagiaire> pStagiaire) {
        for (Stagiaire stagiaire : pStagiaire) {
            System.out.printf("|---------------------------------------------------------------------------------| %n");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | %n", stagiaire.getNid(), stagiaire.getGrade().getNom(), stagiaire.getNom(), stagiaire.getPrenom());
            System.out.printf("|---------------------------------------------------------------------------------| %n");
            System.out.printf("| %10s | %-20s | %-20s | %-20s | %n", "NOTE", "COEFFICIENT", "MATIERE", "DOMAINE");
            System.out.printf("|---------------------------------------------------------------------------------| %n");
            for (Map.Entry<Matiere, Integer> note : stagiaire.getNotes().entrySet()) {
                System.out.printf("| --> %6d | %-20d | %-20s | %-20s | %n", note.getValue(), note.getKey().getCoefficient(), note.getKey().getNom(), note.getKey().getDomaine().getNom());
            }
        }
        System.out.printf("|---------------------------------------------------------------------------------| %n");

        this.attendre();

    }

    @Override
    public int demanderUnNombre() {
        return new Scanner(System.in).nextInt();
    }

    @Override
    public void afficherMessage(String message) {
        System.out.printf("** %s ** %n", message);
    }

    @Override
    public void afficherErreur(String erreur) {
        System.out.printf("/!\\ %s /!\\ %n", erreur);
    }

    private void attendre() {
        System.out.println(">> Appuyer sur entrer pour continuer !");
        new Scanner(System.in).nextLine();
    }
}
