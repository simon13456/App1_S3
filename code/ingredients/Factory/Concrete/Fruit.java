package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import menufact.exceptions.IngredientException;

public class Fruit extends Ingredient {


    public Fruit(String nom, String description, double qty, EtatM etat) throws IngredientException {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(nom);
        setDescription(description);
        setEtatM(etat);
        if(qty>=0){
            setQty(qty);
        }
        else{
            throw new IngredientException("Il ne peux pas y avoir une qty négative de fruit");
        }
    }
}
