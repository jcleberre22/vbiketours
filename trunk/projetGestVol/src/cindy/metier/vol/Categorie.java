package cindy.metier.vol;

import cindy.metier.comm.ICategorie;
//TODO Javadoc a refaire +ajouter test dans setters
/**
 * 
 * 
 * classe categorie. va référencer une catégorie de vol
 * 
 * @author J.Martinez
 * @version 1.0 du 27/07/2011
 */
public class Categorie implements ICategorie {



	// attributs
	int idCategorie;
	String libelleCategorie;
	
	public Categorie(){
		
	}

	// constructeur
	/**
	 * constructeur de la classe. Obligation d'avoir une categorie
	 */
	public Categorie(int idCategorie,String libelleCategorie) {
		setIdCategorie(idCategorie);
		setLibelleCategorie(libelleCategorie);
	}

	public int getIdCategorie() {
		return idCategorie;
	}


	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	private void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie=libelleCategorie;
	}

	private void setIdCategorie(int idCategorie) {
		this.idCategorie=idCategorie;
	}
}
