package ingredients.Factory;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.Factory.Concrete.Laitier;

public class CreateurLaitier extends CreateurDingredient
{


    public Ingredient creer(String nom, String description, float qty, EtatM etat)
    {
        return new Laitier(nom,description,qty,etat);

    }
}
