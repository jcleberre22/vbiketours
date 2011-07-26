package cindy.metier.vol;


import java.util.List;

import cindy.metier.comm.ISortieAerienne;
import cindy.metier.comm.IVol;

/**
 * 
 *	Dans cette classe nous allons pouvoir d�clarer un vol.
 *	Appeler tous les renseignement dont il a besoin
 *	pour ajouter une sortie a�rienne � un vol
 *	il est � noter qu'un vol poss�de une liste de sorties
 *	a�riennes
 *
 */
public class Vol implements IVol{
	 //TODO: changer la liste des sorties en Sorties pour pouvoir ajouter la sortie au vol
	//attributs
	 private String reference;
	 private String circulation;
	 private int laCategorie;
	 private List<ISortieAerienne> lesSorties;
	 
	 //constructeur
	 /**
	  * constructeur de la classe.
	  * Celui-ci oblige � ce que tous les champs soit remplis
	  * @param reference
	  * @param circulation
	  * @param categorieDeVol
	  */
	public Vol(String reference,String circulation,int categorieDeVol){
		setReference(reference);
		setCirculation(circulation);
		setLaCategorie(categorieDeVol);
	 }
	 
	 /**
	  * Constructeur par d�faut.
	  * Celui-ci n'exige que la r�f�rence de l'avion
	  * les informations restante pourront suivre
	  * par la suite
	  * @param ref
	  */
	 public Vol(String ref){
		setReference(ref); 
	 }

	 //accesseurs
	 /**
	  * @return la reference de l'avion.
	  */
	public String getReference() {
		return reference;
	}

	/**
	 * @return la circulation choisie pour le vol.
	 */
	public String getCirculation() {
		return circulation;
	}
	
	
	/**
	 * @return la cat�gorie de vol
	 */
	public int getLaCategorie() {
		return laCategorie;
	}

	/**
	 * @return la liste des sorties a�riennes programm�es pour un vol
	 */
	public List<ISortieAerienne> getLesSorties() {
		return lesSorties;
	}

	/**
	 * fixe la cat�gorie du vol
	 * @param categorieDeVol
	 */
	private void setLaCategorie(int categorieDeVol) {
		this.laCategorie = categorieDeVol;
	}

	/**
	 * donne la liste des sorties aeriennes programm�es pour un vol
	 * @param lesSorties
	 */
	private void setLesSorties(List<ISortieAerienne> lesSorties) {
		this.lesSorties = lesSorties;
	}

	/**
	 * fourni la r�f�rence du vol.
	 * @param reference
	 */
	private void setReference(String reference) {
		if(reference == null)
			throw new RuntimeException("Vol : impossible de passer une r�f�rence null");
		this.reference = reference;
	}

	/**
	 * donne la circulation choisie pour le vol.
	 * @param circulation
	 */
	private void setCirculation(String circulation) {
		circulation = circulation.toLowerCase();
		if(circulation == null)
			throw new RuntimeException("Vol : le type de circulation doit �tre fourni");
		if(!circulation.equals("civile") && !circulation.equals("militaire"))
			throw new RuntimeException("Vol : il ne peut y avoir que deux types de circulation pour la sortie");
		this.circulation = circulation;
	}

	@Override
	public void ajouterCategorie(String nomCategorie) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ajoute une sortie aerienne au vol 
	 * @param laSortie
	 */
	public void ajouterSortieAerienne(ISortieAerienne laSortie) {
		laSortie = new SortieAerienne(laSortie.getAvion(),null,laSortie.getArm(),null,laSortie.getEquipage(),laSortie.getMission());
		if(laSortie == null)
			throw new RuntimeException("Vol : la sortie pass�e en param�tre est nulle");
		if(lesSorties.contains(laSortie))
			throw new RuntimeException("Vol : La sortie ne peut �tre ajout�e car elle existe d�j�");
		lesSorties.add(laSortie);
	}

	/**
	 * Cette m�thode va nous permettre de modifier la sortie a�rienne
	 * si l'utilisateur a modifi� les param�tres de la sortie
	 * on va comparer les objets de la sortie contenu dans la liste et
	 * celle pass� en param�tre pour effectuer les changements
	 * @param newSortie
	 */
	public void modifierSortieAerienne(SortieAerienne old,
			SortieAerienne newSortie) {
		old = new SortieAerienne(old.getAvion(),null,old.getArm(),null,old.getEquipage(),old.getMission());
		newSortie = new SortieAerienne(newSortie.getAvion(),null,newSortie.getArm(),null,newSortie.getEquipage(),newSortie.getMission());
		if(lesSorties.contains(old))
			old = newSortie;
	}	
	

	
	//methodes
	
	
}
