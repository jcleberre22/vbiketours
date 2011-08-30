package cindy.testPersistance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOEquipage;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'un equipage.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceEquipage {

	private DAOEquipage daoe;

	@Before
	public void setUp() throws Exception {
		daoe = new DAOEquipage();
	}

	/**
	 * Méthode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOEquipage();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Problème constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur la lecture de la table Equipage de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOEquipage() {
		try {
			setUp();
			daoe.lire();
			assertTrue("Lecture des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur l'insertion des données de la table Equipage de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testInsertionDAOEquipage() {
		try {
			setUp();
			daoe.insererPersistance(1, "Equipage de poulet");
			assertTrue("Insertion des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}

	/**
	 * Méthode de test sur la modification des données de la table Equipage de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOEquipage() {
		try {
			setUp();
			daoe.modifierPersistance(1, "Equipage de coq");
			assertTrue("Modification des données reussies", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}	

	/**
	 * Méthode de test sur un cas où une mauvaise insertion des données de la table Equipage s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOEquipage() {
		try {
			setUp();
			daoe.insererPersistance("coq", "Equipage de poulet");
			fail("Données inserer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des données geré"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * Méthode de test sur un cas où une mauvaise modification des données de la table Equipage s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOEquipage() {
		try {
			setUp();
			daoe.modifierPersistance(1,23);
			fail("Données modifer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise modification des données geré"+ e.getMessage(), true);
		}
	}	

	/**
	 * Méthode de test sur la suppression des données de la table Equipage de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOEquipage() {
		try {
			setUp();
			daoe.supprimerPersistance(1);
			assertTrue("Suppression des données reussie", true);
		} catch (Exception e) {
			fail("Problème de requetes " + e.getMessage());
		}
	}


	/**
	 * Méthode de test sur un cas où une mauvaise suppression des données de la table Equipage s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOEquipage() {
		try {
			setUp();
			daoe.supprimerPersistance("poulet");
			fail("Données supprimer non correct non geré ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des données geré"+ e.getMessage(), true);
		}
	}


}


