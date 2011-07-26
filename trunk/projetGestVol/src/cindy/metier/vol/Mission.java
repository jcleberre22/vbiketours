package cindy.metier.vol;

import cindy.metier.comm.IMission;

/**
 * 
 * class: Mission.
 * Va permettre d'indique le type de mission
 * exerc�e par le vol ou lors d'une sortie a�rienne
 * @author J.Martinez 
 * @version 1.0 du 27/07/2011
 */
public class Mission implements IMission {

	// Attributs
	private String type;

	// Constructeur
	// par d�faut
	/**
	 * constructeur par d�faut. Accepte que le nom de la mission ne soit pas
	 * renseigner au pr�alable
	 */
	public Mission() {
		type = " ";
	}

	/**
	 * second constructeur. Celui-ci exige que le nom de la mission soit donn�
	 * 
	 * @param name
	 */
	public Mission(String type) {
		setType(type);
	}

	// Accesseurs
	/**
	 * @return le type de mission ( transport ou combat)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Fourni le nom de la mission. R�gle sp�cifiant qu'il est impossible de
	 * passer en param�tre une valeur nulle
	 * 
	 * @param nom sous forme de String
	 */
	private void setType(String nom) {
		if (nom == null || nom.trim().length() == 0){
			throw new RuntimeException("Mission : [valeur nulle] le nom de la mission doit �tre donn�");
		}
		this.type = nom;
	}

}
