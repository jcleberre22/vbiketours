package cindy.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import cindy.metier.comm.IEscadron;
import cindy.metier.personnel.*;

/**
 * Test sur l'utilisation des methodes publiques d'un escadron.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 26/07/2011
 */
public class TestEscadron {

	private IEscadron esc;
	private Equipage eq = new Equipage();
	@SuppressWarnings("unused")
	private ArrayList<Equipage> equipage = new ArrayList<Equipage>();

	@Before
	public void setUp() throws Exception {
		esc = new Escadron(" Test ", new ArrayList<PersonnelNavigant>());
	}

	@Test
	public void testConstructEscadron() {
		try {
			esc = new Escadron("escad1", new ArrayList<PersonnelNavigant>());
			assertTrue("instanciation reussi", true);
		} catch (Exception e) {
			fail("erreur d'instanciation" + e.getMessage());
		}
	}

	@Test
	public void testAjouterEqui() {
		try {
			esc.ajouterEquipage(eq);
			assertTrue("Ajout ok", true);
		} catch (Exception e) {
			fail("Probleme d'ajout" + e.getMessage());
		}
	}

	@Test
	public void testAjouterEquiNull() {
		try {
			esc.ajouterEquipage(null);
			fail("Impossible d'ajouter rien");
		} catch (Exception e) {
			assertTrue("Impossible d'ajouter rien géré " + e.getMessage(), true);
		}
	}

	@Test
	public void testAjouterSupprimer() {
		try {
			esc.supprimerEquipage(eq);
			assertTrue("Impossible d'ajouter rien géré ", true);
		} catch (Exception e) {
			fail("Impossible de supprimer" + e.getMessage());
		}
	}

}
