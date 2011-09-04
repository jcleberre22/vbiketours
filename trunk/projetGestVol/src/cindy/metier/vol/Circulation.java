package cindy.metier.vol;

import cindy.metier.comm.ICirculation;
//TODO Javadoc a refaire +ajouter test dans setters
/**
 * 
 * 
 * classe circulation. va référencer une catégorie de vol
 * 
 * @author J.Martinez
 * @version 1.0 du 27/07/2011
 */
public class Circulation implements ICirculation {



	// attributs
	int idCirculation;
	String libelleCirculation;
	
	public Circulation(){
		
	}

	// constructeur
	/**
	 * constructeur de la classe. Obligation d'avoir une circulation
	 */
	public Circulation(int idCirculation,String libelleCirculation) {
		setIdCirculation(idCirculation);
		setLibelleCirculation(libelleCirculation);
	}

	public int getIdCirculation() {
		return idCirculation;
	}


	public String getLibelleCirculation() {
		return libelleCirculation;
	}

	private void setLibelleCirculation(String libelleCirculation) {
		this.libelleCirculation=libelleCirculation;
	}

	private void setIdCirculation(int idCirculation) {
		this.idCirculation=idCirculation;
	}
}

