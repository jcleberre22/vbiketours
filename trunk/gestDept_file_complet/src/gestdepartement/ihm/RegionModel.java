package gestdepartement.ihm;


import gestdepartement.metier.comm.IUseCase;

import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 * Model de jtable basé sur l'AbstractTableModel.
 * Présent la liste des regions.
 * @author marc.leconte
 * @version 1.0
 */
class RegionModel extends AbstractTableModel {
	/** idt de serialisation.	 */ 
	private static final long serialVersionUID = -3294698162753647097L;
	/** la liste des éléments contenu. */
	private List<String> laListe;
	/** le controleur accedant au metier. */
	private IUseCase controleur;
	/** le nom des colonnes. */
	private final String[] NOM_COLONES = {"Nom Regions",};

	/**
	 * Recupere l'acces au metier, puis charge la liste.
	 * @param ctl acces au metier
	 */
	public RegionModel(IUseCase ctl){
		controleur = ctl;
		initListe();
	}

	public int getColumnCount() {
		return NOM_COLONES.length;
	}

	public int getRowCount() {
		return laListe.size();
	}



	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < 0 || rowIndex >= laListe.size() ) return "";

		String elt = laListe.get(rowIndex);
		switch(columnIndex){
		case 0:return elt.trim();
		
		}
		return "";
	}

	//redefinition supplémentaire
	public String getColumnName(int column) {
		String ret = "";
		if (column < NOM_COLONES.length) {
			ret = NOM_COLONES[column];
		}
		return ret;
	}
	//METHODES PRIVEES
	private void initListe() {
		try {
			laListe = controleur.listerRegion();
		} catch(Exception e) {
			throw new RuntimeException("impossible d'obtenir la liste");
		}
	}
}
