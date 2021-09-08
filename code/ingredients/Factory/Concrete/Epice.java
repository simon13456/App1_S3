package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import menufact.exceptions.IngredientException;

public class Epice extends Ingredient {
    public Epice(String nom, String description, double qty, EtatM etat) throws IngredientException {
    setTypeIngredient(TypeIngredient.EPICE);
    setNom(nom);
    setDescription(description);
    setEtatM(etat);
        if(qty>=0){
            setQty(qty);
        }
        else{
            throw new IngredientException("Il ne peux pas y avoir une qty négative d'épice'");
        }

    }
}
