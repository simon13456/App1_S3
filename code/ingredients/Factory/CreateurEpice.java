package ingredients.Factory;

import ingredients.Factory.Concrete.Epice;
import ingredients.State.EtatM;
import ingredients.Ingredient;

public class CreateurEpice extends CreateurDingredient
{
    public Ingredient creer(String nom, String description, float qty, EtatM etat)
    {
        return new Epice(nom,description,qty,etat);

    }
}