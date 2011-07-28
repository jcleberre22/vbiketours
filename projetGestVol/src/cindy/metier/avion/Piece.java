package cindy.metier.avion;

import cindy.metier.comm.IPiece;

/**
 * class piece. Va nous donner le nom et le nombre d'heure des pieces d'un
 * avion. On pourra ajouter des heures à une piece d'un avion.
 * 
 * @author J.martinez
 * @version 1.0 du 27/07/2011
 **/
public class Piece implements IPiece {

	// ATTRIBUT
	/** nom de la piece */
	private String nom;
	/** heure de vol d'une piece */
	private int nbHeureVol;

	// constructeur
	/**
	 * constructeur de la classe par défaut. Permet que le nom et le nombre
	 * d'heures de vol de la pièce ne soient pas préciser
	 */
	public Piece() {
		nom = "";
		nbHeureVol = 0;
	}

	/**
	 * Constructeur. Exige que le nom et le nombre d'heure soient fournis
	 * 
	 * @param type
	 *            sous forme d'un String
	 * @param heure
	 *            sous forme d'un entier
	 */
	public Piece(String type, int heure) {
		setNom(type);
		setNbHeureVol(heure);
	}

	// accesseurs
	/**
	 * getter qui retourne le nom de la pièce.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur. Retourne le nombre d'heures de vol de la pièce.
	 * 
	 * @return nbHeureVol sous forme d'un entier
	 */
	public int getNbHeureVol() {
		return nbHeureVol;
	}

	/**
	 * Donne le nom de la pièce.
	 * 
	 * @param nom
	 *            sous forme de String
	 * @throws RuntimeException
	 *             en cas de non respect de la regle de gestion relative au nom
	 *             de la piece
	 */
	public void setNom(String nom) {
		if (nom.equals(null) || nom.trim().length() == 0) {
			throw new RuntimeException(
					"Pièce : le nom de la pièce ne peut être null");
		}
		this.nom = nom;
	}

	/**
	 * Donne le nombre d'heures de vol effectuées par la pièce.
	 * 
	 * @param nbHeureVol
	 *            sous forme d'entier
	 * @throws RuntimeException
	 *             en cas de non respect de la regle de gestion relative au
	 *             heure de vol d'une piece
	 */
	public void setNbHeureVol(int nbHeureVol) {
		if (nbHeureVol <= 0) {
			throw new RuntimeException(
					"Piece : le nombre d'heure de vol déclaré vaut 0");
		}
		this.nbHeureVol = nbHeureVol;
	}

	// /méthode
	/**
	 * Permet d'ajouter des heures de vol à une piece.
	 * 
	 * @param nombre
	 *            sous forme d'un entier
	 */
	public void ajouterHeureDeVol(int nombre) {
		if (nombre <= 0) {
			throw new RuntimeException(
					"Piece : impossible d'ajouter 0 heures de vol...ou moins");
		}
		this.nbHeureVol += nombre;
	}
}
