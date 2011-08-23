package gestdepartement.test;


import static org.junit.Assert.*;
import gestdepartement.metier.comm.IDepartementTest;
import gestdepartement.metier.comm.IRegion;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
/**
 * Test sur l'utilisation des methodes publiques
 * d'un departement.
 * Le departement est instancié au travers de spring.
 * Il est contenu dans le fichier bean.xml
 * @author marc.leconte
 * @version 1.0
 */
public class DepartementTest {
	private static String fileBeans = "gestdepartement/test/bean.xml";
	private IDepartementTest departement;
	private IRegion region;
	@Before
	public void setUp() throws Exception {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(fileBeans));
		departement = (IDepartementTest) beanFactory.getBean("departement");
		region = (IRegion) beanFactory.getBean("region");
		departement.setAppartenance(region);
	}
	
	@Test
	public void testToString(){
		assertEquals("Departement [code= 50, nom=manche, nombreHabitant=100, appartenance=basse normandie, superficie=10]", departement.toString());
	}
	@Test
	public void testCode(){
		assertEquals("code egal a ' 50'"," 50",departement.getCode());
	}
	
	@Test
	public void testDoublonsEquals(){
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(fileBeans));
		IDepartementTest doublons = (IDepartementTest) beanFactory.getBean("departementDoublons");
		assertTrue("Test detection code identique",departement.equals(doublons));
	}
	@Test
	public void testDoublonsHashCode(){
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(fileBeans));
		IDepartementTest doublons = (IDepartementTest) beanFactory.getBean("departementDoublons");
		assertEquals("Test detection code identique",departement.hashCode(),doublons.hashCode());
	}
}
