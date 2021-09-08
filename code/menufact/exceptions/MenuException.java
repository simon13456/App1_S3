package menufact.exceptions;

/**
 * Cette section sera utile pour les exceptions concernant le menu.
 */
public class MenuException extends Exception{
    /**
     * Méthode pour retourner un message lors d'un exception
     * @param message
     * @return void
     */
    public MenuException(String message){
        super("MenuException: " + message);
    }
}

