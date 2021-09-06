package ingredients;

public class CreateurViande extends CreateurDingredient
{
    public void creer(){}

    public static Ingredient creerViande(String nom, String description, float qty, EtatM etat)
    {
        return new Viande(nom,description,qty,etat);

    }
}
