package ent.etrs.evaluations.model.daos;

import ent.etrs.evaluations.model.exceptions.DaoException;

import java.util.Optional;
import java.util.SortedSet;

public interface IMatiereDao {

    SortedSet<Matiere> findAll() throws DaoException;

    Optional<Matiere> findById(Integer pId) throws DaoException;

    void remove(Integer pId) throws DaoException;

    Matiere insert(Matiere pMatiere) throws DaoException;

    Matiere update(Matiere pMatiere) throws DaoException;

}
