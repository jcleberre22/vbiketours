package cindy.metier.vol;

import java.util.List;

import cindy.metier.comm.IArmement;
import cindy.metier.comm.IAvion;
import cindy.metier.comm.IMission;
import cindy.metier.comm.ISortieAerienne;
import cindy.metier.personnel.Equipage;

/**
 * Classe des Sorties Aeriennes. Classe permettant de gerer les sorties
 * aeriennes
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 25/07/2011
 */

public class SortieAerienne implements ISortieAerienne, IAvion, IArmement {
	private IAvion avion;
	private IArmement arm;
	private String debrief;
	private Equipage equipage;
	private IMission mission;
	private List<Evenement> event;

	/**
	 * Constructeur de la classe SortieAerienne. liste des paramètres:
	 * 
	 * @param avion
	 * @param arm
	 * @param debriefing
	 * @param event
	 * @param equipage
	 * @param mission
	 */
	public SortieAerienne(IAvion avion, String debrief, IArmement arm,
			List<Evenement> event, Equipage equipage, IMission mission) {
		setIArm(arm);
		setIAvion(avion);
		setDebriefing(debrief);
		setEvent(event);
		setEquipage(equipage);
		setIMission(mission);
	}

	public void ajouterEvenement(Evenement ev) {
		if (ev == null) {
			throw new RuntimeException("evenement null");
		} else {
			event.add(ev);
		}
	}

	//GETTERS PUBLIQUES

	public IAvion getAvion() {
		return avion;
	}

	public IArmement getArm() {
		return arm;
	}

	public String getDebriefing() {
		return debrief;
	}

	public List<Evenement> getEvent() {
		return event;
	}

	public IMission getMission() {
		return mission;
	}

	public Equipage getEquipage() {
		return equipage;
	}

	// SETTERS PRIVEES
	private void setIAvion(IAvion avion) {
		if (avion == null) {
			throw new RuntimeException("avion null");
		} else {

			this.avion = avion;
		}
	}

	private void setIArm(IArmement arm) {
		if (arm == null) {
			throw new RuntimeException("armement null");
		} else {

			this.arm = arm;
		}
	}

	private void setEvent(List<Evenement> event) {
		this.event = event;
	}

	private void setEquipage(Equipage equipage) {
		if (equipage == null) {
			throw new RuntimeException("equipage null");
		} else {

			this.equipage = equipage;
		}
	}

	private void setDebriefing(String debrief) {
			this.debrief = debrief;
	}

	private void setIMission(IMission mission) {
		if (mission == null) {
			throw new RuntimeException("mission null");
		} else {
			this.mission = mission;
		}
	}

	@Override
	public String getImmatriculation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}


}
