package cindy.metier.avion;

import cindy.metier.comm.IPiece;


public class Piece implements IPiece{

	//TODO: referencer des pièces bidon pour pouvoir différencier le nombre
	//d'heures de vol de l'avion et celui des pièces
	
	//ATTRIBUT
	private String nom;
	private int nbHeureVol;
	//private enumPiece piece;
	
	//	constructeur
	/**
	 * constructeur de la classe par défaut.
	 * Permet que le nom et le nombre d'heures
	 * de vol de la pièce ne soient pas préciser
	 */
	public Piece(){
		nom = "";
		nbHeureVol = 0;
	}
	
	/**
	 * Constructeur. 
	 * exige que le nom et le nombre d'heure soient fournis
	 * @param type
	 * @param heure
	 */
	public Piece(String type,int heure){
		setNom(type);
		setNbHeureVol(heure);
	}

	//accesseurs
	/**
	 * getter qui retourne le nom de la pièce.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur.
	 * Retourne le nombre d'heures
	 * de vol de la pièce
	 * @return nbHeureVol
	 */
	public int getNbHeureVol() {
		return nbHeureVol;
	}

	/**
	 * Donne le nom de la pièce.
	 * @param nom
	 */
	public void setNom(String nom) {
			if(!nom.equals(null))
				this.nom =nom;
			throw new RuntimeException("Pièce : le nom de la pièce ne peut être null");
	}

	/**
	 * Donne le nombre d'heures de vol.
	 * Effectuées par la pièce
	 * @param nbHeureVol
	 */
	public void setNbHeureVol(int nbHeureVol) {
			if(nbHeureVol >= 0)
				this.nbHeureVol = nbHeureVol;
			throw new RuntimeException("Piece : le nombre d'heure de vol déclaré vaut 0");
	}
	
	///méthode
	/**
	 * Permet d'ajouter des heures de vol à une piece
	 * @param nombre sous forme d'un entier
	 */
	public void ajouterHeureDeVol(int nombre){
			if(nombre > 0)
				nbHeureVol += nombre;
			throw new RuntimeException("Piece : impossible d'ajouter 0 heures de vol...ou moins");
	}
}
