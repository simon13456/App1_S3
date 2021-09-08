package menufact.exceptions;
/**
 * Cette section sera utile pour les exceptions concernant les ingrédients.
 */
public class IngredientException extends Exception{
    /**
     * Méthode pour retourner un message lors d'un exception
     * @param pi_message
     * @return void
     */
    public IngredientException(String pi_message){ super("Ingredient exception :"+pi_message);}
}

