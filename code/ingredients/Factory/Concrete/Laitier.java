package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;

public class Laitier extends Ingredient {
    public Laitier(String nom, String description, float qty, EtatM etat) {

        setTypeIngredient(TypeIngredient.LAITIER);
        setNom(nom);
        setDescription(description);
        setQty(qty);
        setEtatM(etat);
    }
}
