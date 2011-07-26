package cindy.metier.avion;

import cindy.metier.comm.IPiece;


public class Piece implements IPiece{

	//TODO: referencer des pi�ces bidon pour pouvoir diff�rencier le nombre
	//d'heures de vol de l'avion et celui des pi�ces
	
	//ATTRIBUT
	private String nom;
	private int nbHeureVol;
	//private enumPiece piece;
	
	//	constructeur
	/**
	 * constructeur de la classe par d�faut.
	 * Permet que le nom et le nombre d'heures
	 * de vol de la pi�ce ne soient pas pr�ciser
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
	 * getter qui retourne le nom de la pi�ce.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur.
	 * Retourne le nombre d'heures
	 * de vol de la pi�ce
	 * @return nbHeureVol
	 */
	public int getNbHeureVol() {
		return nbHeureVol;
	}

	/**
	 * Donne le nom de la pi�ce.
	 * @param nom
	 */
	public void setNom(String nom) {
			if(!nom.equals(null))
				this.nom =nom;
			throw new RuntimeException("Pi�ce : le nom de la pi�ce ne peut �tre null");
	}

	/**
	 * Donne le nombre d'heures de vol.
	 * Effectu�es par la pi�ce
	 * @param nbHeureVol
	 */
	public void setNbHeureVol(int nbHeureVol) {
			if(nbHeureVol >= 0)
				this.nbHeureVol = nbHeureVol;
			throw new RuntimeException("Piece : le nombre d'heure de vol d�clar� vaut 0");
	}
	
	///m�thode
	/**
	 * Permet d'ajouter des heures de vol � une piece
	 * @param nombre sous forme d'un entier
	 */
	public void ajouterHeureDeVol(int nombre){
			if(nombre > 0)
				nbHeureVol += nombre;
			throw new RuntimeException("Piece : impossible d'ajouter 0 heures de vol...ou moins");
	}
}
