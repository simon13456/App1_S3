package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;

public class Legume extends Ingredient {
    public Legume(String nom, String description, float qty, EtatM etat) {

        setTypeIngredient(TypeIngredient.LEGUME);
        setNom(nom);
        setDescription(description);
        setQty(qty);
        setEtatM(etat);
    }
}
