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
    public Chef(){};

    /**
     * Méthode qui avertie le Chef qu'un plat à été choisie
     * @param platChoisi
     */
    public void notify(PlatChoisi platChoisi){
        preparerPlat(platChoisi);
    }
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
    /**
     * Méthode qui prépare et vérifie si l'inventaire à tout les ingrédients
     * @param pio_platAPreparer
     * @return PlatChoisi
     */
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
    /**
     * Méthode qui termine le plat et retire les ingreddient de l'inventaire
     * @param pio_platATerminer
     * @return
     */
    private PlatChoisi terminerPlat(PlatChoisi pio_platATerminer){
        IngredientInventaire.getInstance().consommerIngredient(GestionDesProportion(pio_platATerminer.getRecette(), pio_platATerminer.getProportion()));
        try {
            pio_platATerminer.setEtatPlat(pio_platATerminer.getEtat().prochainEtat());
        } catch (EtatException e) {
            System.out.println(e.getMessage());
        }
        return ServirPlat(pio_platATerminer);
    }
    /**
     * Méthode qui sert le plat
     * @param pio_platAServir
     * @return
     */
    private PlatChoisi ServirPlat(PlatChoisi pio_platAServir){
        try {
            pio_platAServir.setEtatPlat(pio_platAServir.getEtat().prochainEtat());
        } catch (EtatException e) {
            System.out.println(e.getMessage());
        }
        return pio_platAServir;
    }
    /**
     * Méthode pour gérer la portion d'ingredient à enlever de l'inventaire
     * @param recette
     * @param proportion
     * @return
     */
    private Recette GestionDesProportion (Recette recette, Double proportion){
        for (Ingredient ingredient: recette.getIngredientRequis()) {
            ingredient.setQty(ingredient.getQty() * proportion);
        }
        return recette;
    }
}