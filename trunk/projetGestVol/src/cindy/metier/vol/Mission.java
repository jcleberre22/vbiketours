package cindy.metier.vol;

/**
 * 
 * @author J.Martinez class: Mission. Va permettre d'indique le type de mission
 *         exerc�e par le vol ou lors d'une sortie a�rienne
 */
public class Mission {

	// Attributs
	private String type;
	@SuppressWarnings("unused")
	private String description;

	/**
	 * second constructeur. Celui-ci exige que le nom de la mission soit donn�
	 * 
	 * @param name
	 */
	public Mission(String type, String description) {
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
	 * Fourni le nom de la mission. R�gle sp�cifiant qu'il est impossible de
	 * passer en param�tre une valeur nulle
	 * 
	 * @param nom
	 */
	public void setType(String nom) {
		if (nom.equals(null) || nom.trim().length() == 0) {
			throw new RuntimeException(
					"Mission : [valeur nulle] le nom de la mission doit �tre donn�");
		} else {
			this.type = nom;
		}
	}

	public void setDescription(String description) {
		if (description == null || description.trim().length() == 0) {
			throw new RuntimeException("description null");
		} else {
			this.description = description;
		}
	}
}
