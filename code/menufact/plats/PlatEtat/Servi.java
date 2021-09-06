package menufact.plats.PlatEtat;

import menufact.exceptions.MenuException;

public class Servi implements Etat{
    @Override
    public Etat prochainEtat() throws EtatException {
        throw new EtatException("Le plat est deja Servi");
    }

    @Override
    public Etat Invalidate() {
        return new Invalide();
    }
}
