package cindy.test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import cindy.metier.avion.Avion;

public class TestAvion {

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
			new Avion("AL1256S","combat");
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier si le parametre immat
	 * est ger� quand il est null. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorNullImmat() {
		try {
			new Avion(null,"combat");
			fail("Param�tre immat null non g�r� ");
		} catch (Exception e) {
			assertTrue("Param�tre immat null g�r� " + e.getMessage(),true);
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier si le parametre type
	 * est ger� quand il est null. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorNullType() {
		try {
			new Avion("AL1256S",null);
			fail("Param�tre type null non g�r� ");
		} catch (Exception e) {
			assertTrue("Param�tre type null g�r� " + e.getMessage(),true);
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier si le parametre immat
	 * est ger� quand il est null. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorImmatVide() {
		try {
			new Avion("","combat");
			fail("Param�tre immat vide non g�r� ");
		} catch (Exception e) {
			assertTrue("Param�tre immat vide g�r� " + e.getMessage(),true);
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier si le parametre type
	 * est ger� quand il est null. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorTypeVide() {
		try {
			new Avion("AL1256S","");
			fail("Param�tre type vide non g�r� ");
		} catch (Exception e) {
			assertTrue("Param�tre type vide g�r� " + e.getMessage(),true);
		}
	}
	

	/**
	 * M�thode de test qui va permettre de v�rifier si tous les param�tres sont
	 * bon dans le constructeur. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorOther() {
		try {
			new Avion("AL1256S","Rafale","combat");
			assertTrue("Param�tre constructeur ok", true);
		} catch (Exception e) {
			fail("Probl�me param�tre constructeur " + e.getMessage());
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier si le parametre nom
	 * est ger� quand il est null . Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorOtherNameNull() {
		try {
			new Avion("AL1256S",null,"combat");
			fail("Param�tre nom null non g�r�");
		} catch (Exception e) {
			assertTrue("Param�tre nom null g�r�" + e.getMessage(),true);
		}
	}
	
	/**
	 * M�thode de test qui va permettre de v�rifier si le parametre nom
	 * est ger� quand il est null. Englober dans un try catch, affichage du
	 * message de l'exception.
	 */
	@Test
	public void testConstructorOtherNomVide() {
		try {
			new Avion("AL1256S","","");
			fail("Param�tre nom vide non g�r� ");
		} catch (Exception e) {
			assertTrue("Param�tre nom vide g�r� " + e.getMessage(),true);
		}
	}

	
	
}
