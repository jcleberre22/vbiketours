package cindy.testPersistance;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOAvion;
import cindy.persistance.DAOPilote;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'un avion.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistanceAvion {

	private DAOAvion daoa;
	
	@Before
	public void setUp() throws Exception {
		daoa = new DAOAvion();
	}
	
	/**
	 * M�thode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOAvion();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur la lecture de la table Avion de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOAvion(){
		try {
			setUp();
			daoa.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur la lecture de la table Avion de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testInsertionDAOAvion() {
		try {
			setUp();
			daoa.insererPersistance(1, "56265ALH","chasse",1,54,false,false);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur la modification des donn�es de la table Avion de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOPilote() {
		try {
			setUp();
			daoa.modifierPersistance(1, "56265ALH","chasseur",3,59,true,false);
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	
	
	/**
	 * M�thode de test sur l'insertion des donn�es de la table Avion de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOPilote() {
		try {
			setUp();
			daoa.insererPersistance("poulet", "56265ALH","chasseur",3,59,true,false);
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}
	
	/**
	 * M�thode de test sur un cas o� une mauvaise modification des donn�es de la table Avion s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOPilote() {
		try {
			setUp();
			daoa.modifierPersistance("poulet", "56265ALH","chasseur",3,59,true,false);
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}
	
	/**
	 * M�thode de test sur la suppression des donn�es de la table Avion de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOPilote() {
		try {
			setUp();
			daoa.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test sur un cas o� une mauvaise suppression des donn�es de la table Avion s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOPilote() {
		try {
			setUp();
			daoa.supprimerPersistance("Poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}
	
	
}
