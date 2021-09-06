package menufact.plats.PlatEtat;

public interface Etat {
    public Etat prochainEtat() throws EtatException;
    public Etat Invalidate() throws EtatException;
}
