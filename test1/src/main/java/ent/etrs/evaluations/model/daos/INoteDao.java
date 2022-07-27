package ent.etrs.evaluations.model.daos;

import ent.etrs.evaluations.model.exceptions.DaoException;

import java.util.SortedMap;

public interface INoteDao {

    public SortedMap<Matiere, Integer> getNotesFromStagiaire(Integer pStagiaire) throws DaoException;

    public void removeNotesFromStagiaire(Integer pStagiaireId) throws DaoException;

    public void removeNotesFromMatiere(Integer pMatiereId) throws DaoException;

    public void changeNotesFromStagiaire(Stagiaire pStagiaire) throws DaoException;

}
