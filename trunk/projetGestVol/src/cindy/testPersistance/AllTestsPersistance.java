package cindy.testPersistance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test sur l'utilisation de toutes les méthodes de toutes les classes du package persistance.
 * Cette classe appelle toutes les classes tests.
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 29/05/2011
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ TestPersitanceCategorie.class, TestPersistanceCirculation.class, TestPersistanceEquipage.class,
				TestPersistanceEscadron.class, TestPersistanceEvenement.class, TestPersistanceMission.class,
				TestPersistanceQualification.class})
public class AllTestsPersistance {
}
