package cindy.vue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cindy.controleur.IControleur;
import cindy.metier.comm.ICategorie;
import cindy.metier.comm.ICirculation;
import cindy.metier.comm.IVol;

/**
 * Modele de la JTable du vol.
 * @author jc.Leberre
 * @version 1.0 du 05/09/2011
 *
 */
public class ModeleJTableVol extends AbstractTableModel {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1683885302458627679L;

	/** la liste des vols. */
	private List<IVol> listeVol;
	/** le controleur accedant au metier. */
	private IControleur controleur;
	/** le nom des colonnes. */
	private final String[] NOM_COLONES = { "IDVOL", "CIRCULATION", "CATEGORIE",
			"DATE DECOLLAGE", "DATE ATTERISSAGE", "ANNULATION" };

	/**
	 * Recupere l'acces au metier, puis charge la liste.
	 * 
	 * @param ctl   acces au metier
	 */
	public ModeleJTableVol(IControleur ctl) {
		controleur = ctl;
		listeVol = new ArrayList<IVol>();
		initListe();
	}

	@Override
	public int getColumnCount() {
		return NOM_COLONES.length;
	}

	@Override
	public int getRowCount() {
		return listeVol.size();
	}

	@Override
	public Object getValueAt(int indexLig, int indexCol) {
		if (indexLig < 0 || indexLig >= listeVol.size())
			return "";
		IVol vol = listeVol.get(indexLig);
		switch (indexCol) {
		case 0:
			return " " + vol.getId();
		case 1:
			try {
				ICirculation circu=controleur.getListeCirculations().get(vol.getCirculation()-1);
				return circu.getLibelleCirculation();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 2:
			try {
				ICategorie cat = controleur.getListeCategories().get(vol.getLaCategorie()-1);
				return cat.getLibelleCategorie();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		case 3:
			return  vol.getDecollage().getTime();
		case 4:
			return  vol.getAtterrissage().getTime();
		case 5:
			if (!vol.isAnnulation()) {
				return "NON ANNULE";
			}else{
				return "VOL ANNULE";
			}
		}
		return "";
	}

	@Override
	public String getColumnName(int col) {
		return NOM_COLONES[col];
	}

	private void initListe() {
		try {
			listeVol = controleur.getListeVols();
		} catch (Exception e) {
			throw new RuntimeException("impossible d'obtenir la liste");
		}
	}

}
