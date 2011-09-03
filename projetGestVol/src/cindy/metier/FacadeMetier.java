package cindy.metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.avion.Armement;
import cindy.metier.avion.Avion;
import cindy.metier.comm.ICategorie;
import cindy.metier.comm.ICategoriePersistant;
import cindy.metier.comm.IVol;
import cindy.metier.comm.IVolPersistant;
import cindy.metier.personnel.Equipage;
import cindy.metier.vol.Evenement;
import cindy.metier.vol.Mission;
import cindy.metier.vol.SortieAerienne;
import cindy.metier.vol.Vol;
import cindy.persistance.DAOCategorie;
import cindy.persistance.DAOVol;
//FIXME javadoc
/**
 * Facade destin�e � acc�der aux diff�rentes parties du m�tier pour garantir une
 * meilleure s�curit� de l'application en couche
 * 
 * @author J.Martinez
 * @version 1.0 du 29/08/2011
 */
public class FacadeMetier {
	private IVol leVol;
	private List<IVol> listeVols;
	private List<ICategorie> listeCategories;
	// acces � la persistance
	private IVolPersistant volPersistant;
	private ICategoriePersistant categoriePersistant;

	
	// on obtient une instance naturelle
	public FacadeMetier() throws SQLException, Exception {
		volPersistant=new DAOVol();
		categoriePersistant=new DAOCategorie();
		listeVols = new ArrayList<IVol>();
		listeCategories = new ArrayList<ICategorie>();
		leVol = new Vol();
	}

	/**
	 * m�thode qui sert a cr�er un vol puis de l'ajouter � la liste des vol par
	 * l'appel de la m�thode ajouterVol()
	 * 
	 * @param circulation
	 * @param categorieDeVol
	 * @param dateDecollage
	 * @param dateAtterrissage
	 */
	public void creerVol(int reference, int circulation, int categorieDeVol,
			GregorianCalendar dateDecollage,
			GregorianCalendar dateAtterrissage, boolean annulation) {
		
		// ajout du vol cr��
		ajouterVol(new Vol(reference, circulation, categorieDeVol,
				dateDecollage, dateAtterrissage, annulation));
	}

	/**
	 * m�thode ajouter vol qui permet d'ajouter le vol � la liste des vols puis
	 * de cr�er ce vol dans la BDD
	 * 
	 * @param v
	 */
	public void ajouterVol(Vol v) {
		try {
			if (v != null) {
				if (!listeVols.contains(v)) {
					listeVols.add(v);
					try {
						volPersistant.insererPersistance(leVol.getId(),
								leVol.getCirculation(), leVol.getLaCategorie(),
								leVol.getDecollage(), leVol.getAtterrissage(),
								leVol.isAnnulation());
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					throw new RuntimeException(
							"FacadeMetier[ajouterVol] : le vol existe d�j�");
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"FacadeMetier[ajouterVol] : le vol � ajouter est null ou existe d�j�");
		}
	}

	/**
	 * cherche dans la liste si le vol � modifier existe, si c'est le cas il le
	 * remplace par le nouveau vol puis il fais de m�me au niveau de la BDD
	 * 
	 * @param ancien
	 * @param nouveau
	 */
	public void modifierVol(Vol ancien, Vol nouveau) {
		try {
			if (ancien != null && nouveau != null) {
				if (listeVols.contains(ancien)) {
					int index = listeVols.indexOf(ancien);
					listeVols.add(index, nouveau);
					try {
						volPersistant.modifierPersistance(nouveau.getId(),
								nouveau.getCirculation(),
								nouveau.getLaCategorie(),
								nouveau.getDecollage(),
								nouveau.getAtterrissage(),
								nouveau.isAnnulation());
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"FacadeMetier[modifierVol] : l'ancien ou le nouveau vol est null");
		}
	}

	/**
	 * recherche si le vol existe dans la liste puis le supprime
	 * 
	 * @param aSupprimer
	 */
	public void supprimerVol(Vol aSupprimer) {
		if (aSupprimer != null) {
			for (int i = 0; i < listeVols.size(); i++) {
				if (listeVols.contains(aSupprimer)) {
					listeVols.remove(aSupprimer);
				}
			}
			try {
				volPersistant.supprimerPersistance(aSupprimer);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * permet de r�cuperer la liste des vols
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public void lireVols() throws SQLException, Exception{
		listeVols=volPersistant.getListeVols();
	}
	
	public List<IVol> getListeVols() throws SQLException, Exception {
		lireVols();
		return listeVols;
	}

	/**
	 * permet de cr�er une sortie a�rienne et de l'ajouter a la liste des
	 * sorties
	 * 
	 * @param av
	 * @param deb
	 * @param arm
	 * @param ev
	 * @param eq
	 * @param m
	 * @param v
	 * @param dec
	 * @param att
	 */	
	public void creerSortieAerienne(Avion av, String deb, Armement arm,
			List<Evenement> ev, Equipage eq, Mission m, Vol v,
			GregorianCalendar dec, GregorianCalendar att) {
		ajouterSortieAerienne(new SortieAerienne(av, deb, arm, ev, eq, m, v,
				dec, att));
	}

	/**
	 * ajoute la sortie � la liste des sorties et cr��e la sortie dans la BDD
	 * 
	 * @param laSortie
	 */
	public void ajouterSortieAerienne(SortieAerienne laSortie) {
		try {
			if (laSortie != null)
				leVol.ajouterSortieAerienne(laSortie);
			// TODO : appeler la DAO pour ajouter la sortie aerienne a la BDD
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"FacadeMetier[ajouterSortieAerienne] : la sortie � ajouter ne peut �tre nulle");
		}
	}

	/**
	 * recherche si old existe et si c'est le cas le remplace par young puis
	 * appelle la DAO pour modifier la sortie dans la BDD
	 * 
	 * @param old
	 * @param young
	 */
	public void modifierSortieAerienne(SortieAerienne old, SortieAerienne young) {
		try {
			if (young != null) {
				if (leVol.getLesSorties().contains(old)) {
					leVol.modifierSortieAerienne(old, young);
					// TODO : appeler une DAO pour modifier la sortie
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"FacadeMetier[modifierSortieAerienne] : la nouvelle sortie ne peut �tre nulle");
		}
	}

	/**
	 * recherche dans la liste si la sortie � supprimer existe puis la supprime
	 * 
	 * @param aSupprimer
	 */
	public void supprimerSortieAerienne(SortieAerienne aSupprimer) {
		try {
			if (!leVol.getLesSorties().contains(aSupprimer)) {
				throw new RuntimeException(
						"FacadeMetier[supprimerSortieAerienne] : la sortie � supprimer n'existe pas");
			} else {
				if (aSupprimer != null) {
					leVol.supprimerSortieAerienne(aSupprimer);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"FacadeMetier[supprimerSortieAerienne]La sortie � supprimer est nulle");
		}
	}
	
	public List<ICategorie> getListeCategories() throws SQLException, Exception{
		lireCategories();
		return listeCategories;
		
	}

	private void lireCategories() throws SQLException, Exception {
		listeCategories=categoriePersistant.getListeCategories();
		
	}

	public static void main(String[] args) throws SQLException, Exception {
		new FacadeMetier();
	}
}
