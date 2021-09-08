package menufact.plats;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }
    static public PlatEnfant CreatePlatEnfant(int code, String description, double prix, double proportion, Recette recette) {
        if (proportion<=0 || proportion >=0  )
            try {
                throw new PlatExeption("La proprotion ne peut etre negative(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());
            }
        return new PlatEnfant(code,description,prix,proportion,recette);
    }
    private PlatEnfant(int code, String description, double prix, double proportion, Recette recette) {
        super(code, description, prix,recette);
        this.proportion = proportion;
    }
    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
    @Override
    public double getProportion() { return proportion; }
}
