package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;

public class Fruit extends Ingredient {
    public Fruit(String nom, String description, float qty, EtatM etat) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(nom);
        setDescription(description);
        setQty(qty);
        setEtatM(etat);
    }
}
