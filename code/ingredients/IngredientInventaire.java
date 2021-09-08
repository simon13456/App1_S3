package ingredients;

import ingredients.exceptions.IngredientException;
import menufact.plats.Recette;

import java.util.Hashtable;

/**
 * Cette section sert à l'implémentation de la classe IngrédientInventaire pour garder les quantités en magasin ...
 */
public class IngredientInventaire {
    private static IngredientInventaire instance;
    private int quantite;

    private Hashtable<String, Ingredient> gardeManger;

    /**
     * Avoir un créateur pour l'objet inventaire
     * param void
     * return void
     */
    public IngredientInventaire() {
        gardeManger = new Hashtable<String, Ingredient>();
    }

    /**
     * Créer une méthode pour s'assurer que l'inventaire est un singleton
     * void
     * @return instance
     */
    public static synchronized IngredientInventaire getInstance() {
        if (instance == null) {
            instance = new IngredientInventaire();
        }
        return instance;
    }

    /**
     * Méthode pour obtenir l'attribut quantite dans l'objet inventaire
     * @return
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Méthode pour modifier l'attribut quantite dans l'objet inventaire
     * @param quantite
     * @throws IngredientException
     */
    public void setQuantite(int quantite) throws IngredientException {

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    /**
     * Méthode pour ajouter un objet ingrédient dans l'inventaire
     * @param ingredient
     * @return void
     */
    public void addIngredient(Ingredient ingredient) {
        gardeManger.put(ingredient.getNom(), ingredient);
    }

    /**
     * Méthode pour obtenir un objet ingrédient dans l'inventaire
     * @param ingredient
     * @return ingredient
     */
    public Ingredient getIngredient(Ingredient ingredient) {

        return gardeManger.get(ingredient.getNom());
    }

    /**
     * Méthode pour vérifier si tous les ingrédients sont disponnible pour accomplir la recette
     * @param recette
     * @return Boolean
     */
    public boolean verifierRecette(Recette recette) {
        for (int i = 0; i < recette.getIngredientRequis().length; i++)
            if (!gardeManger.containsKey(recette.getIngredientRequis()[i].getNom()))
                return false;
        for (int i = 0; i < recette.getIngredientRequis().length; i++)
            if (gardeManger.get((recette.getIngredientRequis()[i].getNom())).getQty() < recette.getIngredientRequis()[i].getQty())
                return false;
        return true;
    }

    /**
     * Méthode pour modifier la quantité d'ingrédient apres les avoir ajouté à la recette
     * @param recette
     * @return void
     */
    public void consommerIngredient(Recette recette) {
        for (Ingredient ingredient : recette.getIngredientRequis()) {
            gardeManger.replace(ingredient.getNom(), gardeManger.get(ingredient.getNom()).setQtyAndReturn((float) (gardeManger.get(ingredient.getNom()).getQty() - ingredient.getQty())));
            ;
        }
    }
}
