package cindy.paqMetier.comm;

import java.util.List;

import cindy.paqMetier.vol.SortieAerienne;


public interface IVol {

	/**
	 * @return la r�r�fence du vol
	 */
	String getReference();
	
	/**
	 * @return la circulation adopt�e pour le vol
	 */
	String getCirculation();	
	
	/**
	 * retourne la cat�gorie du vol
	 * @return
	 */
	int getLaCategorie();
	
	/**
	 * donne une cat�gorie au vol
	 * @param nomCategorie
	 */
	
	/**
	 * retourne la liste des sorties a�riennes contenues dans un vol
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
	 * Cette m�thode va nous permettre de modifier la sortie a�rienne si
	 * l'utilisateur a modifi� les param�tres de la sortie on va comparer les
	 * objets de la sortie contenu dans la liste et celle pass� en param�tre
	 * pour effectuer les changements
	 * 
	 * @param newSortie
	 */
	public void modifierSortieAerienne(SortieAerienne old,
			SortieAerienne newSortie);
	
}
