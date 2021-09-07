package menufact.plats;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }
    static public PlatEnfant CreatePlatEnfant(int code, String description, double prix, double proportion) {
        if(prix<=0)
            try {
                throw new PlatExeption("Le prix ne peut etre negatif(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());
            }
        if (proportion<=0)
            try {
                throw new PlatExeption("La proprotion ne peut etre negative(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());
            }
        return new PlatEnfant(code,description,prix,proportion);
    }
    private PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
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
