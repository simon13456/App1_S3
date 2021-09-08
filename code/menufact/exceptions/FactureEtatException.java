package menufact.exceptions;

/**
 * Cette section sera utile pour les exceptions concernant les factures.
 */
public class FactureEtatException extends Exception{
    /**
     * Méthode pour retourner un message lors d'un exception
     * @param pi_message
     * @return void
     */
    public FactureEtatException(String pi_message){ super("FactureEtatException :"+pi_message);}
}
