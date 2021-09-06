package menufact.plats;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;

    public PlatAuMenu CreatePlatAuMenu(int code, String description, double prix) throws PlatExeption {
        if (prix<=0)
            throw new PlatExeption("Le prix ne peut pas etre negatif(ou de zero)");
        return new PlatAuMenu(code,description,prix);
    }
    protected PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
    }
    public double getProportion(){
        return 1;
    }
    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

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
}
