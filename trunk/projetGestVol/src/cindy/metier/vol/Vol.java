package cindy.metier.vol;


import java.util.List;

import cindy.metier.comm.ISortieAerienne;
import cindy.metier.comm.IVol;

/**
 * 
 *	Dans cette classe nous allons pouvoir déclarer un vol.
 *	Appeler tous les renseignement dont il a besoin
 *	pour ajouter une sortie aérienne à un vol
 *	il est à noter qu'un vol possède une liste de sorties
 *	aériennes
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
	  * Celui-ci oblige à ce que tous les champs soit remplis
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
	  * Constructeur par défaut.
	  * Celui-ci n'exige que la référence de l'avion
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
	 * @return la catégorie de vol
	 */
	public int getLaCategorie() {
		return laCategorie;
	}

	/**
	 * @return la liste des sorties aériennes programmées pour un vol
	 */
	public List<ISortieAerienne> getLesSorties() {
		return lesSorties;
	}

	/**
	 * fixe la catégorie du vol
	 * @param categorieDeVol
	 */
	private void setLaCategorie(int categorieDeVol) {
		this.laCategorie = categorieDeVol;
	}

	/**
	 * donne la liste des sorties aeriennes programmées pour un vol
	 * @param lesSorties
	 */
	private void setLesSorties(List<ISortieAerienne> lesSorties) {
		this.lesSorties = lesSorties;
	}

	/**
	 * fourni la référence du vol.
	 * @param reference
	 */
	private void setReference(String reference) {
		if(reference == null)
			throw new RuntimeException("Vol : impossible de passer une référence null");
		this.reference = reference;
	}

	/**
	 * donne la circulation choisie pour le vol.
	 * @param circulation
	 */
	private void setCirculation(String circulation) {
		circulation = circulation.toLowerCase();
		if(circulation == null)
			throw new RuntimeException("Vol : le type de circulation doit être fourni");
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
			throw new RuntimeException("Vol : la sortie passée en paramètre est nulle");
		if(lesSorties.contains(laSortie))
			throw new RuntimeException("Vol : La sortie ne peut être ajoutée car elle existe déjà");
		lesSorties.add(laSortie);
	}

	/**
	 * Cette méthode va nous permettre de modifier la sortie aérienne
	 * si l'utilisateur a modifié les paramètres de la sortie
	 * on va comparer les objets de la sortie contenu dans la liste et
	 * celle passé en paramètre pour effectuer les changements
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
