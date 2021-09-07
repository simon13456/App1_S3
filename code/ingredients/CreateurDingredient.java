package ingredients;

public class CreateurDingredient {


    public void addIngredient(TypeIngredient typeingredient, String nom, String description, float qty, EtatM etat) {
        IngredientInventaire inventaire = IngredientInventaire.getInstance();
        switch (typeingredient) {
            case FRUIT -> inventaire.addIngredient(CreateurFruit.creerFruit(nom, description, qty, etat));
            case LEGUME -> inventaire.addIngredient(CreateurLegume.creerLegume(nom, description, qty, etat));
            case VIANDE -> inventaire.addIngredient(CreateurViande.creerViande(nom, description, qty, etat));
            case LAITIER -> inventaire.addIngredient(CreateurLaitier.creerLaitier(nom, description, qty, etat));
            case EPICE -> inventaire.addIngredient(CreateurEpice.creerEpice(nom, description, qty, etat));
            default -> throw new IllegalArgumentException("Type d'ingrédient invalide");


        }
    }
}
