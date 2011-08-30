package cindy.testPersistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOMission;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'une mission.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceMission {

	private DAOMission daom;

	@Before
	public void setUp() throws Exception {
		daom = new DAOMission();
	}

	/**
	 * Méthode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOMission();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}


	/**
	 * Méthode de test sur la lecture de la table Mission de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOMission() {
		try {
			setUp();
			daom.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur l'insertion des données de la table Mission de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testInsertionDAOMission() {
		try {
			setUp();
			daom.insererPersistance(1, "Capturer les poulets");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur la modification des données de la table Mission de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOMission() {
		try {
			setUp();
			daom.modifierPersistance(1, "Capturer des coqs");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	
	
	/**
	 * Méthode de test sur un cas où une mauvaise insertion des données de la table Mission s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOMission() {
		try {
			setUp();
			daom.insererPersistance("Capturer des coqs", "Capturer les poulets");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des données geré"+ e.getMessage(), true);
		}
	}
	
	/**
	 * Méthode de test sur un cas où une mauvaise modification des données de la table Mission s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOMission() {
		try {
			setUp();
			daom.insererPersistance(1, 12);
			fail("Données modifié non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise modification des données geré"+ e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test sur la suppression des données de la table Mission de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOMission() {
		try {
			setUp();
			daom.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur un cas où une mauvaise suppression des données de la table Mission s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOMission() {
		try {
			setUp();
			daom.supprimerPersistance("Capturer les poulets");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}


}

