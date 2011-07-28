package cindy.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test sur l'utilisation de toutes les méthodes de toutes les classes. Cette
 * classe appelle toutes les classes tests.
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 27/05/2011
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ TestPersonnel.class, TestEquipage.class, TestArmement.class,
		TestAvion.class, TestCategorie.class, TestMission.class,
		TestEscadron.class, TestEvenement.class, TestPiece.class,
		TestSortieAerienne.class, TestVol.class })
public class AllTests {
}
