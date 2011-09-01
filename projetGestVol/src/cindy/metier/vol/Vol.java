package cindy.metier.vol;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import cindy.metier.comm.IVol;

/**
 * Dans cette classe nous allon vol possède une
 * liste de sorties aériennesns pouvoir déclarer un
 * vol. Appeler tous les renseignement dont il a besoin  ajouter
 * une sortie aérienne à un vol il est à noter qu'upour
 * @author J.Martinez
 * @version 1.0 du 26.07.2011 
 */
public class Vol implements IVol {
	// attributs
	private int id;
	private int circulation;
	private int laCategorie;
	private List<SortieAerienne> lesSorties;
	private GregorianCalendar decollage;
	private GregorianCalendar atterrissage;
	private boolean annulation;

	// constructeur
	/**
	 * constructeur de la classe. Celui-ci oblige à ce que tous les champs soit
	 * remplis
	 * @param circulation
	 * @param categorieDeVol
	 * @param laliste
	 * @param dateDecollage
	 * @param dateAtterrissage
	 */
	public Vol(int id,int circulation, int categorieDeVol, GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage,boolean annulation) {
		setId(id);
		setCirculation(circulation);
		setLaCategorie(categorieDeVol);
		setDecollage(dateDecollage);
		setAtterrissage(dateAtterrissage);
	}

	// constructeur
	/**
	 * constructeur de la classe. Celui-ci oblige à ce que tous les champs soit
	 * remplis
	 * 
	 * @param reference
	 * @param circulation
	 * @param categorieDeVol
	 */
	public Vol(int circulation, int categorieDeVol) {		
		setCirculation(circulation);
		setLaCategorie(categorieDeVol);
		setLesSorties(new ArrayList<SortieAerienne>());
	}

	public Vol() {
		circulation = 1;
		laCategorie  = 1;
		decollage = new GregorianCalendar(2011,05,20,8,30);
		atterrissage = new GregorianCalendar(2011, 05, 20, 15, 0);
	}

	// accesseurs
	public int getId(){
		return id;
	}
	

	/**
	 * @return la circulation choisie pour le vol.
	 */
	public int getCirculation() {
		return circulation;
	}

	/**
	 * @return la catégorie de vol
	 */
	public int getLaCategorie() {
		return laCategorie;
	}

	/**
	 * @return la date de decollage
	 */
	public GregorianCalendar getDecollage() {
		return decollage;
	}

	/**
	 * @return la date d'atterrissage
	 */
	public GregorianCalendar getAtterrissage() {
		return atterrissage;
	}
	
	/**
	 * @return la liste des sorties Aeriennes
	 */
	public List<SortieAerienne> getLesSorties(){
		return lesSorties;
	}
	
	public boolean isAnnulation() {
		return annulation;
	}
	
	/**
	 * initialise l'id du vol
	 * @param id2
	 */
	private void setId(int id2) {
		if(id2 < 0){
			throw new RuntimeException("Vol[setId] :'id ne peut être null");
		}
		else
			this.id = id2;
	}
	
	/**
	 * fixe la date de decollage
	 * 
	 * @param decollage
	 */
	public void setDecollage(GregorianCalendar decollage) {
		if (decollage == null) {
			throw new RuntimeException(
					"Vol : la date de decollage ne peut être null");
		} else
			this.decollage = decollage;
	}

	/**
	 * fixe la date d'atterrissage
	 * 
	 * @param atterrissage
	 */
	public void setAtterrissage(GregorianCalendar atterrissage) {
		if (atterrissage == null) {
			throw new RuntimeException(
					"Vol : la date d'atterrissage ne peut être null");
		} else
			this.atterrissage = atterrissage;
	}

	/**
	 * fixe la catégorie du vol
	 * 
	 * @param categorieDeVol
	 */
	private void setLaCategorie(int categorieDeVol) {
		if (categorieDeVol < 0)
			throw new RuntimeException(
					"les catégories de vol négatives ne sont pas acceptées");
		else
			this.laCategorie = categorieDeVol;
	}
	/**
	 * donne la circulation choisie pour le vol.
	 * 
	 * @param circulation
	 */
	private void setCirculation(int circulation) {
		try{
			if(circulation < 0)
				throw new RuntimeException("le nombre entré ne peut être inférieur à 0");
		}catch(Exception e){
			e.getMessage();
		}
		this.circulation = circulation;
	}
	
	/**
	 * initialise la variable d'annulation
	 * @param annulation
	 */
	public void setAnnulation(boolean annulation) {
		this.annulation = annulation;
	}
	
