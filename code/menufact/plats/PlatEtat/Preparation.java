package menufact.plats.PlatEtat;

public class Preparation implements Etat{
    @Override
    public Etat prochainEtat() {
        return new Terminer();
    }

    @Override
    public Etat Invalidate() {
        return new Invalide();
    }
}
