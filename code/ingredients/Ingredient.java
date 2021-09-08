package ingredients;

import ingredients.State.EtatM;

/**
 * Cette section doit servir à la classe abstraite Ingredient d'o
 */
public abstract class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private EtatM etatM;
    private double qty;

    /**
     * Méthode pour obtenir l'attribut nom dans l'objet Ingrédient
     * void
     * @return String nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * Méthode pour modifier la valeur du nom dans l'objet ingrédient
     * @param nom
     * @return void
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode pour obtenir l'attribut description dans l'objet Ingrédient
     * void
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Méthode pour modifier l'attribut description dans l'objet Ingrédient
     * @param description
     * @return void
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Méthode pour obtenir l'attribut typeIngredient dans l'objet Ingrédient
     * void
     * @return TypeIngredient
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Méthode pour modifier l'attribut typeIngredient dans l'objet Ingrédient
     * @param typeIngredient
     * @return void
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    /**
     * Méthode pour obtenir l'attribut qty dans l'objet Ingrédient
     * void
     * @return
     */
    public double  getQty() { return qty; }

    /**
     * Méthode pour modifier l'attribut qty dans l'objet Ingrédient
     * @param qty
     * @return void
     */
    public void setQty(double qty) {
        this.qty = qty;
    }
    public Ingredient setQtyAndReturn(double qty) {

    /**
     * Méthode pour modifier l'attribut qty dans l'objet Ingrédient et le retourner
     * @param qty
     * @return Ingredient
     */
        this.qty=qty;
        return this;
    }

    /**
     * Méthode pour obtenir l'attribut etatM dans l'objet Ingrédient
     * void
     * @return etatM
     */
    public EtatM getEtatM(){return etatM;}

    /**
     * Méthode pour modifier l'attribut typeIngredient dans l'objet Ingrédient
     * @param etatM
     * @return void
     */
    public Ingredient setEtatM(EtatM etatM){
        this.etatM = etatM;
        return this;
    }
}
