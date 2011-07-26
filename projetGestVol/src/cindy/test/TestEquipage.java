package cindy.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.personnel.Equipage;
import cindy.metier.personnel.PersonnelNaviguant;

/**
 * Test sur l'utilisation des methodes publiques d'un equipage.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class TestEquipage {

	private PersonnelNaviguant persNavi;
	private PersonnelNaviguant persPil;
	
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
			new Equipage(persPil,persNavi);
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier si juste un seul parametre fonctionne.
	 * Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorUnPilote() {
		try {
			new Equipage(persPil);
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}
	
	
	
	
	
	
}
