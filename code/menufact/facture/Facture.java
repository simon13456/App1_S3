package menufact.facture;

import menufact.Chef.Chef;
import menufact.Client;
import menufact.exceptions.FactureEtatException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEtat.Invalide;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private Chef chef;
    private int courant;
    private Client client;


    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     * Méthode qui associe le chef a la facture
     */
    public void devenirChef(){
        this.chef=Chef.getInstance();
    }

    /**
     * Méthode qui avertie le Chef qu'unplat a été choisi
     * @param platChoisi
     */
    public void notify (PlatChoisi platChoisi) {
        chef.notify(platChoisi);
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             if(!(p.getEtat() instanceof Invalide))
                soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de changer l'état de la facture à PAYEE
     */
    public void payer() throws FactureEtatException {
       etat = etat.prochaineFactureEtat();
    }
    /**
     * Permet de changer l'état de la facture à FERMEE
     */
    public void fermer() throws FactureEtatException {

       etat = etat.prochaineFactureEtat();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException, FactureEtatException {
        if (etat == etat.prochaineFactureEtat())
            throw new FactureException("La facture ne peut pas être reouverte.");
        else
            etat = etat.precedenteFactureEtat();
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = new Ouvert();
        courant = -1;
        this.description = description;
        devenirChef();
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlatAuMenu(PlatAuMenu p,int qty) throws FactureException
    {
        if (etat instanceof Ouvert) {
            PlatChoisi PlatChoisi = new PlatChoisi(p,qty);
            platchoisi.add(PlatChoisi);
            this.notify(PlatChoisi);
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");

    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + String.format("%.2g%n", TPS) +
                ", TVQ=" + String.format("%.2g%n", TVQ) +
                '}';
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                          "Date:" + date + "\n" +
                          "Description: " + description + "\n" +
                          "Client:" + client.getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            if(!(plat.getEtat() instanceof Invalide))
                factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
                i++;
        }

        factureGenere += "          TPS:               " + String.format("%.2g%n", tps()) + "\n";
        factureGenere += "          TVQ:               " + String.format("%.2g%n", tvq()) + "\n";
        factureGenere += "          Le total est de:   " + String.format("%.3g%n", total()) + "\n";

        return factureGenere;
    }
}
