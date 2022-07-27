package ent.etrs.evaluations.model.facades;

import ent.etrs.evaluations.model.exceptions.FacadeException;

import java.util.SortedSet;

public interface IFacadeStagiaire {

    SortedSet<Stagiaire> getAllStagiaires() throws FacadeException;

    Stagiaire addStagiaire(Stagiaire pStagiaire) throws FacadeException;

    Stagiaire updateStagiaire(Stagiaire pStagiaire) throws FacadeException;

    void removeStagiaire(Stagiaire pStagiaire) throws FacadeException;

}