	/**
	 * permet d'initialiser la liste des sorties
	 * @param arrayList
	 */
	private void setLesSorties(ArrayList<SortieAerienne> arrayList) {
		if(arrayList == null)
			throw new RuntimeException("la sortie aerienne ne peut être nulle");
		else
			this.lesSorties = arrayList;		
	}


	@Override
	public void ajouterCategorie(String nomCategorie) {
		// TODO Auto-generated method stub

	}

	// methodes
	/**
	 * ajoute une sortie aerienne au vol
	 * 
	 * @param laSortie
	 */
	public void ajouterSortieAerienne(SortieAerienne laSortie) {
		if (laSortie == null)
			throw new RuntimeException(
					"la sortie passée en paramètre est nulle");
		if (lesSorties.contains(laSortie)) {
			throw new RuntimeException("Vol : la sortie existe déjà");
		}
		else
			lesSorties.add(laSortie);
	}

	/**
	 * Cette méthode va nous permettre de modifier la sortie aérienne si
	 * l'utilisateur a modifié les paramètres de la sortie on va comparer les
	 * objets de la sortie contenu dans la liste et celle passé en paramètre
	 * pour effectuer les changements
	 * 
	 * @param newSortie
	 */
	public void modifierSortieAerienne(SortieAerienne old,
			SortieAerienne newSortie) {
		if (old != null && newSortie != null) {
			if (lesSorties.contains(old)) {
				old = newSortie;
			} else
				throw new RuntimeException(
						"La sortie demandée n'est pas contenue dans la liste");
		} else {
			throw new RuntimeException(
					"l'ancienne ou la nouvelle sortie n'existe pas");
		}
	}

	/**
	 * supprime une sortie aerienne de la liste
	 * @param aSupprimer
	 */
	public void supprimerSortieAerienne(SortieAerienne aSupprimer) {
		if (aSupprimer == null)
			throw new RuntimeException(
					"Vol : la variable sortie aerienne à supprimer est null");
		if (lesSorties.contains(aSupprimer)) {
			lesSorties.remove(aSupprimer);
		} else
			throw new RuntimeException(
					"Vol : vous essayez de supprimer une sortie aerienne qui n'existe pas");
	}

	/**
	 * permet de consulter une sortie aerienne en fonction
	 * de la date sélectionnée
	 * @param debut
	 * @param fin
	 * @return
	 */
	public List<SortieAerienne> consulterSortieAerienne(
			GregorianCalendar debut, GregorianCalendar fin) {
		List<SortieAerienne> filtre = new ArrayList<SortieAerienne>();
		for (int i = 0; i < lesSorties.size(); i++) {
			if (lesSorties.get(i).getDecolage().after(debut)
					|| lesSorties.get(i).getAtterissage().before(fin)) {
				filtre.add(lesSorties.get(i));
			}
		}
		return filtre;
	}

	/**
	 * méthode compareTo qui compare l'atterrissage avec le paramètre
	 * @param arg0
	 * @return
	 */
	public int compareTo(GregorianCalendar arg0) {
		return atterrissage.compareTo(arg0);
	}

	public String toString() {
		Date d1=decollage.getTime();
		Date d2=atterrissage.getTime();
		String s="id: "+id+"\n" +"circulation: "+ circulation+"\n" +"categorieDeVol: "+laCategorie+"\n" +"dateDecollage: " +d1+"\n" +"dateAtterrissage: "+d2+"\n" +"annulation: " +annulation+"\n";
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atterrissage == null) ? 0 : atterrissage.hashCode());
		result = prime * result + circulation;
		result = prime * result
				+ ((decollage == null) ? 0 : decollage.hashCode());
		result = prime * result + laCategorie;
		result = prime * result
				+ ((lesSorties == null) ? 0 : lesSorties.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vol other = (Vol) obj;
		if (atterrissage == null) {
			if (other.atterrissage != null)
				return false;
		} else if (!atterrissage.equals(other.atterrissage))
			return false;
		if (circulation != other.circulation)
			return false;
		if (decollage == null) {
			if (other.decollage != null)
				return false;
		} else if (!decollage.equals(other.decollage))
			return false;
		if (laCategorie != other.laCategorie)
			return false;
		if (lesSorties == null) {
			if (other.lesSorties != null)
				return false;
		} else if (!lesSorties.equals(other.lesSorties))
			return false;
		return true;
	}

	@Override
	public String getReference() {
		
		return null;
	}

	
	
}
