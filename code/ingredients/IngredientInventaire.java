package ingredients;

import ingredients.exceptions.IngredientException;
import menufact.plats.Recette;

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

    public boolean verifierRecette(Recette recette) {
        for (int i = 0; i < recette.getIngredientRequis().length; i++)
            if (!gardeManger.containsKey(recette.getIngredientRequis()[i].getNom()))
                return false;
        for (int i = 0; i < recette.getIngredientRequis().length; i++)
            if (gardeManger.get((recette.getIngredientRequis()[i].getNom())).getQty() < recette.getIngredientRequis()[i].getQty())
                return false;

        return true;
    }

    public void consommerIngredient(Recette recette) {
        for (Ingredient ingredient : recette.getIngredientRequis()) {
            gardeManger.replace(ingredient.getNom(), gardeManger.get(ingredient.getNom()).setQtyAndReturn(gardeManger.get(ingredient.getNom()).getQty() - ingredient.getQty()));
            ;
        }
    }
}
