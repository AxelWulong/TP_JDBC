package ent.etrs.evaluations.launcher;

import ent.etrs.evaluations.controller.Presenter;
import ent.etrs.evaluations.model.facades.*;
import ent.etrs.evaluations.view.IView;
import ent.etrs.evaluations.view.ViewFactory;

public class Launch {

    public static void main(String[] args) {
        try {
            IFacadeMatiere facadeMatiere = FacadeFactory.getFacadeMatiere();
            IFacadeDomaine facadeDomaine = FacadeFactory.getFacadeDomaine();
            IFacadeGrade facadeGrade = FacadeFactory.getFacadeGrade();
            IFacadeStagiaire facadeStagiaire = FacadeFactory.getFacadeStagiaire();

            IView view = ViewFactory.getView();

            new Presenter(facadeMatiere, facadeDomaine, facadeStagiaire, facadeGrade, view).run();
        } catch (Exception e) {
            System.out.println("Une erreur est survenue. Veuillez contacter le service client.");
        }
    }

}
