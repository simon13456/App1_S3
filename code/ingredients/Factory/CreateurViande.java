package ingredients.Factory;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.Factory.Concrete.Viande;
import menufact.exceptions.IngredientException;

/**
 * Cette section devra hériter de CréateurDingredient et faire partie de la factory
 */
public class CreateurViande extends CreateurDingredient
{
    /**
     * La méthode créer doit hériter de la méthode mère.
     * @param nom le nom de l'ingrédient
     * @param description la description litéraire de l'ingrédient
     * @param qty la quantité en inventaire noté en Kg pour les éléments solide et L pour les éléments liquide
     * @param etat Etat de la matière : Solide ou liquide
     * @return null
     * @throws IngredientException
     */
    public CreateurViande(){}
    public Ingredient creer(String nom, String description, float qty, EtatM etat) throws IngredientException {
        return new Viande(nom,description,qty,etat);

    }
}
