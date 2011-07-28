package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.avion.Armement;

/**
 * Test sur l'utilisation des methodes publiques d'un d'armement.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class TestArmement {

	int type;
	String description;
	Armement arm;

	@Before
	public void setUp() throws Exception {
		arm = new Armement();
	}

	@Test
	public void testConstructeur() {
		try {
			new Armement(-2);
			fail("le pack d'armement choisi n'est pas géré");
		} catch (Exception e) {
			assertTrue("l'instanciation de l'armement a fonctionné", true);
		}

	}

	@Test
	public void testConstructeurOk() {
		try {
			new Armement(5);
			assertTrue("l'instanciation est correcte", true);
		} catch (Exception e) {
			fail("l'instanciation n'est pas bonne : " + e.getMessage());
		}
	}

}
