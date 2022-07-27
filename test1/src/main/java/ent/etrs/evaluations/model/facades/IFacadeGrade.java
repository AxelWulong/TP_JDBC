package ent.etrs.evaluations.model.facades;

import ent.etrs.evaluations.model.entities.references.Grade;

import java.util.SortedSet;

public interface IFacadeGrade {

    SortedSet<Grade> getAllGrades();

}
