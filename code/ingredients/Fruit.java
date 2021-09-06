package ingredients;

public class Fruit extends Ingredient{
    public Fruit(String nom, String description, float qty, EtatM etat) {
        setTypeIngredient(TypeIngredient.FRUIT);
    }
}
