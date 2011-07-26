package cindy.metier.comm;

import java.util.List;

import cindy.metier.personnel.Equipage;
import cindy.metier.vol.Evenement;


public interface ISortieAerienne {

	 IAvion getAvion();

	 IArmement getArm();
	

	 String getDebriefing();
	

	 List<Evenement> getEvent();
	
	 IMission getMission();
	
	
	 Equipage getEquipage();
	
}
