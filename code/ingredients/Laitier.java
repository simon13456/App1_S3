package ingredients;

public class Laitier extends Ingredient{
    public Laitier(String nom, String description, float qty, EtatM etat) {
        setTypeIngredient(TypeIngredient.LAITIER);
    }
}
