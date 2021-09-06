package ingredients;

public class Viande extends Ingredient{
    public Viande(String nom, String description, float qty, EtatM etat) {
        setTypeIngredient(TypeIngredient.VIANDE);
    }
}
