package menufact.plats.PlatEtat;

public class Terminer implements Etat{
    @Override
    public Etat prochainEtat() {
        return new Servi();
    }

    @Override
    public Etat Invalidate() {
        return new Invalide();
    }
}
