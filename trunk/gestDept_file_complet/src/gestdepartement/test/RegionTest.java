package gestdepartement.test;

import static org.junit.Assert.*;

import java.util.List;

import gestdepartement.metier.comm.IRegion;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class RegionTest {
	private static String fileBeans = "gestdepartement/test/bean.xml";
	private IRegion region;
	
	@Before
	public void setUp() throws Exception {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(fileBeans));
		region = (IRegion) beanFactory.getBean("region");
	}

	@Test
	public void testAjouterDepartement(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			assertTrue("creation departement nominal OK",true);
		} catch(Exception e) {
			fail("création nominal en erreur "+e.getMessage());
		}
	}
	@Test
	public void testAjouterDepartementErreurCode(){
		try {
			region.ajouterDepartement("", "Manche", 15, 100);
			fail("creation departement erronée");
		} catch(Exception e) {
			assertTrue("création departement erronée gérée erreur: "+e.getMessage(), true);
		}
	}
	@Test
	public void testAjouterDepartementErreurCodeNull(){
		try {
			region.ajouterDepartement(null, "Manche", 15, 100);
			fail("creation departement erronée");
		} catch(Exception e) {
			assertTrue("création departement erronée gérée erreur: "+e.getMessage(), true);
		}
	}
	@Test
	public void testAjouterDepartementErreurNom(){
		try {
			region.ajouterDepartement("50", " ", 15, 100);
			fail("creation departement erronée");
		} catch(Exception e) {
			assertTrue("création departement erronée gérée erreur: "+e.getMessage(), true);
		}
	}
	@Test
	public void testAjouterDepartementErreurPop(){
		try {
			region.ajouterDepartement("50", "Manche", -15, 100);
			fail("creation departement erronée");
		} catch(Exception e) {
			assertTrue("création departement erronée gérée erreur: "+e.getMessage(), true);
		}
	}
	@Test
	public void testAjouterDepartementErreurSuperficie(){
		try {
			region.ajouterDepartement("50", "Manche", 15, -100);
			fail("creation departement erronée");
		} catch(Exception e) {
			assertTrue("création departement erronée gérée erreur: "+e.getMessage(), true);
		}
	}
	@Test
	public void testAjouterDepartementErreurDoublons(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			region.ajouterDepartement("50", "Orne", 150, 1000);
			fail("creation departement erronée doublons non détecté");
		} catch(Exception e) {
			assertTrue("création departement erronée gérée erreur: "+e.getMessage(), true);
		}
	}
	
	@Test
	public void testListerDepartement(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			region.ajouterDepartement("14", "Orne", 150, 1000);
			List<String> lst = region.listerDepartement();
			assertEquals("nb de departement lister",2, lst.size());
		} catch(Exception e) {
			fail("probleme erreur: "+e.getMessage());
		}
	}
	@Test
	public void testSupprimerDepartementNominale(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			region.ajouterDepartement("14", "Orne", 150, 1000);
			region.supprimerDepartement("50");
			List<String> lst = region.listerDepartement();
			assertEquals("nb de departement lister",1, lst.size());
		} catch(Exception e) {
			fail("probleme erreur: "+e.getMessage());
		}
	}
	
	@Test
	public void testSupprimerDepartementErr(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			region.ajouterDepartement("14", "Orne", 150, 1000);
			region.supprimerDepartement("64");
			fail("creation suppression impossible !!");
		} catch(Exception e) {
			assertTrue("suppression departement erronée gérée, erreur: "+e.getMessage(), true);
		}
	}
	
	@Test
	public void testModifierDepartement(){
		try {
			region.ajouterDepartement("50", "Marche", 15, 100);
			region.modifierDepartement("50", "Manche", 1500, 10000);
			assertTrue("modification sans probleme ", true);
		} catch(Exception e) {
			fail("modification en echec !! erreur:"+e.getMessage());	
		}
	}
	
	@Test
	public void testModifierDepartementErrValeur(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			region.modifierDepartement("50", " ", -1500, -10000);
			fail("modification qui ne doit pas passer !! erreur");

		} catch(Exception e) {
			assertTrue("modification rejetée avec le message d'erreur "+e.getMessage(), true);	
		}
	}
	
	@Test
	public void testModifierDepartementErrCode(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			region.modifierDepartement("5", "Manche", 15, 100);
			fail("modification qui ne doit pas passer !! erreur");
		} catch(Exception e) {
			assertTrue("modification rejetée avec le message d'erreur "+e.getMessage(), true);	
		}
	}
	
	@Test
	public void testSupprimerRegion(){
		try {
			region.ajouterDepartement("50", "Manche", 15, 100);
			region.ajouterDepartement("14", "Orne", 150, 1000);
			region.supprimer();
			assertTrue("suppression de la region ok ", true);
		} catch(Exception e) {
			fail("probleme a la suppression d'une region !! erreur "+e.getMessage());			
		}
	}
	
}
