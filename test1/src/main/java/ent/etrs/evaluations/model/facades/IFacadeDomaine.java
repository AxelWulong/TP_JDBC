package ent.etrs.evaluations.model.facades;

import ent.etrs.evaluations.model.entities.references.Domaine;

import java.util.SortedSet;

public interface IFacadeDomaine {

    SortedSet<Domaine> getAllDomaines();

}
