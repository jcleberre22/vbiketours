package cindy.paqMetier.vol;

/**
 * 
 * @author J.Martinez class: Mission. Va permettre d'indique le type de mission
 *         exercée par le vol ou lors d'une sortie aérienne
 */
public class Mission {

	// Attributs
	private String type;
	private String description;

	//FIXME constructeur autorisé?
	// Constructeur
	// par défaut
//	/**
//	 * constructeur par défaut. accepte que le nom de la mission ne soit pas
//	 * renseigner au préalable
//	 */
//	public Mission() {
//		type = " ";
//	}

	/**
	 * second constructeur. Celui-ci exige que le nom de la mission soit donné
	 * 
	 * @param name
	 */
	public Mission(String type,String description) {
		setType(type);
		setDescription(description);
	}

	// Accesseurs
	/**
	 * @return le type de mission ( transport ou combat)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Fourni le nom de la mission. Règle spécifiant qu'il est impossible de
	 * passer en paramètre une valeur nulle
	 * 
	 * @param nom
	 */
	public void setType(String nom) {
		if (nom.equals(null)) {
			throw new RuntimeException(
					"Mission : [valeur nulle] le nom de la mission doit être donné");
		} else {
			this.type = nom;
		}
	}

	public void setDescription(String description) {
		if (description==null) {
			throw new RuntimeException("description null");
		}else {
			this.description=description;
		}
	}
}
