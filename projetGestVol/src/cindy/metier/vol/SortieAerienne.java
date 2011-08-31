package cindy.metier.vol;

import java.util.GregorianCalendar;
import java.util.List;
import cindy.metier.avion.Armement;
import cindy.metier.avion.Avion;
import cindy.metier.comm.ISortieAerienne;
import cindy.metier.personnel.Equipage;

/**
 * Classe des Sorties Aeriennes. Classe permettant de gerer les SortiesAeriennes
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 25/07/2011
 */
public class SortieAerienne implements ISortieAerienne {
	/** Attribut avion */
	private Avion avion;
	/** Attribut armement */
	private Armement arm;
	/** Attribut debriefing */
	private String debrief;
	/** Attribut Equipage */
	private Equipage equipage;
	/** Attribut Mission */
	private Mission mission;
	/** Attribut Vol */
	private Vol leVol;
	/** Attribut liste d'evenement */
	private List<Evenement> event;
	/** Attribut heure decolage */
	private GregorianCalendar decolage;
	/** Attribut heure atterissage */
	private GregorianCalendar atterissage;

	/**
	 * Constructeur de la classe SortieAerienne. liste des paramètres:
	 * 
	 * @param avion
	 *            de type Avion
	 * @param arm
	 *            de type Armement
	 * @param debriefing
	 *            de type String
	 * @param event
	 *            de type Liste d'evenement
	 * @param equipage
	 *            de type Equipage
	 * @param mission
	 *            de type Mission
	 * @param leVol
	 * 			  de type Vol
	 * @param decolage
	 *            de type GregorianCalendar
	 * @param atterissage
	 *            de type GregorianCalendar
	 */

	public SortieAerienne(Avion avion, String debrief, Armement arm,
			List<Evenement> event, Equipage equipage, Mission mission,Vol leVol,
			GregorianCalendar decolage, GregorianCalendar atterissage) {
		setArm(arm);
		setAvion(avion);
		setDebriefing(debrief);
		setEvent(event);
		setEquipage(equipage);
		setMission(mission);
		setVol(leVol);
		setDecolage(decolage);
		setAtterissage(atterissage);
	}

	/**
	 * Methode ajouterEvenement. Permet d'ajouter un evenement a la
	 * SortieAerienne
	 * 
	 * @param ev
	 *            sous forme d'evenement
	 * @throws RuntimeException
	 *             en cas de non respect de la regle de gestion relative à
	 *             l'ajout d'un evenement
	 */
	public void ajouterEvenement(Evenement ev) {
		if (ev == null) {
			throw new RuntimeException("evenement null");
		} else {
			event.add(ev);
		}
	}

	/**
	 * Methode retirerEvenement. Permet d'enlever un evenement de la
	 * SortieAerienne
	 * 
	 * @param ev
	 *            sous forme d'evenement
	 * @throws RuntimeException
	 *             en cas de non respect de la regle de gestion relative à la
	 *             suppression d'un evenement
	 */
	public void retirerEvenement(Evenement ev) {
		for (Evenement evenement : event) {
			if (ev != null) {
				if (ev.equals(evenement)) {
					event.remove(evenement);
				} else {
					throw new RuntimeException("evenement inconnu");
				}
			} else {
				throw new RuntimeException("evenement null");
			}

		}
	}

	// GETTERS PUBLIQUES
	/**
	 * Recupere un avion.
	 * 
	 * @return avion sous forme Avion
	 */
	public Avion getAvion() {
		return avion;
	}

	/**
	 * Recupere un armement d'un avion.
	 * 
	 * @return armement sous forme Armement
	 */
	public Armement getArm() {
		return arm;
	}

	/**
	 * Recupere un debriefing d'une sortie aérienne.
	 * 
	 * @return debriefing sous forme String
	 */
	public String getDebriefing() {
		return debrief;
	}

	/**
	 * Recupere une liste d'evenement.
	 * 
	 * @return list sous forme de Liste
	 */
	public List<Evenement> getEvent() {
		return event;
	}

	/**
	 * Recupere une mission d'un vol.
	 * 
	 * @return mission sous forme de Mission
	 */
	public Mission getMission() {
		return mission;
	}

	/**
	 * @return 
	 */
	public Vol getVol(){
		return leVol;
	}
	/**
	 * Recupere un Equipage d'un vol.
	 * 
	 * @return equipage sous forme d'equipage
	 */
	public Equipage getEquipage() {
		return equipage;
	}

	/**
	 * Recupere une heure de decollage d'un vol.
	 * 
	 * @return heure sous forme GregorianCalendar
	 */
	public GregorianCalendar getDecolage() {
		return decolage;
	}

	/**
	 * Recupere une heure d'atterissage d'un vol.
	 * 
	 * @return heure sous forme GregorianCalendar
	 */
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
		this.event = event;
	}

	public void setEquipage(Equipage equipage) {
		if (equipage == null) {
			throw new RuntimeException("equipage null");
		} else {
			this.equipage = equipage;
		}
	}

	public void setDebriefing(String debrief) {
		if (debrief == null || debrief.trim().length() == 0) {
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
	
	private void setVol(Vol leVol2) {
		if(leVol2 == null)
			throw new RuntimeException("SortieAerienne[setVol] : le vol a initialiser ne peut être null");
		else
			this.leVol = leVol2;
	}

	private void setAtterissage(GregorianCalendar atterissage) {
		if (atterissage == null) {
			throw new RuntimeException("atterissage null");
		} else {
			this.atterissage = atterissage;
		}
	}

	private void setDecolage(GregorianCalendar decolage) {
		if (decolage == null) {
			throw new RuntimeException("decolage null");
		} else {
			this.decolage = decolage;
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arm == null) ? 0 : arm.hashCode());
		result = prime * result
				+ ((atterissage == null) ? 0 : atterissage.hashCode());
		result = prime * result + ((avion == null) ? 0 : avion.hashCode());
		result = prime * result + ((debrief == null) ? 0 : debrief.hashCode());
		result = prime * result
				+ ((decolage == null) ? 0 : decolage.hashCode());
		result = prime * result
				+ ((equipage == null) ? 0 : equipage.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((mission == null) ? 0 : mission.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortieAerienne other = (SortieAerienne) obj;
		if (arm == null) {
			if (other.arm != null)
				return false;
		} else if (!arm.equals(other.arm))
			return false;
		if (atterissage == null) {
			if (other.atterissage != null)
				return false;
		} else if (!atterissage.equals(other.atterissage))
			return false;
		if (avion == null) {
			if (other.avion != null)
				return false;
		} else if (!avion.equals(other.avion))
			return false;
		if (debrief == null) {
			if (other.debrief != null)
				return false;
		} else if (!debrief.equals(other.debrief))
			return false;
		if (decolage == null) {
			if (other.decolage != null)
				return false;
		} else if (!decolage.equals(other.decolage))
			return false;
		if (equipage == null) {
			if (other.equipage != null)
				return false;
		} else if (!equipage.equals(other.equipage))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (mission == null) {
			if (other.mission != null)
				return false;
		} else if (!mission.equals(other.mission))
			return false;
		return true;
	}
	
	
}
