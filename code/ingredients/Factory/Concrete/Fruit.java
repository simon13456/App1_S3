package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import menufact.exceptions.IngredientException;
/**
 * Classe concrete d'ingrédient de type fruit
 */
public class Fruit extends Ingredient {

    /**
     * Constructeur de fruit
     * @param nom le nom de l'ingrédient
     * @param description la description litéraire de l'ingrédient
     * @param qty la quantité en inventaire noté en Kg pour les éléments solide et L pour les éléments liquide
     * @param etat Etat de la matière : Solide ou liquide
     * @throws IngredientException
     */
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
