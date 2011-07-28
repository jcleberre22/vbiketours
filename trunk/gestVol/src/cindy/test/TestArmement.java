package cindy.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cindy.paqMetier.vol.Armement;

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
			assertTrue("l'instanciation de l'armement a fonctionné",true);
		}
		
	}
	
	@Test
	public void testConstructeurOk(){
		try {
			new Armement(5);
			assertTrue("l'instanciation est correcte", true);
		} catch (Exception e) {
			fail("l'instanciation n'est pas bonne : "+e.getMessage() );
		}
	}

}
