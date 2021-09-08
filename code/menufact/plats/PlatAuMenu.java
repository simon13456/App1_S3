package menufact.plats;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private Recette recette;

    public PlatAuMenu() {
    }
    protected PlatAuMenu(int code, String description, double prix, Recette recette) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.recette = recette;
    }
    static public PlatAuMenu CreatePlatAuMenu(int code, String description, double prix, Recette recette) {
        if (prix<=0)
            try {
                throw new PlatExeption("Le prix ne peut pas etre negatif(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());;
                return null;
            }
        return new PlatAuMenu(code,description,prix,recette);
    }

    public double getProportion(){
        return 1;
    }



    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() { return code; }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws PlatExeption {
        if(prix<=0)
            throw new PlatExeption("Le prix ne peut pas etre negatif(ou de zero)");
        this.prix = prix;
    }

    public Recette getRecette() {
        return recette;
    }
}
