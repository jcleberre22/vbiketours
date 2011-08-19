package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.vol.Categorie;

/**
 * Test sur l'utilisation des methodes publiques d'une categorie de vol.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class TestCategorie {

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
			new Categorie(1);
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}

	/**
	 * Méthode de test qui va permettre de vérifier si le parametre numero est
	 * geré quand il est negatif. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorNumNegatif() {
		try {
			new Categorie(-5);
			fail("Problème paramètre negatif non géré constructeur ");
		} catch (Exception e) {
			assertTrue("Paramètre constructeur negatif géré" + e.getMessage(),
					true);
		}
	}

}
