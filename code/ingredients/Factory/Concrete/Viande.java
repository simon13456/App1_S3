package ingredients.Factory.Concrete;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import menufact.exceptions.IngredientException;
/**
 * Classe concrete d'ingrédient de viande
 */
public class Viande extends Ingredient {
    /**
     * Constructeur de Viande
     * @param nom le nom de l'ingrédient
     * @param description la description litéraire de l'ingrédient
     * @param qty la quantité en inventaire noté en Kg pour les éléments solide et L pour les éléments liquide
     * @param etat Etat de la matière : Solide ou liquide
     * @throws IngredientException
     */
    public Viande(String nom, String description, double qty, EtatM etat) throws IngredientException {
        setTypeIngredient(TypeIngredient.VIANDE);
        setNom(nom);
        setDescription(description);
        setEtatM(etat);
        if(qty>=0){
            setQty(qty);
        }
        else{
            throw new IngredientException("Il ne peux pas y avoir une qty négative de viande");
        }
    }
}
