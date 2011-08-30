package cindy.testPersistance;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOArmement;
/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'un armement.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceArmement {


	private DAOArmement daoa;

	@Before
	public void setUp() throws Exception {
		daoa = new DAOArmement();
	}

	/**
	 * Méthode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOArmement();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur la lecture de la table Armement de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOArmement() {
		try {
			setUp();
			daoa.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur l'insertion des données de la table Armement de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testInsertionDAODAOArmement() {
		try {
			setUp();
			daoa.insererPersistance(1, "Calibre poulet");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur la modification des données de la table Armement de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOArmement() {
		try {
			setUp();
			daoa.modifierPersistance(1, "Calibre coq");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	

	/**
	 * Méthode de test sur un cas où une mauvaise insertion des données de la table Armement s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOArmement() {
		try {
			setUp();
			daoa.insererPersistance("Calibre coq", "Calibre poule");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des données geré"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * Méthode de test sur un cas où une mauvaise modification des données de la table Armement s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOArmement() {
		try {
			setUp();
			daoa.modifierPersistance(1, 12);
			fail("Données modifier non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise modification des données geré"+ e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test sur la suppression des données de la table Armement de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOArmement() {
		try {
			setUp();
			daoa.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur un cas où une mauvaise suppression des données de la table Armement s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOArmement() {
		try {
			setUp();
			daoa.supprimerPersistance("Calibre poulet");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}
}
