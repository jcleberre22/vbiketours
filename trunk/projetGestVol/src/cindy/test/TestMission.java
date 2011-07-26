package cindy.test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cindy.metier.vol.Mission;

/**
 * Test sur l'utilisation des methodes publiques d'une mission.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class TestMission {

	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� le constructeur
	 * est null. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new Mission("AlphaJet");
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� le constructeur
	 * est null. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorNull() {
		try {
			new Mission(null);
			fail("Probl�me param�tre constructeur ");
		} catch (Exception e) {
			assertTrue("Param�tre constructeur ok"+ e.getMessage(), true);
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier le cas o� le constructeur
	 * est vide. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorVide() {
		try {
			new Mission("");
			fail("Probl�me param�tre constructeur ");
		} catch (Exception e) {
			assertTrue("Param�tre constructeur ok"+ e.getMessage(), true);
		}
	}
	

}
