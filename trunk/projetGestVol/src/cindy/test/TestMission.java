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
	 * Méthode de test qui va permettre de vérifier le cas où le constructeur
	 * est null. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructor() {
		try {
			new Mission("AlphaJet");
			assertTrue("Paramètre constructeur ok", true);
		} catch (Exception e) {
			fail("Problème paramètre constructeur " + e.getMessage());
		}
	}
	
	/**
	 * Méthode de test qui va permettre de vérifier le cas où le constructeur
	 * est null. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorNull() {
		try {
			new Mission(null);
			fail("Problème paramètre constructeur ");
		} catch (Exception e) {
			assertTrue("Paramètre constructeur ok"+ e.getMessage(), true);
		}
	}
	
	/**
	 * Méthode de test qui va permettre de vérifier le cas où le constructeur
	 * est vide. Englober dans un try catch, affichage du message de
	 * l'exception.
	 */
	@Test
	public void testConstructorVide() {
		try {
			new Mission("");
			fail("Problème paramètre constructeur ");
		} catch (Exception e) {
			assertTrue("Paramètre constructeur ok"+ e.getMessage(), true);
		}
	}
	

}
