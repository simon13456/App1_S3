package ingredients;

import ingredients.State.EtatM;

public abstract class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private EtatM etatM;
    private float qty;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public double  getQty() { return qty; }

    public void setQty(double qty) {
        this.qty = qty;
    }
    public Ingredient setQtyAndReturn(float qty) {
        this.qty=qty;
        return this;
    }
    public EtatM getEtatM(){return etatM;}
    public Ingredient setEtatM(EtatM etatM){
        this.etatM = etatM;
        return this;
    }
}
