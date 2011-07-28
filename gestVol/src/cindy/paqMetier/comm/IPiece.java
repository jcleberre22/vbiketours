package cindy.paqMetier.comm;

public interface IPiece {
	
	/**
	 * @return le nom de la piece
	 */
	String getNom();
	
	/**
	 * @return le nombre d'heure de vol de la pi�ce
	 */
	int getNbHeureVol();
	
	/**
	 * Permet d'ajouter des heures de vol � une piece
	 * @param nombre
	 */
	void ajouterHeureDeVol(int nombre);
}
