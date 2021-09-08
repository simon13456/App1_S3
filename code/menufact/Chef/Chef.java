package menufact.Chef;
import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatEtat.EtatException;
import menufact.plats.Recette;

/**
 * Section pour implémenter la classe chef qui sera un DP observer et singleton
 */
public class Chef {
    static Chef Instance;

    /**
     * Construire un objet Chef
     */
    private Chef(){};

    /**
     * Méthode qui s'assure que le chef est un singleton
     * void
     * @return instance
     */
    static public Chef getInstance(){
            if(Instance==null)
                Instance = new Chef();
            return Instance;
    }

    public PlatChoisi preparerPlat(PlatChoisi pio_platAPreparer){
        try {
            pio_platAPreparer.setEtatPlat(pio_platAPreparer.getEtat().prochainEtat());
        } catch (EtatException e) {
            System.out.println(e.getMessage());
        }
        if (IngredientInventaire.getInstance().verifierRecette(GestionDesProportion(pio_platAPreparer.getRecette(), pio_platAPreparer.getProportion())))
            return terminerPlat(pio_platAPreparer);
        try {
            pio_platAPreparer.setEtatPlat(pio_platAPreparer.getEtat().Invalidate());
        } catch (EtatException e) {
            System.out.println(e.getMessage());
        }
        return pio_platAPreparer;
    }
    private PlatChoisi terminerPlat(PlatChoisi pio_platATerminer){
        IngredientInventaire.getInstance().consommerIngredient(GestionDesProportion(pio_platATerminer.getRecette(), pio_platATerminer.getProportion()));
        try {
            pio_platATerminer.setEtatPlat(pio_platATerminer.getEtat().prochainEtat());
        } catch (EtatException e) {
            System.out.println(e.getMessage());
        }
        return ServirPlat(pio_platATerminer);
    }
    private PlatChoisi ServirPlat(PlatChoisi pio_platAServir){
        try {
            pio_platAServir.setEtatPlat(pio_platAServir.getEtat().prochainEtat());
        } catch (EtatException e) {
            System.out.println(e.getMessage());
        }
        return pio_platAServir;
    }
    private Recette GestionDesProportion (Recette recette, Double proportion){
        for (Ingredient ingredient: recette.getIngredientRequis()) {
            ingredient.setQty(ingredient.getQty() * proportion);
        }
        return recette;
    }
}