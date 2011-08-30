package cindy.testPersistance;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.persistance.DAOPilote;

/**
 * Test sur l'utilisation des methodes publiques de la persitance
 * d'un pilote.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 */
public class TestPersistancePilote {

	private DAOPilote daop;
	
	@Before
	public void setUp() throws Exception {
		daop = new DAOPilote();
	}
	
	/**
	 * M�thode de test qui va permettre la bonne instanciation du constructeur. 
	 * Englober dans un try catch, affichage du message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new DAOPilote();
			assertTrue("Instanciation constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me constructeur " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la lecture de la table Pilote de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testLectureDAOPilote(){
		try {
			setUp();
			daop.lire();
			assertTrue("Lecture des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur la lecture de la table Pilote de la BDD.
	 * Utilise une requete avec un SELECT.
	 */
	@Test
	public void testInsertionDAOPilote() {
		try {
			setUp();
			daop.insererPersistance(1,"161SV4","AL25GJH","TABUTEAUD","Nicopops","SGT",1,1,1,"tireur au flanc",0,1,true);
			assertTrue("Insertion des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}


	/**
	 * M�thode de test sur la modification des donn�es de la table Pilote de la BDD.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testModificationDAOPilote() {
		try {
			setUp();
			daop.modifierPersistance("161SV4","AL25GJH","TABUTEAUD","Nicopops","SGT",1,1,1,"tireur au flanc",0,1,true,1);
			assertTrue("Modification des donn�es reussies", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}	

	/**
	 * M�thode de test sur l'insertion des donn�es de la table Pilote de la BDD.
	 * Utilise une requete avec un INSERT INTO.
	 */
	@Test
	public void testMauvaiseInsertionDAOPilote() {
		try {
			setUp();
			daop.insererPersistance(12,23,"TABUTEAUD","Nicopops","SGT","Enorme Poulet",1,1,"tireur au flanc",0,1,true,1);
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	
	
	/**
	 * M�thode de test sur un cas o� une mauvaise modification des donn�es de la table Pilote s'effectue.
	 * Utilise une requete avec un UPDATE.
	 */
	@Test
	public void testMauvaiseModificationDAOPilote() {
		try {
			setUp();
			daop.modifierPersistance("Gros poulet",23,"TABUTEAUD","Nicopops","SGT","Enorme Poulet",1,1,"tireur au flanc",0,1,true,1);
			fail("Donn�es inserer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Modification des donn�es ger�"+ e.getMessage(), true);
		}
	}	

	/**
	 * M�thode de test sur la suppression des donn�es de la table Pilote de la BDD.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testSuppressionDAOPilote() {
		try {
			setUp();
			daop.supprimerPersistance(1);
			assertTrue("Suppression des donn�es reussie", true);
		} catch (Exception e) {
			fail("Probl�me de requetes " + e.getMessage());
		}
	}

	/**
	 * M�thode de test sur un cas o� une mauvaise suppression des donn�es de la table Circulation s'effectue.
	 * Utilise une requete avec un DELETE FROM.
	 */
	@Test
	public void testMauvaiseSuppressionDAOPilote() {
		try {
			setUp();
			daop.supprimerPersistance("Grand Poulet");
			fail("Donn�es supprimer non correct non ger� ");
		} catch (Exception e) {
			assertTrue("Mauvaise suppression des donn�es ger�"+ e.getMessage(), true);
		}
	}

	
	
	
}
