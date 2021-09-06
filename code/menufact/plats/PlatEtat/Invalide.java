package menufact.plats.PlatEtat;

public class Invalide implements Etat{
    @Override
    public Etat prochainEtat() throws EtatException {
        throw new EtatException("Le plat est invalide");
    }

    @Override
    public Etat Invalidate()throws EtatException {
       throw new EtatException("Le plat est invalide");
    }
}