package menufact.plats;

import ingredients.Ingredient;

public class Recette {
    private Ingredient[] IngredientRequis;
    public Recette(Ingredient[] listeIngredient) {this.IngredientRequis = listeIngredient;}
    public Ingredient[] getIngredientRequis() {
        return IngredientRequis;
    }
}
