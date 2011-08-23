package gestdepartement.metier.comm;

public interface IDepartementConsultable {
	/**
	 * @return le code du departement
	 */
	String getCode();
	/**
	 * @return le nom du departement.
	 */
	String getNom();
	/**
	 * @return le nombre d'habitant du departement.
	 */
	int getNombreHabitant();
	/**
	 * @return le nom de la region d'appartenance
	 * du departement.
	 */
	String getAppartenance();
	/**
	 * @return la superficie du departement.
	 */
	int getSuperficie();
	/**
	 * @return la densite du departement = nombre habitant / superficie
	 */
	float getDensite();
	
	
}
