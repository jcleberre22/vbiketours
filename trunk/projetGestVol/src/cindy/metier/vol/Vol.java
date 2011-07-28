package cindy.metier.vol;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.comm.IVol;

/**
 * @author J.Martinez
 * @version 1.0 du 26.07.2011 Dans cette classe nous allons pouvoir d�clarer un
 *          vol. Appeler tous les renseignement dont il a besoin pour ajouter
 *          une sortie a�rienne � un vol il est � noter qu'un vol poss�de une
 *          liste de sorties a�riennes
 */
public class Vol implements IVol {
	// attributs
	private String reference;
	private String circulation;
	private int laCategorie;
	private List<SortieAerienne> lesSorties;
	private GregorianCalendar decollage;
	private GregorianCalendar atterrissage;

	// constructeur
	/**
	 * constructeur de la classe. Celui-ci oblige � ce que tous les champs soit
	 * remplis
	 * 
	 * @param reference
	 * @param circulation
	 * @param categorieDeVol
	 * @param laliste
	 * @param dateDecollage
	 * @param dateAtterrissage
	 */
	public Vol(String reference, String circulation, int categorieDeVol,
			List<SortieAerienne> laliste, GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage) {
		setReference(reference);
		setCirculation(circulation);
		setLaCategorie(categorieDeVol);
		setLesSorties(laliste);
		setDecollage(dateDecollage);
		setAtterrissage(dateAtterrissage);
	}

	// constructeur
	/**
	 * constructeur de la classe. Celui-ci oblige � ce que tous les champs soit
	 * remplis
	 * 
	 * @param reference
	 * @param circulation
	 * @param categorieDeVol
	 */
	public Vol(String reference, String circulation, int categorieDeVol) {
		setReference(reference);
		setCirculation(circulation);
		setLaCategorie(categorieDeVol);
		setLesSorties(new ArrayList<SortieAerienne>());
	}

	// accesseurs
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
	public List<SortieAerienne> getLesSorties() {
		return lesSorties;
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
	 * fixe la date de decollage
	 * 
	 * @param decollage
	 */
	public void setDecollage(GregorianCalendar decollage) {
		if (decollage == null) {
			throw new RuntimeException(
					"Vol : la date de decollage ne peut �tre null");
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
					"Vol : la date d'atterrissage ne peut �tre null");
		} else
			this.atterrissage = atterrissage;
	}

	/**
	 * fixe la cat�gorie du vol
	 * 
	 * @param categorieDeVol
	 */
	private void setLaCategorie(int categorieDeVol) {
		if (categorieDeVol < 0)
			throw new RuntimeException(
					"les cat�gories de vol n�gatives ne sont pas accept�es");
		this.laCategorie = categorieDeVol;
	}

	/**
	 * donne la liste des sorties aeriennes programm�es pour un vol
	 * 
	 * @param lesSorties
	 */
	private void setLesSorties(List<SortieAerienne> lesSorties) {
		this.lesSorties = lesSorties;
	}

	/**
	 * fourni la r�f�rence du vol.
	 * 
	 * @param reference
	 */
	private void setReference(String reference) {
		if (reference == null || reference.trim().length() <= 0)
			throw new RuntimeException(
					"Vol : impossible de passer une r�f�rence null");
		this.reference = reference;
	}

	/**
	 * donne la circulation choisie pour le vol.
	 * 
	 * @param circulation
	 */
	private void setCirculation(String circulation) {
		circulation = circulation.toLowerCase();
		if (circulation == null || circulation.trim().length() <= 0)
			throw new RuntimeException(
					"Vol : le type de circulation doit �tre fourni");
		if (!circulation.equals("civile") && !circulation.equals("militaire"))
			throw new RuntimeException(
					"Vol : il ne peut y avoir que deux types de circulation pour la sortie");
		this.circulation = circulation;
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
					"la sortie pass�e en param�tre est nulle");
		if (lesSorties.contains(laSortie)) {
			throw new RuntimeException("Vol : la sortie existe d�j�");
		}
		lesSorties.add(laSortie);
	}

	/**
	 * Cette m�thode va nous permettre de modifier la sortie a�rienne si
	 * l'utilisateur a modifi� les param�tres de la sortie on va comparer les
	 * objets de la sortie contenu dans la liste et celle pass� en param�tre
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
						"La sortie demand�e n'est pas contenue dans la liste");
		} else {
			throw new RuntimeException(
					"l'ancienne ou la nouvelle sortie n'existe pas");
		}
	}

	public void supprimerSortieAerienne(SortieAerienne aSupprimer) {
		if (aSupprimer == null)
			throw new RuntimeException(
					"Vol : la variable sortie aerienne � supprimer est null");
		if (lesSorties.contains(aSupprimer)) {
			lesSorties.remove(aSupprimer);
		} else
			throw new RuntimeException(
					"Vol : vous essayez de supprimer une sortie aerienne qui n'existe pas");
	}

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

	public int compareTo(GregorianCalendar arg0) {
		return atterrissage.compareTo(arg0);
	}

}
