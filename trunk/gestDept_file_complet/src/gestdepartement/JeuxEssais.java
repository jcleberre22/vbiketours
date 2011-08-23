package gestdepartement;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import gestdepartement.metier.FacadeMetier;
import gestdepartement.metier.comm.IDepartementConsultable;
import gestdepartement.metier.comm.comparator.DepCompareHab;
import gestdepartement.metier.comm.comparator.DepCompareReg;

public class JeuxEssais {
	private FacadeMetier facade;
	private static final Logger LOG = Logger.getLogger(JeuxEssais.class);
	
	public JeuxEssais(FacadeMetier fac) {
		facade = fac;
		ajouterRegion();
		ajouterDepartements();
	}
	
	private void ajouterRegion() {
		facade.ajouterRegion("Alsace");
		facade.ajouterRegion("Aquitaine");
		facade.ajouterRegion("Auvergne");
		facade.ajouterRegion("Basse-Normandie");
		facade.ajouterRegion("Bourgogne");
		facade.ajouterRegion("Bretagne");
		facade.ajouterRegion("Centre");
	}
	
	private void ajouterDepartements() {
		facade.ajouterDepartement("Alsace", " 67", "Bas-Rhin", 1091015, 4755);
		facade.ajouterDepartement("Alsace", " 68", "Haut-Rhin", 746072, 3525);
		
		facade.ajouterDepartement("Aquitaine", " 24", "Dordogne", 409388, 9060);
		facade.ajouterDepartement("Aquitaine", " 33", "Gironde", 1421276, 10000);
		facade.ajouterDepartement("Aquitaine", " 40", "Landes", 373142, 9243);
		facade.ajouterDepartement("Aquitaine", " 47", "Lot-et-Garonne", 326399, 5361);
		facade.ajouterDepartement("Aquitaine", " 64", "Pyrénées-Atlantiques", 647420, 7645);
		
		facade.ajouterDepartement("Auvergne", " 03", "Allier", 342807, 7340);
		facade.ajouterDepartement("Auvergne", " 15", "Cantal", 148737, 5726);
		facade.ajouterDepartement("Auvergne", " 43", "Haute-Loire", 221834, 4977);
		facade.ajouterDepartement("Auvergne", " 63", "Puy-de-Dôme", 628485, 7970);
	
		facade.ajouterDepartement("Basse-Normandie", " 14", "Calvados", 678206, 5548);
		facade.ajouterDepartement("Basse-Normandie", " 50", "Manche", 496937, 5938);
		facade.ajouterDepartement("Basse-Normandie", " 61", "Orne", 292282, 6103);
		  
		facade.ajouterDepartement("Bourgogne", " 21", "Côte-d'Or", 521608, 8763);
		facade.ajouterDepartement("Bourgogne", " 58", "Nièvre", 220653, 6817);
		facade.ajouterDepartement("Bourgogne", " 71", "Saône-et-Loire", 553968, 8575);
		facade.ajouterDepartement("Bourgogne", " 89", "Yonne", 342359, 7427);
		 
		facade.ajouterDepartement("Bretagne", " 22", "Côtes-d'Armor", 581570, 6878);
		facade.ajouterDepartement("Bretagne", " 29", "Finistère", 890509, 6733);
		facade.ajouterDepartement("Bretagne", " 35", "Ille-et-Vilaine", 967588, 6775);
		facade.ajouterDepartement("Bretagne", " 56", "Morbihan", 710034, 6823);
		
		facade.ajouterDepartement("Centre", " 18", "Cher", 313251, 7235);
		facade.ajouterDepartement("Centre", " 28", "Eure-et-Loir", 423559, 5880);
		facade.ajouterDepartement("Centre", " 36", "Indre", 232004, 6791);
		facade.ajouterDepartement("Centre", " 37", "Indre-et-Loire", 585406, 6127);
		facade.ajouterDepartement("Centre", " 41", "Loir-et-Cher", 326599, 6343);
		facade.ajouterDepartement("Centre", " 45", "Loiret", 650769, 6775);

	}
	public static void main(String[] args) {
		FacadeMetier f = new FacadeMetier();
		new JeuxEssais(f);
		List<String> lst = f.listerRegion();
		for (String info : lst) {
			System.out.println(info);
		}
		 lst = f.listerDepartements();
		for (String info : lst) {
			System.out.println(info);
		}
		
		LOG.warn(f.getDepartement("50"));
		System.out.println("liste trier par nom");
		List<IDepartementConsultable> ret = f.listerDepartementTries();
		for (IDepartementConsultable departement : ret) {
			System.out.println(departement);
		}
		System.out.println("liste trier par nombre d'habitant");
		Collections.sort(ret, new DepCompareHab());
		for (IDepartementConsultable departement : ret) {
			System.out.println(departement);
		}
	}
}
