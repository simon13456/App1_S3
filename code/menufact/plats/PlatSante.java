package menufact.plats;

import menufact.plats.PlatAuMenu;

public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    private PlatSante(int code, String description, double prix, double kcal, double chol, double gras, Recette recette) {
        super(code, description, prix, recette);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    private PlatSante() {
    }

    static public PlatSante CreatePlatSante(int code, String description, double prix, double kcal, double chol, double gras, Recette recette)  {
        if (prix<=0)
            try {
                throw new PlatExeption("Le prix ne peux pas etre negatif(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());
                return null;
            }
        if (kcal<=0)
            try {
                throw  new PlatExeption("Les Kcal ne peuvent pas etre negatif(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());
                return null;
            }
        if (chol<=0)
            try {
                throw new PlatExeption("Le Chol ne peut pas etre negatif(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());
                return null;
            }
        if (gras<=0)
            try {
                throw  new PlatExeption("Le gras ne peut pas etre negatif(ou de zero)");
            } catch (PlatExeption e) {
                System.out.println(e.getMessage());
                return null;
            }

        return new PlatSante(code,description,prix,kcal,chol,gras,recette);
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    public double getKcal() {
        return kcal;
    }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }
}
