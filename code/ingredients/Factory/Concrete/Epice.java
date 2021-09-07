package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;

public class Epice extends Ingredient {
    public Epice(String nom, String description, float qty, EtatM etat){
    setTypeIngredient(TypeIngredient.EPICE);
    setNom(nom);
    setDescription(description);
    setQty(qty);
    setEtatM(etat);
    }
}
