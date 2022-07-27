package ent.etrs.evaluations.model.daos;

import ent.etrs.evaluations.model.exceptions.DaoException;

import java.util.Optional;
import java.util.SortedSet;

public interface IStagiaireDao {

    SortedSet<Stagiaire> findAll() throws DaoException;

    Optional<Stagiaire> findById(Integer pId) throws DaoException;

    void remove(Integer pId) throws DaoException;

    Stagiaire insert(Stagiaire pStagiaire) throws DaoException;

    Stagiaire update(Stagiaire pStagiaire) throws DaoException;

}
