package cindy.metier.comm;

//FIXME remplacer "Avion" dans la javadoc vu que c pas une categorie d'avion mais de vol surement a faire dans d'autres classes vu que c'est du copier coller
/**
 * Interface permettant de récuperer des méthodes de la classe Avion.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface ICategorie {

	/**
	 * Méthode qui retourne la catégorie de l'avion. La catégorie est soit de
	 * chasse soit de transport.
	 * 
	 * @return la categorie de vol sous forme de String
	 */
	String getLibelleCategorie();

	/**
	 * Méthode qui retourne le num de la categorie.
	 * 
	 * @return le num de la categorie sous forme de String
	 */
	int getIdCategorie();
}
