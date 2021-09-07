package menufact.facture;


import menufact.exceptions.FactureEtatException;


public class Ouvert implements FactureEtat {

    @Override
    public FactureEtat prochaineFactureEtat() throws FactureEtatException {
        return new Fermer();
    }

    @Override
    public FactureEtat precedenteFactureEtat() throws FactureEtatException {
        throw new FactureEtatException("Cette opération est impossible");
    }

}
