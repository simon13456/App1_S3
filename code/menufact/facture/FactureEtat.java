package menufact.facture;

import menufact.exceptions.FactureEtatException;
import menufact.plats.PlatEtat.EtatException;

public interface FactureEtat {
    public FactureEtat prochaineFactureEtat() throws FactureEtatException;
    public FactureEtat precedenteFactureEtat() throws FactureEtatException;
}
