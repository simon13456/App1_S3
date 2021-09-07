package ingredients.Factory;

import ingredients.State.EtatM;
import ingredients.Ingredient;
import ingredients.Factory.Concrete.Viande;

public class CreateurViande extends CreateurDingredient
{
    public Ingredient creer(String nom, String description, float qty, EtatM etat)
    {
        return new Viande(nom,description,qty,etat);

    }
}
