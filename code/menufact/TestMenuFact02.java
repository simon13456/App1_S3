package menufact;

import ingredients.*;
import menufact.Chef.Chef;
import menufact.exceptions.FactureEtatException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import org.testng.Assert;


import static ingredients.CreateurEpice.creerEpice;
import static ingredients.CreateurFruit.creerFruit;
import static ingredients.CreateurLaitier.creerLaitier;
import static ingredients.CreateurLegume.creerLegume;
import static ingredients.CreateurViande.creerViande;


public class TestMenuFact02 {

    public static void main(String[] args) {
        boolean trace = true;
        Ingredient Patate = creerLegume("Patate", "Plante alimentaire rampante", 55.0F, new Solide());
        Ingredient Tomate = creerLegume("Tomate", "Plante alimentaire rampante", 200.0F, new Solide());
        Ingredient Chien = creerLegume("Patate", "Plante alimentaire rampante", 550.0F, new Solide());
        Ingredient [] listIngredient = {Patate,Tomate,Chien};
        Recette recette = new Recette(listIngredient);

        TestMenuFact02 t = new TestMenuFact02();
        PlatAuMenu p1 = PlatAuMenu.CreatePlatAuMenu(0, "PlatAuMenu0", 10,recette);
        PlatAuMenu p2 = PlatAuMenu.CreatePlatAuMenu(1, "PlatAuMenu1", 20,recette);
        PlatAuMenu p3 = PlatAuMenu.CreatePlatAuMenu(2, "PlatAuMenu2", 30,recette);
        PlatAuMenu p4 = PlatAuMenu.CreatePlatAuMenu(3, "PlatAuMenu3", 40,recette);
        PlatAuMenu p5 = PlatAuMenu.CreatePlatAuMenu(4, "PlatAuMenu4", 50,recette);

        PlatSante ps1 = PlatSante.CreatePlatSante(10, "PlatSante0", 10, 11, 11, 11, recette);
        PlatSante ps2 = PlatSante.CreatePlatSante(11, "PlatSante1", 20, 11, 11, 11, recette);
        PlatSante ps3 = PlatSante.CreatePlatSante(12, "PlatSante2", 30, 11, 11, 11, recette);
        PlatSante ps4 = PlatSante.CreatePlatSante(13, "PlatSante3", 40, 11, 11, 11, recette);
        PlatSante ps5 = PlatSante.CreatePlatSante(14, "PlatSante4", 50, 11, 11, 11, recette);


        Menu m1 = new Menu("menufact.Menu 1");
        Menu m2 = new Menu("menufact.Menu 2");

        Facture f1 = new Facture("Ma facture");

        Client c1 = new Client(1, "Mr Client", "1234567890");
        t.test1_AffichePlatsAuMenu(trace, p1, p2, p3, p4, p5);
        t.test2_AffichePlatsSante(trace, ps1, ps2, ps3, ps4, ps5);
        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, m2, p3, p4, ps3, ps4);

        try {
            t.test5_DeplacementMenuAvancer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }
        try {
            t.test6_DeplacementMenuReculer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }
        try {
            t.test7_CreerFacture(f1, m1);
        } catch (FactureException e) {
            System.out.println(e.getMessage());
        }
        t.test8_AjouterClientFacture(f1, c1);
        try {
            t.test8_AjouterPlatsFacture(f1, m1, 1);
        } catch (FactureException fe) {
            System.out.println(fe.getMessage());
        } catch (MenuException me) {
            System.out.println(me);
        }
        try {
            t.test9_PayerFacture(f1);
        } catch (FactureEtatException e) {
            e.printStackTrace();
        }

        try {
            t.test8_AjouterPlatsFacture(f1, m1, 1);
        } catch (FactureException fe) {
            System.out.println(fe.getMessage());
        } catch (MenuException me) {
            System.out.println(me);
        }
        try {
            f1.ouvrir();
        } catch (FactureException | FactureEtatException fe) {
            System.out.println(fe.getMessage());
        }


        System.out.println("FIN DE TOUS LES TESTS...");

