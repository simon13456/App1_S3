package menufact.plats.PlatEtat;

public class Commande implements Etat{
    @Override
    public Etat prochainEtat() {
        return new Preparation();
    }

    @Override
    public Etat Invalidate() {
        return new Invalide();
    }
}
