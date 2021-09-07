package menufact.Chef;
import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatEtat.EtatException;

public class Chef {
    static Chef Instance;
    private Chef(){};

    static public Chef getInstance(){
            if(Instance==null)
                Instance = new Chef();
            return Instance;
    }
    public PlatChoisi preparerPlat(PlatChoisi pio_platAPreparer){
        try {
            pio_platAPreparer.getEtat().prochainEtat();
        } catch (EtatException e) {
            e.printStackTrace();
        }
        if (IngredientInventaire.getInstance().verifierRecette(pio_platAPreparer.getPlat().getRecette()))
            return terminerPlat(pio_platAPreparer);
        try {
            pio_platAPreparer.getEtat().Invalidate();
        } catch (EtatException e) {
            e.printStackTrace();
        }
        return pio_platAPreparer;
    }
    private PlatChoisi terminerPlat(PlatChoisi pio_platATerminer){
        IngredientInventaire.getInstance().consommerIngredient(pio_platATerminer.getPlat().getRecette());
        try {
            pio_platATerminer.getEtat().prochainEtat();
        } catch (EtatException e) {
            e.printStackTrace();
        }
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