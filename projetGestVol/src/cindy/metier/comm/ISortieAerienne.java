package cindy.metier.comm;


import java.util.GregorianCalendar;
import java.util.List;
import cindy.metier.avion.Armement;
import cindy.metier.avion.Avion;
import cindy.metier.personnel.Equipage;
import cindy.metier.vol.Evenement;
import cindy.metier.vol.Mission;

/**
 * 
 * Interface permettant de récuperer des méthodes de la classe SortieAerienne.
 * 
 * @author JC.Leberre
 * @version 1.0 du 27/07/2011
 * 
 */
public interface ISortieAerienne {
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
	public void ajouterEvenement(Evenement ev);

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
	public void retirerEvenement(Evenement ev);

	/**
	 * Recupere un avion.
	 * 
	 * @return avion sous forme Avion
	 */
	public Avion getAvion();

	/**
	 * Recupere un armement d'un avion.
	 * 
	 * @return armement sous forme Armement
	 */
	public Armement getArm();

	/**
	 * Recupere un debriefing d'une sortie aérienne.
	 * 
	 * @return debriefing sous forme String
	 */
	public String getDebriefing();

	/**
	 * Recupere une liste d'evenement.
	 * 
	 * @return list sous forme de Liste
	 */
	public List<Evenement> getEvent();

	/**
	 * Recupere une mission d'un vol.
	 * 
	 * @return mission sous forme de Mission
	 */
	public Mission getMission();

	/**
	 * Recupere un Equipage d'un vol.
	 * 
	 * @return equipage sous forme d'equipage
	 */
	public Equipage getEquipage();

	/**
	 * Recupere une heure de decollage d'un vol.
	 * 
	 * @return heure sous forme Date
	 */
	public GregorianCalendar getDecolage();

	/**
	 * Recupere une heure d'atterissage d'un vol.
	 * 
	 * @return heure sous forme Date
	 */
	public GregorianCalendar getAtterissage();
}
