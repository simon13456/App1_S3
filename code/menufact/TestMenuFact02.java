package menufact;

import ingredients.*;
import ingredients.Factory.*;
import ingredients.State.Liquide;
import ingredients.State.Solide;
import menufact.exceptions.FactureEtatException;
import menufact.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


public class TestMenuFact02 {

    public static void main(String[] args) {
        boolean trace = true;

        TestMenuFact02 t = new TestMenuFact02();
        PlatAuMenu p1 = PlatAuMenu.CreatePlatAuMenu(0, "PlatAuMenu0", 10);
        PlatAuMenu p2 = PlatAuMenu.CreatePlatAuMenu(1, "PlatAuMenu1", 20);
        PlatAuMenu p3 = PlatAuMenu.CreatePlatAuMenu(2, "PlatAuMenu2", 30);
        PlatAuMenu p4 = PlatAuMenu.CreatePlatAuMenu(3, "PlatAuMenu3", 40);
        PlatAuMenu p5 = PlatAuMenu.CreatePlatAuMenu(4, "PlatAuMenu4", 50);

        PlatSante ps1 = PlatSante.CreatePlatSante(10, "PlatSante0", 10, 11, 11, 11);
        PlatSante ps2 = PlatSante.CreatePlatSante(11, "PlatSante1", 20, 11, 11, 11);
        PlatSante ps3 = PlatSante.CreatePlatSante(12, "PlatSante2", 30, 11, 11, 11);
        PlatSante ps4 = PlatSante.CreatePlatSante(13, "PlatSante3", 40, 11, 11, 11);
        PlatSante ps5 = PlatSante.CreatePlatSante(14, "PlatSante4", 50, 11, 11, 11);


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
        testCreerFruitEchec();
        testCreerLegume();
        testCreerLegumeEchec();
        testCreerViande();
        testCreerViandeEchec();
        testCreerLaitier();
        testCreerLaitierEchec();
        testCreerEpice();
        testCreerEpiceEchec();
    }


    private static void testCreerFruit() {
        System.out.println("Test : créer fruit  ");
        System.out.println("Résulat attendue : true");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurFruit();

        try {
            Ingredient Pomme = factory.creer("Pomme", "fruit rouge cultivé dans les verger", 28.0F, new Solide());
            Assert.assertEquals("Pomme", Pomme.getNom());
            System.out.println("Pomme" == Pomme.getNom());
        } catch (IngredientException e) {
            System.out.println("Nobody come here, but i hate blank space");
        }
        System.out.println();
    }

    private static void testCreerFruitEchec() {
        System.out.println("Test : Fruit négatif  ");
        System.out.println("Résulat attendue : Exception");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurFruit();
        try {
            Ingredient Kiwi = factory.creer("Kiwi", "Les kiwis sont des fruits de plusieurs espèces de lianes du genre Actinidia", -1, new Solide());
            fail();
        } catch (IngredientException e) {
            System.out.println("Exception");
        }
        System.out.println();
    }


    private static void testCreerLegume() {
        System.out.println("Test : créer légume  ");
        System.out.println("Résulat attendue : True");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurLegume();

        try {
            Ingredient Patate = factory.creer("Patate", "Plante alimentaire rampante", 55.0F, new Solide());
            Assert.assertEquals("Patate", Patate.getNom());
            System.out.println("Patate" == Patate.getNom());
        } catch (IngredientException e) {
            System.out.println("Nobody come here, but i hate blank space");
        }
        System.out.println();
    }

    private static void testCreerLegumeEchec() {
        System.out.println("Test : Légume négatif  ");
        System.out.println("Résulat attendue : Exception");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurLegume();
        try {
            Ingredient Tomate = factory.creer("Tomate", "Plante potagère annuelle cultivée pour ses fruits.", -1, new Solide());
            fail();
        } catch (IngredientException e) {
            System.out.println("Exception");
        }
        System.out.println();
    }

    private static void testCreerViande() {
        System.out.println("Test : créer viande  ");
        System.out.println("Résulat attendue : True");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurViande();
        try {
            Ingredient Steak = factory.creer("Steak", "Produit issu de la boucherie du boeuf", 15.0F, new Solide());
            Assert.assertEquals("Steak", Steak.getNom());
            System.out.println("Steak" == Steak.getNom());
        } catch (IngredientException e) {
            System.out.println("Nobody come here, but i hate blank space");
        }
        System.out.println();
    }

    private static void testCreerViandeEchec() {
        System.out.println("Test : Viande négatif  ");
        System.out.println("Résulat attendue : Exception");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurViande();
        try {
            Ingredient Rosbeef = factory.creer("Rosbeef", "Morceau de bœuf à rôtir, généralement coupé dans l'aloyau.", -1, new Solide());
            fail();
        } catch (IngredientException e) {
            System.out.println("Exception");
        }
        System.out.println();
    }

    private static void testCreerLaitier() {
        System.out.println("Test : créer laitier  ");
        System.out.println("Résulat attendue : True");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurLaitier();
        try {
            Ingredient Creme = factory.creer("Creme", "Produit de l'écrémage du lait constitué de lait très enrichi en matière grasse", 15.0F, new Liquide());
            Assert.assertEquals("Creme", Creme.getNom());
            System.out.println("Creme" == Creme.getNom());
        } catch (IngredientException e) {
            System.out.println("Nobody come here, but i hate blank space");
        }
        System.out.println();
    }

    private static void testCreerLaitierEchec() {
        System.out.println("Test : Laitier Négatif  ");
        System.out.println("Résulat attendue : Exception");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurLaitier();
        try {
            Ingredient Lait = factory.creer("Lait", "Lait de mammifères domestiques destiné à l'alimentation humaine.", -1, new Liquide());
            fail();
        } catch (IngredientException e) {
            System.out.println("Exception");
        }
        System.out.println();
    }

    private static void testCreerEpice() {
        System.out.println("Test : créer épice  ");
        System.out.println("Résulat attendue : True");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurEpice();
        try {
            Ingredient Persil = factory.creer("Persil", "Petite ombellifère annuelle ou bisannuelle, à tige finement côtelée, à feuilles très découpées, que l'on utilise comme condiment et comme garniture.", 5.0F, new Solide());
            Assert.assertEquals("Persil", Persil.getNom());
            System.out.println("Persil" == Persil.getNom());
            fail();
        } catch (IngredientException e) {
            System.out.println("Nobody come here, but i hate blank space");
        }
        System.out.println();
    }

    private static void testCreerEpiceEchec() {
        System.out.println("Test : Épice négative  ");
        System.out.println("Résulat attendue : Exception");
        System.out.print("Résulat obtenue : ");
        CreateurDingredient factory = new CreateurEpice();
        try {
            Ingredient Sriracha = factory.creer("Sriracha", "Petite ombellifère annuelle ou bisannuelle, à tige finement côtelée, à feuilles très découpées, que l'on utilise comme condiment et comme garniture.", -1, new Liquide());
            fail();
        } catch (IngredientException e) {
            System.out.println("Exception");
        }
        System.out.println();
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