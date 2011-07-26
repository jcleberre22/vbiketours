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
	 * M�thode de test qui va permettre de v�rifier si tous les param�tres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new Armement("Missile Nucl�aire");
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� le constructeur
	 * est null. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorNull() {
		try {
			new Armement(null);
			fail("Param�tre constructeur null non g�r�");
		} catch (Exception e) {
			assertTrue("Probl�me param�tre constructeur null non g�r�" + e.getMessage(), true);
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� le constructeur
	 * est vide. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorVide() {
		try {
			new Armement("");
			fail("Param�tre constructeur null non g�r�");
		} catch (Exception e) {
			assertTrue("Probl�me param�tre constructeur null non g�r�" + e.getMessage(), true);
		}
	}
}

