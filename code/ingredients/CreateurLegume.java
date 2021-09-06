package ingredients;

public class CreateurLegume extends CreateurDingredient {


    public void creer() {}

    public static Ingredient creerLegume(String nom, String description, float qty, EtatM etat) {
        return new Legume(nom, description, qty, etat);

    }
}
