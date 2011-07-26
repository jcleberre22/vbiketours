package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.avion.Armement;


/**
 * Test sur l'utilisation des methodes publiques d'un armement.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class TestArmement {

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
			new Armement("Missile Nucléaire");
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}
	
	/**
	 * Méthode de test qui va permettre de vérifier le cas où le constructeur
	 * est null. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorNull() {
		try {
			new Armement(null);
			fail("Paramètre constructeur null non géré");
		} catch (Exception e) {
			assertTrue("Problème paramètre constructeur null non géré" + e.getMessage(), true);
		}
	}
	
	/**
	 * Méthode de test qui va permettre de vérifier le cas où le constructeur
	 * est vide. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorVide() {
		try {
			new Armement("");
			fail("Paramètre constructeur null non géré");
		} catch (Exception e) {
			assertTrue("Problème paramètre constructeur null non géré" + e.getMessage(), true);
		}
	}
}

