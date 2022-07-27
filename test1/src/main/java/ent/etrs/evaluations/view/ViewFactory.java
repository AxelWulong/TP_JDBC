package ent.etrs.evaluations.view;

import ent.etrs.evaluations.view.impl.View;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViewFactory {

    public static IView getView() {
        return new View();
    }

}
