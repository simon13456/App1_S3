package menufact.plats;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }
    public PlatEnfant CreatePlatEnfant(int code, String description, double prix, double proportion) throws PlatExeption {
        if(prix<=0)
            throw new PlatExeption("Le prix ne peut etre negatif(ou de zero)");
        if (proportion<=0)
            throw new PlatExeption("La proprotion ne peut etre negative(ou de zero)");
        return new PlatEnfant(code,description,prix,proportion);
    }
    private PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }
    @Override
    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
