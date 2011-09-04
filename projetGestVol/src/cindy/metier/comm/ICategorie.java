package cindy.metier.comm;

//FIXME remplacer "Avion" dans la javadoc vu que c pas une categorie d'avion mais de vol surement a faire dans d'autres classes vu que c'est du copier coller
/**
 * Interface permettant de r�cuperer des m�thodes de la classe Avion.
 * 
 * @author nicolas.tabuteaud
 * @version 1.0 du 25/07/2011
 */
public interface ICategorie {

	/**
	 * M�thode qui retourne la cat�gorie de l'avion. La cat�gorie est soit de
	 * chasse soit de transport.
	 * 
	 * @return la categorie de vol sous forme de String
	 */
	String getLibelleCategorie();

	/**
	 * M�thode qui retourne le num de la categorie.
	 * 
	 * @return le num de la categorie sous forme de String
	 */
	int getIdCategorie();
}
