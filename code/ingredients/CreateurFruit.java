package ingredients;

public class CreateurFruit extends CreateurDingredient {
    public void creer() {
    }
    
    public static Ingredient creerFruit(String nom, String description, float qty, EtatM etat) {
        return new Fruit(nom, description, qty, etat);

    }
}
