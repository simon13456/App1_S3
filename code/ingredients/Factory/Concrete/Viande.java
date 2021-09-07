package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;

public class Viande extends Ingredient {
    public Viande(String nom, String description, float qty, EtatM etat) {
        setTypeIngredient(TypeIngredient.VIANDE);
        setNom(nom);
        setDescription(description);
        setQty(qty);
        setEtatM(etat);
    }
}
