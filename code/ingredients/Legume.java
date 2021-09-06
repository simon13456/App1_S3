package ingredients;

public class Legume extends Ingredient{
    public Legume(String nom, String description, float qty, EtatM etat) {
        setTypeIngredient(TypeIngredient.LEGUME);
    }
}
