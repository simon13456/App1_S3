package menufact.plats.PlatEtat;

public class Terminer implements Etat{
    @Override
    public Etat prochainEtat() {
        return this;
    }

    @Override
    public Etat Invalidate() {
        return new Invalide();
    }
}
