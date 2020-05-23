import algorithms.GénérateurDeSolutions;
import customexceptions.EntrepôtNotFoundException;
import customexceptions.ListOfClientsIsEmptyException;
import customexceptions.VehiculeCapacityOutOfBoundsException;
import model.Fichier;
import model.Itinéraire;
import model.Solution;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GénérateurDeSolutionsTest
{

    @Test
    public void testGénérateurSolutionsAléatoire() throws EntrepôtNotFoundException, VehiculeCapacityOutOfBoundsException, ListOfClientsIsEmptyException {

        /* chargement des fichiers */
        List<Fichier> fichiers = Main.chargerFichiers();
        Fichier f0 = fichiers.get(0);

        int nbClientsDansLeFichierf0 = f0.getNbClientsRécupérés();
        int sommeNbClientsDansChaqueItinéraire = 0;

        /* tests de génération de solutions aléatoires sur le premier fichier */
        GénérateurDeSolutions générateurDeSolutions = new GénérateurDeSolutions(f0);
        Solution solution = générateurDeSolutions.générerUneSolutionAléatoire();

        // pour chaque itinéraire de la solution, on vérifie si le nombre de marchandises à livrer est bien inférieur ou égal à 100
        for (int i = 0; i < solution.getItinéraires().size(); i++) {
            Itinéraire itinéraire = solution.getItinéraires().get(i);
            Assert.assertTrue(itinéraire.getNbMarchandisesALivrer() <= 100);
            System.out.println("= Test passed ✅ L'itinéraire " + i + " contient " + itinéraire.getNbMarchandisesALivrer() + " marchandises à livrer =");
            sommeNbClientsDansChaqueItinéraire += itinéraire.getListeClientsÀLivrer().size();
        }

        // on vérifie si tous les clients du premier fichier ont été placés dans un itinéraire
        Assert.assertEquals(nbClientsDansLeFichierf0, sommeNbClientsDansChaqueItinéraire);
        System.out.println("= Test passed ✅ Tous les clients du premier fichier ont été placés dans un itinéraire =");

    }


    @Test
    public void testGénérerUneSolutionAléatoireLimite() throws EntrepôtNotFoundException, VehiculeCapacityOutOfBoundsException, ListOfClientsIsEmptyException
    {
        int limite = 80;
        System.out.println();
        System.out.println("= Test Génération avec limite (" + limite + ")");

        List<Fichier> fichiers = Main.chargerFichiers();
        Fichier f = fichiers.get(14);

        int nbClientsDansLeFichierf0 = f.getNbClientsRécupérés();
        int sommeNbClientsDansChaqueItinéraire = 0;

        GénérateurDeSolutions générateurDeSolutions = new GénérateurDeSolutions(f);
        Solution solution = générateurDeSolutions.générerUneSolutionAléatoire(limite);


        // pour chaque itinéraire de la solution, on vérifie si le nombre de marchandises à livrer est bien inférieur ou égal à limite
        for (int i = 0; i < solution.getItinéraires().size(); i++) {
            Itinéraire itinéraire = solution.getItinéraires().get(i);
            Assert.assertTrue(itinéraire.getNbMarchandisesALivrer() <= limite);
            System.out.println("= Test passed ✅ L'itinéraire " + i + " contient " + itinéraire.getNbMarchandisesALivrer() + " marchandises à livrer =");
            sommeNbClientsDansChaqueItinéraire += itinéraire.getListeClientsÀLivrer().size();
        }

        // on vérifie si tous les clients du premier fichier ont été placés dans un itinéraire
        Assert.assertEquals(nbClientsDansLeFichierf0, sommeNbClientsDansChaqueItinéraire);
        System.out.println("= Test passed ✅ Tous les clients du premier fichier ont tous été placés dans un itinéraire =");
        System.out.println();
    }

    @Test
    public void testGénérerUneSolutionProcheEnProche() throws VehiculeCapacityOutOfBoundsException
    {
        System.out.println();
        System.out.println("= Test Génération Proche en proche");

        List<Fichier> fichiers = Main.chargerFichiers();
        Fichier f = fichiers.get(0);



        int nbClientsDansLeFichierf0 = f.getNbClientsRécupérés();
        int sommeNbClientsDansChaqueItinéraire = 0;

        GénérateurDeSolutions générateurDeSolutions = new GénérateurDeSolutions(f);
        Solution solution = générateurDeSolutions.générerUneSolutionProcheEnProche();
        // pour chaque itinéraire de la solution, on vérifie si le nombre de marchandises à livrer est bien inférieur ou égal à limite
        for (int i = 0; i < solution.getItinéraires().size(); i++) {
            Itinéraire itinéraire = solution.getItinéraires().get(i);
            Assert.assertTrue(itinéraire.getNbMarchandisesALivrer() <= 100);
            System.out.println("= Test passed ✅ L'itinéraire " + i + " contient " + itinéraire.getNbMarchandisesALivrer() + " marchandises à livrer =");
            sommeNbClientsDansChaqueItinéraire += itinéraire.getListeClientsÀLivrer().size();
        }

        // on vérifie si tous les clients du premier fichier ont été placés dans un itinéraire
        Assert.assertEquals(nbClientsDansLeFichierf0, sommeNbClientsDansChaqueItinéraire);
        System.out.println("= Test passed ✅ Tous les clients du fichier ont tous été placés dans un itinéraire =");

        System.out.println();
    }
}
