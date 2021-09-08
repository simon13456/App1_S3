package ingredients.Factory;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import menufact.exceptions.IngredientException;

/**
 * Cette section doit être une classe abstraite pour l'implémentation d'une factory.
 */
public abstract class CreateurDingredient {
    /**
     * Les créateurs qui en héritrons devront créer des objets Ingrédient d'un type particulier à leur créateur (FRUIT,LEGUME,VIANDE,LAITIER,EPICE)
     * @param nom le nom de l'ingrédient
     * @param description la description litéraire de l'ingrédient
     * @param qty la quantité en inventaire noté en Kg pour les éléments solide et L pour les éléments liquide
     * @param etat Etat de la matière : Solide ou liquide
     * @return null
     * @throws IngredientException
     */
    public Ingredient creer(String nom, String description, float qty, EtatM etat) throws IngredientException {
        return null;
    }

}
