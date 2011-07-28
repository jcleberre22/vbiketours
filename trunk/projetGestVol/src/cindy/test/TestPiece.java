package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.avion.Piece;

/**
 * Test sur l'utilisation des methodes publiques d'un equipage.
 * 
 * @author JC.Leberre
 * @version 1.0 du 26/07/2011
 */
public class TestPiece {

	@SuppressWarnings("unused")
	private Piece piece;

	@Before
	public void setUp() throws Exception {
		piece = new Piece("type", 15);
	}

	@Test
	public void testConstructPiece() {
		try {
			piece = new Piece("type", 1);
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}

	@Test
	public void testConstructPieceNull() {
		try {
			piece = new Piece("type", 0);
			fail("erreur d'instanciation nbPiece null");
		} catch (Exception e) {
			assertTrue("test reussi", true);
		}
	}

}
