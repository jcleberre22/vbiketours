package gestdepartement.persistance;


/**
 * Un client de lecture de fichier fic (windev hyperfile 5) et CSV.
 * Il s'adresse au lecteurFic, lui fournit le nom du fichier � lire
 * et se fait conna�tre en tant qu'exploitant des champs du fichier.
 * @author marc.leconte
 * @version 1.0
 */
public interface IClientLecture {
	/**
	 * Exploitation d'un enregistrement issue de la lecture d'un fichier csv.
	 * @param lesChamps tableau de chaine de caractere renseign� avec la valeur de chaque
	 * champs de la ligne du fichier lu
	 * @param numLigne numero de la ligne lu.
	 */
	void exploiteEnregistrement(String[] lesChamps, int numLigne);

	
}

