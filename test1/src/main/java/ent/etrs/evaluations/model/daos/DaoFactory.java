package ent.etrs.evaluations.model.daos;

import ent.etrs.evaluations.model.daos.impl.MatiereDao;
import ent.etrs.evaluations.model.daos.impl.NoteDao;
import ent.etrs.evaluations.model.daos.impl.StagiaireDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DaoFactory {

    public static IStagiaireDao getStagiaireDao() {
        return new StagiaireDao();
    }

    public static IMatiereDao getMatiereDao() {
        return new MatiereDao();
    }

    public static INoteDao getNoteDao() {
        return new NoteDao();
    }

}
