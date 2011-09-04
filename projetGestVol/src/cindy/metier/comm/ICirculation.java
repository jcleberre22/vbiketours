package cindy.metier.comm;


/**
 * Interface permettant de r�cuperer des m�thodes de la classe Avion.
 * 
 * @author jc.leberre
 * @version 1.0 du 03/09/2011
 */
public interface ICirculation {

	/**
	 * M�thode qui retourne la circulation de l'avion. La circulation est soit de
	 * chasse soit de transport.
	 * 
	 * @return la circulation de vol sous forme de String
	 */
	String getLibelleCirculation();

	/**
	 * M�thode qui retourne le num de la circulation.
	 * 
	 * @return le num de la circulation sous forme de String
	 */
	int getIdCirculation();
}
