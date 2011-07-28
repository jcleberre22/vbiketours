package cindy.paqMetier.vol;

import java.util.List;

import java.util.GregorianCalendar;
import cindy.paqMetier.comm.ISortieAerienne;
import cindy.paqMetier.personnel.Equipage;

/**
 * Classe des Sorties Aeriennes. Classe permettant de gerer les sorties
 * aeriennes
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 25/07/2011
 */
public class SortieAerienne implements ISortieAerienne {
	private Avion avion;
	private Armement arm;
	private String debrief;
	private Equipage equipage;
	private Mission mission;
	private List<Evenement> event;
	private GregorianCalendar decolage;
	private GregorianCalendar atterissage;

	/**
	 * Constructeur de la classe SortieAerienne. 
	 * liste des paramètres:
	 * @param avion
	 * @param arm
	 * @param debriefing
	 * @param event
	 * @param equipage
	 * @param mission
	 * @param decolage
	 * @param atterissage
	 */
	
	//TODO GregorianCalendar,heures decol/atter
	public SortieAerienne(Avion avion, String debrief, Armement arm,
			List<Evenement> event, Equipage equipage, Mission mission, GregorianCalendar decolage,GregorianCalendar atterissage) {
		setArm(arm);
		setAvion(avion);
		setDebriefing(debrief);
		setEvent(event);
		setEquipage(equipage);
		setMission(mission);
		setDecolage(decolage);
		setAtterissage(atterissage);
	}



	public void ajouterEvenement(Evenement ev) {
		if (ev == null) {
			throw new RuntimeException("evenement null");
		} else {
			event.add(ev);
		}
	}
	
	

	// GETTERS PUBLIQUES

	public Avion getAvion() {
		return avion;
	}

	public Armement getArm() {
		return arm;
	}

	public String getDebriefing() {
		return debrief;
	}

	public List<Evenement> getEvent() {
		return event;
	}

	public Mission getMission(){
		return mission;
	}
	
	public Equipage getEquipage() {
		return equipage;
	}
	public String getDebrief() {
		return debrief;
	}
	
	public GregorianCalendar getDecolage() {
		return decolage;
	}

	public GregorianCalendar getAtterissage() {
		return atterissage;
	}
	// SETTERS PRIVEES
	public void setAvion(Avion avion) {
		if (avion == null) {
			throw new RuntimeException("avion null");
		} else {
		this.avion = avion;
		}
	}

	public void setArm(Armement arm) {
		if (arm == null) {
			throw new RuntimeException("armement null");
		} else {
		this.arm = arm;
		}
	}

	public void setEvent(List<Evenement> event) {
		if (event == null) {
			throw new RuntimeException("liste d'evenement null");
		} else {
		this.event = event;
		}
	}

	public void setEquipage(Equipage equipage) {
		if (equipage == null) {
			throw new RuntimeException("equipage null");
		} else {
		this.equipage = equipage;
		}
	}

	public void setDebriefing(String debrief) {
		if (debrief == null) {
			throw new RuntimeException("debriefing null");
		} else {
			this.debrief = debrief;
		}
	}

	public void setMission(Mission mission) {
		if (mission == null) {
			throw new RuntimeException("mission null");
		} else {
			this.mission = mission;
		}
	}
	
	private void setAtterissage(GregorianCalendar atterissage) {
		if (atterissage==null){
			throw new RuntimeException("atterissage null");
		}else{
			this.atterissage=atterissage;
		}
	}

	private void setDecolage(GregorianCalendar decolage) {
		if (decolage==null){
			throw new RuntimeException("decolage null");
		}else{
			this.decolage=decolage;
		}
	}
}
