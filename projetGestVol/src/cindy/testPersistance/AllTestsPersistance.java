package cindy.testPersistance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test sur l'utilisation de toutes les méthodes de toutes les classes du package persistance.
 * Cette classe appelle toutes les classes testPersistance.
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 30/08/2011
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ TestPersitanceCategorie.class, TestPersistanceCirculation.class, TestPersistanceEquipage.class,
				TestPersistanceEscadron.class, TestPersistanceEvenement.class, TestPersistanceMission.class,
				TestPersistanceQualification.class, TestPersistancePilote.class})
public class AllTestsPersistance {
}