        System.out.println(f1.genererFacture());
        testCreerFruit();
        testCreerLegume();
        testCreerViande();
        testCreerLaitier();
        testCreerEpice();
        testPlatAuMenu();
        testPlatSante();
        testPlatEnfant();
    }
    private static void testPlatAuMenu(){
        Ingredient Patate = creerLegume("Patate", "Plante alimentaire rampante", 55.0F, new Solide());
        Ingredient Tomate = creerLegume("Tomate", "Plante alimentaire rampante", 200.0F, new Solide());
        Ingredient Chien = creerLegume("Patate", "Plante alimentaire rampante", 550.0F, new Solide());
        Ingredient [] listIngredient = {Patate,Tomate,Chien};
        Recette recette = new Recette(listIngredient);
        PlatAuMenu plat1 = PlatAuMenu.CreatePlatAuMenu(0, "PlatAuMenu0", 10,recette);
        PlatAuMenu plat2 = PlatAuMenu.CreatePlatAuMenu(1, "PlatAuMenu1", -5,recette);
        Assert.assertNull(plat2);
        Assert.assertEquals(1,plat1.getProportion());
        Assert.assertEquals(plat1.getCode(),1);
        plat1.setCode(2);
        Assert.assertEquals(plat1.getCode(),2);
        Assert.assertEquals(plat1.getDescription(),"PlatAuMenu1");
        plat1.setDescription("None pizza with left of beef");
        Assert.assertEquals(plat1.getDescription(),"None pizza with left of beef");
        try{
            plat1.setPrix(0);
        } catch (PlatExeption platExeption) {
        }
        Assert.assertEquals(plat1.getPrix(),10);
        try {
            plat1.setPrix(321654);
        } catch (PlatExeption e) {
        }
        Assert.assertEquals(plat1.getPrix(),321654);
        Assert.assertEquals(plat1.getRecette(),recette);
        System.out.println("==================");
        System.out.println("Creation d'un plat");
        System.out.println(plat1.toString());
        System.out.println("==================");
        System.out.println("Echec de la creation d'un plat");
        System.out.println("==================");
        System.out.println("La proportion est égale à 1");
        System.out.println(plat1.getPrix());
        System.out.println("==================");
        System.out.println("Obtenir le code du plat");
        System.out.println(plat1.getCode());
        System.out.println("==================");
        System.out.println("Setter le code a 2");
        plat1.setCode(2);
        System.out.println("Obtenir le code du plat");
        System.out.println(plat1.getCode());
        System.out.println("==================");
        System.out.println("Obtenir la descritpion");
        System.out.println(plat1.getDescription());
        System.out.println("==================");
        System.out.println("Setter la descritpion a None pizza with left of beef");
        plat1.setDescription("None pizza with left of beef");
        System.out.println("Obtenir la descritpion");
        System.out.println(plat1.getDescription());
        System.out.println("==================");
        System.out.println("Obtenir le prix");
        System.out.println(plat1.getPrix());
        System.out.println("==================");
        System.out.println("Setter le prix a 250");
        try {
            plat1.setPrix(250);
        } catch (PlatExeption e) {
            System.out.println("---------ERREUR---------");
            System.out.println(e.getMessage());
        }
        System.out.println("Obtenir le prix");
        System.out.println(plat1.getPrix());
        System.out.println("==================");
        System.out.println("Setter le prix a -5");
        try {
            plat1.setPrix(250);
        } catch (PlatExeption e) {
            System.out.println("---------ERREUR---------");
            System.out.println(e.getMessage());
        }
        System.out.println("Obtenir le prix");
        System.out.println(plat1.getPrix());
        System.out.println("==================");
        System.out.println("Obtenir la recette");
        plat1.getRecette();
    }
    private static void testPlatSante(){
        Ingredient Patate = creerLegume("Patate", "Plante alimentaire rampante", 55.0F, new Solide());
        Ingredient Tomate = creerLegume("Tomate", "Plante alimentaire rampante", 200.0F, new Solide());
        Ingredient Chien = creerLegume("Patate", "Plante alimentaire rampante", 550.0F, new Solide());
        Ingredient [] listIngredient = {Patate,Tomate,Chien};
        Recette recette = new Recette(listIngredient);
        PlatSante ps1 = PlatSante.CreatePlatSante(10, "PlatSante0", 10, 11, 11, 11, recette);
        Assert.assertEquals(ps1.getChol(),11);
        Assert.assertEquals(ps1.getGras(),11);
        Assert.assertEquals(ps1.getKcal(),11);

        System.out.println("==================");
        System.out.println("Creer un plat sante");
        System.out.println(ps1.toString());
        System.out.println("==================");
        System.out.println("Echouer a l'instanciation d'un plat sante");
        PlatSante ps2 = PlatSante.CreatePlatSante(10, "PlatSante0", 10, -11, -11, -11, recette);
        System.out.println("==================");
        System.out.println("Obtenir les Kcal");
        System.out.println(ps1.getKcal());
        System.out.println("==================");
        System.out.println("Obtenir le Chol");
        System.out.println(ps1.getChol());
        System.out.println("==================");
        System.out.println("Obtenir le Gras");
        System.out.println(ps1.getGras());
        System.out.println("==================");
    }
    private static void testPlatEnfant(){
        Ingredient Patate = creerLegume("Patate", "Plante alimentaire rampante", 55.0F, new Solide());
        Ingredient Tomate = creerLegume("Tomate", "Plante alimentaire rampante", 200.0F, new Solide());
        Ingredient Chien = creerLegume("Patate", "Plante alimentaire rampante", 550.0F, new Solide());
        Ingredient [] listIngredient = {Patate,Tomate,Chien};
        Recette recette = new Recette(listIngredient);
        System.out.println("==================");
        System.out.println("Creation d'un plat pour enfant");
        PlatEnfant pe1 = PlatEnfant.CreatePlatEnfant(10, "PlatSante0", 10,0.5,recette);
        Assert.assertEquals(pe1.getProportion(),0.5);
        System.out.println("==================");
        System.out.println("Echec de l'instanciation d'un plat pour enfant");
        PlatEnfant pe2 = PlatEnfant.CreatePlatEnfant(10, "PlatSante0", 10,500,recette);
        System.out.println("==================");
        System.out.println("Obtenir la proportion");
        System.out.println(pe1.getProportion());
        Assert.assertEquals(pe1.getProportion(),0.5);
        System.out.println("==================");
    }

    public static void testChef(){
        Chef chef  = Chef.getInstance();

    }

    private static void testCreerFruit() {
        CreateurDingredient factory = new CreateurFruit();
        Ingredient Pomme = factory.creerFruit("Pomme", "fruit rouge cultivé dans les verger", 28.0F, new Solide());
        Assert.assertEquals("Pomme", Pomme.getNom());
        //Assert.assertTrue(Pomme.getNom() == "Pomme");
        System.out.println("Test : créer fruit  ");
        System.out.println("Résulat attendue : True");
        System.out.println("Résulat obtenue : ");
        System.out.print("Pomme" == Pomme.getNom());
    }


    private static void testCreerLegume() {
        CreateurDingredient factory = new CreateurLegume();
        Ingredient Patate = creerLegume("Patate", "Plante alimentaire rampante", 55.0F, new Solide());
        Assert.assertEquals("Patate", Patate.getNom());
        //Assert.assertTrue(Patate.getNom() == "Patate");
        System.out.println("Test : créer légume  ");
        System.out.println("Résulat attendue : True");
        System.out.println("Résulat obtenue : ");
        System.out.print("Patate" == Patate.getNom());
    }

    private static void testCreerViande() {
        CreateurDingredient factory = new CreateurViande();
        Ingredient Steak = creerViande("Steak", "Produit issu de la boucherie du boeuf", 15.0F, new Solide());
        Assert.assertEquals("Steak", Steak.getNom());
        //Assert.assertTrue(Steak.getNom() == "Steak");
        System.out.println("Test : créer viande  ");
        System.out.println("Résulat attendue : True");
        System.out.println("Résulat obtenue : ");
        System.out.print("Steak" == Steak.getNom());
    }

    private static void testCreerLaitier() {
        CreateurDingredient factory = new CreateurLaitier();
        Ingredient Creme = creerLaitier("Creme", "Produit de l'écrémage du lait constitué de lait très enrichi en matière grasse", 15.0F, new Liquide());
        Assert.assertEquals("Creme", Creme.getNom());
        //Assert.assertTrue(Steak.getNom() == "Steak");
        System.out.println("Test : créer laitier  ");
        System.out.println("Résulat attendue : True");
        System.out.println("Résulat obtenue : ");
        System.out.print("Creme" == Creme.getNom());
    }

    private static void testCreerEpice() {
        CreateurDingredient factory = new CreateurEpice();
        Ingredient Persil = creerEpice("Persil", "Petite ombellifère annuelle ou bisannuelle, à tige finement côtelée, à feuilles très découpées, que l'on utilise comme condiment et comme garniture.", 5.0F, new Solide());
        Assert.assertEquals("Persil", Persil.getNom());
        //Assert.assertTrue(Persil.getNom() == "Persil");
        System.out.println("Test : créer persil  ");
        System.out.println("Résulat attendue : True");
        System.out.println("Résulat obtenue : ");
        System.out.print("Persil" == Persil.getNom());
    }

    private void test1_AffichePlatsAuMenu(boolean trace, PlatAuMenu p1, PlatAuMenu p2,
                                          PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu p5) {
        System.out.println("=== test1_AffichePlatsAuMenu");
        if (trace) {
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
        }
    }


    private void test2_AffichePlatsSante(boolean trace, PlatSante ps1, PlatSante ps2,
                                         PlatSante ps3, PlatSante ps4, PlatSante ps5) {
        System.out.println("=== test2_AffichePlatsSante");

        if (trace) {
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }
    }


    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2) {

        System.out.println("=== test3_AjoutMenu");

        if (trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1,
                                        PlatAuMenu p1, PlatAuMenu p2,
                                        PlatSante ps1, PlatSante ps2,
                                        Menu m2,
                                        PlatAuMenu p3, PlatAuMenu p4,
                                        PlatSante ps3, PlatSante ps4) {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);


        System.out.println("=== Ajout de plats au menu 2");
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);

        if (trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException {
        System.out.println("=== test5_DeplacementMenuAvancer");

        System.out.println("===Selectionner un plat du menu 0");
        m1.position(0);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Avancer le plat courant");
            System.out.println("1.");
            m1.positionSuivante();
            System.out.println("2.");
            m1.positionSuivante();
            System.out.println("3.");
            m1.positionSuivante();
            System.out.println("4.");
            m1.positionSuivante();
            System.out.println("5.");
            m1.positionSuivante();
        } catch (MenuException me) {
            throw me;
        }
    }


    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException {
        System.out.println("===test6_DeplacementMenuReculer");

        System.out.println("===Selectionner un plat du menu 3");
        m1.position(3);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Reculer le plat courant");
            System.out.println("2.");
            m1.positionPrecedente();
            System.out.println("1.");
            m1.positionPrecedente();
            System.out.println("0.");
            m1.positionPrecedente();
            System.out.println("-1.");
            m1.positionPrecedente();
            System.out.println("-2.");
            m1.positionPrecedente();
        } catch (MenuException me) {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, Menu m1) throws FactureException {
        System.out.println("===test7_CreerFacture");

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(), 5);
        try {
            f1.ajoutePlat(platChoisi);
        } catch (FactureException fe) {
            throw fe;
        }
        System.out.println(f1);
    }


    private void test8_AjouterClientFacture(Facture f1, Client c1) {
        System.out.println("===test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println(f1);
    }

    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws MenuException, FactureException {
        System.out.println("===test8_AjouterPlatsFacture");

        try {
            for (int i = 0; i < pos; i++)
                m1.positionSuivante();
        } catch (MenuException me) {
            throw me;
        }

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(), 5);
        try {
            f1.ajoutePlat(platChoisi);
        } catch (FactureException fe) {
            throw fe;
        }
        System.out.println(f1);
    }

    private void test9_PayerFacture(Facture f1) throws FactureEtatException {
        System.out.println("===test9_PayerFacture");

        System.out.println("Avant payer la facture");
        System.out.println(f1);
        f1.payer();
        System.out.println("Apres avoir paye la facture");
        System.out.println(f1);
    }
}
//#DOM Lorsqu'on fait des tests unitaires quels est la meilleure stratégie. Tout automatisé dans une grande classe ou tout séparé?