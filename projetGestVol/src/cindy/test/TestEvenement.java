package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.vol.Evenement;

/**
 * Classe de Test sur les evenements.
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 27/07/2011
 */
public class TestEvenement {

	@SuppressWarnings("unused")
	private Evenement event;

	@Before
	public void setUp() throws Exception {
		event = new Evenement("nomEvent", "typeEvent");
	}

	@Test
	public void testConstructEvent() {
		try {
			event = new Evenement("nomEvent", "typeEvent");
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}

	@Test
	public void testConstructEventNomNull() {
		try {
			event = new Evenement(null, "typeEvent");
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}

	@Test
	public void testConstructEventTypeNull() {
		try {
			event = new Evenement("nomEvent", null);
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}

	@Test
	public void testConstructEventNomVide() {
		try {
			event = new Evenement("", "type");
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}

	@Test
	public void testConstructEventTypeVide() {
		try {
			event = new Evenement("nom", "");
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}
}
