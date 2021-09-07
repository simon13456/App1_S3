package menufact.facture;

import menufact.exceptions.FactureEtatException;

public class Payer implements FactureEtat {
    @Override
    public FactureEtat prochaineFactureEtat() throws FactureEtatException {
        throw new FactureEtatException("La facture est payé");
    }
    @Override
    public FactureEtat precedenteFactureEtat() throws FactureEtatException {
        throw new FactureEtatException("La facture est payé");
    }
}