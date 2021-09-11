package ingredients.Factory;

import ingredients.Factory.Concrete.Epice;
import ingredients.State.EtatM;
import ingredients.Ingredient;
import menufact.exceptions.IngredientException;

/**
 * Cette section devra hériter de CréateurDingredient et faire partie de la factory
 */
public class CreateurEpice extends CreateurDingredient
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
    public CreateurEpice(){}
    public Ingredient creer(String nom, String description, float qty, EtatM etat) throws IngredientException {
        return new Epice(nom,description,qty,etat);

    }
}