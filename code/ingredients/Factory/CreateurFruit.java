package ingredients.Factory;

import ingredients.State.EtatM;
import ingredients.Factory.Concrete.Fruit;
import ingredients.Ingredient;

public class CreateurFruit extends CreateurDingredient {
    public Ingredient creer(String nom, String description, float qty, EtatM etat) {
        return new Fruit(nom, description, qty, etat);

    }
}
