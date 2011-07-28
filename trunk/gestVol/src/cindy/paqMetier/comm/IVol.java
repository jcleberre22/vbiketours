package cindy.paqMetier.comm;

import java.util.List;

import cindy.paqMetier.vol.SortieAerienne;


public interface IVol {

	/**
	 * @return la réréfence du vol
	 */
	String getReference();
	
	/**
	 * @return la circulation adoptée pour le vol
	 */
	String getCirculation();	
	
	/**
	 * retourne la catégorie du vol
	 * @return
	 */
	int getLaCategorie();
	
	/**
	 * donne une catégorie au vol
	 * @param nomCategorie
	 */
	
	/**
	 * retourne la liste des sorties aériennes contenues dans un vol
	 * @return
	 */
	List<SortieAerienne> getLesSorties();
	
	/**
	 * donne la categorie du vol
	 * @param nomCategorie
	 */
	void ajouterCategorie(String nomCategorie);
	
	/**
	 * ajoute une sortie aerienne au vol
	 * 
	 * @param laSortie
	 */
	public void ajouterSortieAerienne(SortieAerienne laSortie);
	
	/**
	 * Cette méthode va nous permettre de modifier la sortie aérienne si
	 * l'utilisateur a modifié les paramètres de la sortie on va comparer les
	 * objets de la sortie contenu dans la liste et celle passé en paramètre
	 * pour effectuer les changements
	 * 
	 * @param newSortie
	 */
	public void modifierSortieAerienne(SortieAerienne old,
			SortieAerienne newSortie);
	
}
