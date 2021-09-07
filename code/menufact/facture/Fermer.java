package menufact.facture;

import menufact.exceptions.FactureEtatException;

public class Fermer implements FactureEtat {
    @Override
    public FactureEtat prochaineFactureEtat() throws FactureEtatException {
        return new Payer();
    }

    @Override
    public FactureEtat precedenteFactureEtat() throws FactureEtatException {
        return new Ouvert();
    }

}