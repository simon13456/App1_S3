package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import menufact.exceptions.IngredientException;

public class Laitier extends Ingredient {
    public Laitier(String nom, String description, double qty, EtatM etat) throws IngredientException {

        setTypeIngredient(TypeIngredient.LAITIER);
        setNom(nom);
        setDescription(description);
        setEtatM(etat);
        if(qty>=0){
            setQty(qty);
        }
        else{
            throw new IngredientException("Il ne peux pas y avoir une qty négative de produit laitier");
        }
    }
}
