package ingredients.Factory;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.Factory.Concrete.Legume;

public class CreateurLegume extends CreateurDingredient {


    public Ingredient creer(String nom, String description, float qty, EtatM etat) {
        return new Legume(nom, description, qty, etat);

    }
}
