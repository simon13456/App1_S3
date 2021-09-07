package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.Hashtable;


public class IngredientInventaire {
    private static IngredientInventaire instance;
    private int quantite;

    private Hashtable<String, Ingredient> gardeManger;

    private IngredientInventaire() {
        gardeManger = new Hashtable<String, Ingredient>();
    }

    public static synchronized IngredientInventaire getInstance() {
        if (instance == null) {
            instance = new IngredientInventaire();
        }
        return instance;
    }


    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws IngredientException {

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    public void addIngredient(Ingredient ingredient) {
        gardeManger.put(ingredient.getNom(), ingredient);
    }

    public Ingredient getIngredient(Ingredient ingredient) {

        return gardeManger.get(ingredient.getNom());
    }

    public boolean verifierRecette() {

        return true;
    }
}
