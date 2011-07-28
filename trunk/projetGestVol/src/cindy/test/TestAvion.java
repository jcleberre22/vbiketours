package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import cindy.metier.avion.Avion;

/**
 * Test sur l'utilisation des methodes publiques d'un avion.
 * 
 * @author JC.leberre
 * @version 1.0 du 26/07/2011
 */
public class TestAvion {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Méthode de test qui va permettre de vérifier si tous les paramètres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new Avion("AL1256S", "rafale", "type", true);
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le parametre immat est
	 * geré quand il est null. Englober dans un try catch, affichage du message
	 * de l'exception.
	 */
	@Test
	public void testConstructorNullImmat() {
		try {
			new Avion(null, "rafale", "type", true);
			fail("Paramètre immat null non géré ");
		} catch (Exception e) {
			assertTrue("Paramètre immat null géré " + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le parametre type est
	 * geré quand il est null. Englober dans un try catch, affichage du message
	 * de l'exception.
	 */
	@Test
	public void testConstructorNullType() {
		try {
			new Avion("AL1256S", "rafale", null, true);
			fail("Paramètre type null non géré ");
		} catch (Exception e) {
			assertTrue("Paramètre type null géré " + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le parametre immat est
	 * geré quand il est null. Englober dans un try catch, affichage du message
	 * de l'exception.
	 */
	@Test
	public void testConstructorImmatVide() {
		try {
			new Avion("", "rafale", "type", true);
			fail("Paramètre immat vide non géré ");
		} catch (Exception e) {
			assertTrue("Paramètre immat vide géré " + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le parametre type est
	 * geré quand il est null. Englober dans un try catch, affichage du message
	 * de l'exception.
	 */
	@Test
	public void testConstructorTypeVide() {
		try {
			new Avion("AL1256S", "rafale", "", true);
			fail("Paramètre type vide non géré ");
		} catch (Exception e) {
			assertTrue("Paramètre type vide géré " + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si tous les paramètres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorOther() {
		try {
			new Avion("AL1256S", "Rafale", "combat", true);
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le parametre nom est geré
	 * quand il est null . Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorOtherNameNull() {
		try {
			new Avion("AL1256S", null, "combat", true);
			fail("Paramètre nom null non géré");
		} catch (Exception e) {
			assertTrue("Paramètre nom null géré" + e.getMessage(), true);
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le parametre nom est geré
	 * quand il est null. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorOtherNomVide() {
		try {
			new Avion("AL1256S", "", "type", true);
			fail("Paramètre nom vide non géré ");
		} catch (Exception e) {
			assertTrue("Paramètre nom vide géré " + e.getMessage(), true);
		}
	}

}
