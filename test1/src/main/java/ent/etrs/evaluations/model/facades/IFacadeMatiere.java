package ent.etrs.evaluations.model.facades;

import ent.etrs.evaluations.model.exceptions.FacadeException;

import java.util.SortedSet;

public interface IFacadeMatiere {

    public SortedSet<Matiere> getAllMatieres() throws FacadeException;

    public Matiere addMatiere(Matiere pMatiere) throws FacadeException;

    public void removeMatiere(Matiere pMatiere) throws FacadeException;

}
