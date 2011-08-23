package gestdepartement.test;

import static org.junit.Assert.*;

import java.util.List;

import gestdepartement.metier.comm.IPaysTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
public class PaysTest {
	private static String fileBeans = "gestdepartement/test/bean.xml";
	private IPaysTest pays;
	@Before
	public void setUp() throws Exception {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(fileBeans));
		pays = (IPaysTest) beanFactory.getBean("pays");
	}
	@Test
	public void testPays(){
		assertEquals("France", pays.getNom());
	}
	@Test
	public void testAjouterRegion(){
		try {
			pays.ajouterRegion("Bretagne");
			assertTrue("creation region nominal OK",true);
		} catch (Exception e) {
			fail("création d'une région en erreur :"+e.getMessage());
		}
	}
	@Test
	public void testAjouterRegionErr(){
		try {
			pays.ajouterRegion("Bretagne");
			pays.ajouterRegion("Bretagne");
			fail("création d'une région en double non gérée:");
		} catch (Exception e) {
			assertTrue("creation region en double erreur gérée :"+e.getMessage(),true);
		}
	}
	@Test
	public void testModifierRegionOK(){
		try {
			pays.ajouterRegion("Bertagne");
			pays.modifierRegion("Bertagne","Bretagne");
			assertTrue("modification region nominal OK",true);
		} catch (Exception e) {
			fail("modification d'une région en erreur :"+e.getMessage());
		}
	}
	@Test
	public void testModifierRegionErr(){
		try {
			pays.ajouterRegion("Bertagne");
			pays.modifierRegion("Bretagne","Bertagne");
			fail("modification d'une region inexistante non gérée:");
		} catch (Exception e) {
			assertTrue("modification d'une region inexistante gérée:"+e.getMessage(),true);
		}
	}
	@Test
	public void testSupprimerRegionOK(){
		try {
			pays.ajouterRegion("Bertagne");
			pays.supprimerRegion("Bertagne");
			assertTrue("suppression region nominal OK",true);
		} catch (Exception e) {
			fail("suppression d'une région en erreur :"+e.getMessage());
		}
	}
	@Test
	public void testSupprimerRegionErr(){
		try {
			pays.supprimerRegion("Bertagne");
			fail("suppression d'une region inexistante non gérée:");
		} catch (Exception e) {
			assertTrue("suppression d'une region inexistante gérée:"+e.getMessage(),true);
		}
	}
	@Test
	public void testListerRegionOK(){
		try {
			pays.ajouterRegion("Bretagne");
			pays.ajouterRegion("Normandie");
			List<String> ret = pays.listerRegion(); 
			assertEquals("test du nombre de region",2,ret.size());
		} catch (Exception e) {
			fail("erreur lors du listage des regions :"+e.getMessage());
		}
	}
	@Test
	public void testAjouterDepartementOK(){
		try {
			pays.ajouterRegion("Aquitaine");
			pays.ajouterDepartement("Aquitaine", " 24", "Dordogne", 409388, 9060);
			pays.ajouterDepartement("Aquitaine", " 33", "Gironde", 1421276, 10000);
			pays.ajouterDepartement("Aquitaine", " 40", "Landes", 373142, 9243);
			pays.ajouterDepartement("Aquitaine", " 47", "Lot-et-Garonne", 326399, 5361);
			pays.ajouterDepartement("Aquitaine", " 64", "Pyrénées-Atlantiques", 647420, 7645);

			assertTrue("Ajout de departement cas nominal OK",true);
		} catch (Exception e) {
			fail("Ajout de departement en erreur :"+e.getMessage());
		}
	}
	@Test
	public void testAjouterDepartementErr(){
		try {
			pays.ajouterRegion("Aquitaine");
			pays.ajouterDepartement("Aquitaine", " 24", "Dordogne", 409388, 9060);
			pays.ajouterDepartement("Aquitaine", " 33", "Gironde", 1421276, 10000);
			pays.ajouterDepartement("Aquitaine", " 40", "Landes", 373142, 9243);
			pays.ajouterDepartement("Aquitaine", " 47", "Lot-et-Garonne", 326399, 5361);
			pays.ajouterDepartement("Aquitain", " 64", "Pyrénées-Atlantiques", 647420, 7645);
			fail("ajout d'un departement a une region inexistante non traite !!");
			
		} catch (Exception e) {
			assertTrue("Ajout de departement a une region inexistante en erreur :"+e.getMessage(),true);
		}
	}
	@Test
	public void testListerDepartement(){
		try {
			pays.ajouterRegion("Aquitaine");
			pays.ajouterDepartement("Aquitaine", " 24", "Dordogne", 409388, 9060);
			pays.ajouterDepartement("Aquitaine", " 33", "Gironde", 1421276, 10000);
			pays.ajouterDepartement("Aquitaine", " 40", "Landes", 373142, 9243);
			pays.ajouterDepartement("Aquitaine", " 47", "Lot-et-Garonne", 326399, 5361);
			pays.ajouterDepartement("Aquitaine", " 64", "Pyrénées-Atlantiques", 647420, 7645);
			
			pays.ajouterRegion("Basse-Normandie");
			pays.ajouterDepartement("Basse-Normandie", " 14", "Calvados", 678206, 5548);
			pays.ajouterDepartement("Basse-Normandie", " 50", "Manche", 496937, 5938);
			pays.ajouterDepartement("Basse-Normandie", " 61", "Orne", 292282, 6103);
			
			List<String> ret = pays.listerDepartements();
			assertEquals("test le nombre de departement listé ", 8,ret.size());
			
			
		} catch (Exception e) {
			fail("Erreur sur le listage des departements du pays :"+e.getMessage());
		}
	}
	@Test
	public void testSupprimerDepartement(){
		try {
			pays.ajouterRegion("Aquitaine");
			pays.ajouterDepartement("Aquitaine", " 24", "Dordogne", 409388, 9060);
			pays.ajouterDepartement("Aquitaine", " 33", "Gironde", 1421276, 10000);
			pays.ajouterDepartement("Aquitaine", " 40", "Landes", 373142, 9243);
			pays.ajouterDepartement("Aquitaine", " 47", "Lot-et-Garonne", 326399, 5361);
			pays.ajouterDepartement("Aquitaine", " 64", "Pyrénées-Atlantiques", 647420, 7645);
			
			pays.ajouterRegion("Basse-Normandie");
			pays.ajouterDepartement("Basse-Normandie", " 14", "Calvados", 678206, 5548);
			pays.ajouterDepartement("Basse-Normandie", " 50", "Manche", 496937, 5938);
			pays.ajouterDepartement("Basse-Normandie", " 61", "Orne", 292282, 6103);
			
			pays.supprimerDepartement(" 47");
			List<String> ret = pays.listerDepartements();
			assertEquals("test le nombre de departement listé apres suppression ", 7,ret.size());
			
		} catch (Exception e) {
			fail("Erreur sur la suppression d'un departement :"+e.getMessage());
		}
	}
}
