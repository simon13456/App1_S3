package ingredients.State;

public class Liquide extends EtatM {

    Solide getStateM(){
        return new Solide();
    }
}
