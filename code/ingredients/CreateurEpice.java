package ingredients;

public class CreateurEpice extends CreateurDingredient
{
    public void creerEpice(){}

    public static Ingredient creerEpice(String nom, String description, float qty, EtatM etat)
    {
        return new Epice(nom,description,qty,etat);

    }
}