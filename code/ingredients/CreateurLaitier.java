package ingredients;

public class CreateurLaitier extends CreateurDingredient
{
    public void creer(){}

    public static Ingredient creerLaitier(String nom, String description, float qty, EtatM etat)
    {
        return new Laitier(nom,description,qty,etat);

    }
}
