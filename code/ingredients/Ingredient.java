package ingredients;

public abstract class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private double qty;

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
    public Ingredient setQtyAndReturn(double qty) {
        this.qty=qty;
        return this;
    }
}
