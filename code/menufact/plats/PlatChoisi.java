package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatEtat.Commande;
import menufact.plats.PlatEtat.Etat;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private Etat EtatPlat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.EtatPlat = new Commande();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }
    public Etat getEtat() { return this.EtatPlat;}

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }
}
