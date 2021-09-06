package menufact.Chef;
import inventaire.Inventaire;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatEtat.EtatException;

public class Chef {
    private Chef Instance;
    private Chef(){};

    public Chef getInstance(){
            if(Instance==null)
                Instance = new Chef();
            return Instance;
    }
    public PlatChoisi preparerPlat(PlatChoisi pio_platAPreparer){
        pio_platAPreparer.getEtat().prochainEtat();
        if (Inventaire.getInstance.verifierRecette(pio_platAPreparer.getPlat().getRecette()))
            return terminerPlat(pio_platAPreparer);
        return pio_platAPreparer.Invalidate();
    }
    private PlatChoisi terminerPlat(PlatChoisi pio_platATerminer){
        Inventaire.getInstance.consommerIngredient(pio_platATerminer.getPlat().getRecette());
        pio_platATerminer.prochainEtat();
        return ServirPlat(pio_platATerminer);
    }
    private PlatChoisi ServirPlat(PlatChoisi pio_platAServir){
        try {
            pio_platAServir.getEtat().prochainEtat();
        } catch (EtatException e) {
        }
        return pio_platAServir;
    }
}