package cindy.testPersistance;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOCategorie;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'une categorie de vol.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersitanceCategorie {

	private DAOCategorie daoc;
	
	@Before
	public void setUp() throws Exception {
		daoc = new DAOCategorie();
	}

	/**
	 * M�thode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOCategorie();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la lecture de la table Categorie de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOCategorie() {
		try {
			setUp();
			daoc.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur l'insertion des donn�es de la table Categorie de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testInsertionDAOCategorie() {
		try {
			setUp();
			daoc.insererPersistance(1, "poulet");
			assertTrue("Insertion des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur la modification des donn�es de la table Categorie de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOCategorie() {
		try {
			setUp();
			daoc.modifierPersistance(1, "coq");
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	
	
	/**
	 * M�thode de test sur un cas o� une mauvaise insertion des donn�es de la table Categorie s'effectue.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOCategorie() {
		try {
			setUp();
			daoc.insererPersistance("poulet", "poulet");
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise insertion des donn�es ger�"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * M�thode de test sur un cas o� une mauvaise modification des donn�es de la table Categorie s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOCategorie() {
		try {
			setUp();
			daoc.modifierPersistance(1, 23);
			fail("Donn�es modifi� non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * M�thode de test sur la suppression des donn�es de la table Categorie de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOCategorie() {
		try {
			setUp();
			daoc.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur un cas o� une mauvaise suppression des donn�es de la table Categorie s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOCategorie() {
		try {
			setUp();
			daoc.supprimerPersistance("poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}


	
}
