package cindy.metier.vol;

import cindy.metier.comm.IEvenement;

/**
 * Classe Evenement. Classe permettant de gerer les evenements liés aux
 * sortiesAeriennes
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 25/07/2011
 */
public class Evenement implements IEvenement {

	/** nom de l'evenement */
	private String nomEvent;
	/** type de l'evenement */
	private String typeEvent;

	/**
	 * Constructeur de la classe Evenement. liste des paramètres:
	 * 
	 * @param nomEvent
	 *            sous forme de String
	 * @param typeEvent
	 *            sous forme de String
	 */
	public Evenement(String nomEvent, String typeEvent) {
		this.nomEvent = nomEvent;
		this.typeEvent = typeEvent;
	}

	// GETTERS
	/**
	 * Recupere le nom de l'evenement.
	 * 
	 * @return le nom de l'evenement sous forme de String
	 */
	public String getNomEvent() {
		return nomEvent;
	}

	/**
	 * Recupere le type de l'evenement.
	 * 
	 * @return le type de l'evenement sous forme de String
	 */
	public String getTypeEvent() {
		return typeEvent;
	}

	// SETTERS
	@SuppressWarnings("unused")
	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}

	@SuppressWarnings("unused")
	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}
}
