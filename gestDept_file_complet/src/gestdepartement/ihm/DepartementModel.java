package gestdepartement.ihm;


import gestdepartement.metier.comm.IUseCase;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 * Model de jtable basé sur l'AbstractTableModel.
 * Présent la liste des departements.
 * @author marc.leconte
 * @version 1.0
 */
class DepartementModel extends AbstractTableModel {
	/** idt de serialisation.	 */ 
	private static final long serialVersionUID = -3294698162753647097L;
	/** la liste des éléments contenu. */
	private List<String> laListe;
	/** le controleur accedant au metier. */
	private IUseCase controleur;
	/** le nom des colonnes. */
	private final String[] NOM_COLONES = {"Code","Département","Population","Superficie","Densité"};
	/** la region presentée. */
	private String nomRegion;
	
	/**
	 * Recupere l'acces au metier, puis charge la liste.
	 * @param ctl acces au metier
	 */
	public DepartementModel(IUseCase ctl,String nomReg){
		nomRegion = nomReg;
		controleur = ctl;
		initListe();
	}
	
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
		initListe();
		fireTableDataChanged();
	}
	
	public int getColumnCount() {
		return NOM_COLONES.length;
	}

	public int getRowCount() {
		return laListe.size();
	}

	/*
 sb.append(code).append(";");
		sb.append(nom).append(";");
		sb.append(nombreHabitant).append(";");
		sb.append(superficie).append(";");
		sb.append(getDensite()).append(";");
	 */

	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < 0 || rowIndex >= laListe.size() ) return "";

		String elt = laListe.get(rowIndex);
		String[] info = elt.split(";");
		return info[columnIndex];
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
		if (nomRegion == null){
			laListe = new ArrayList<String>();
			return;
		}
		try {
			laListe = controleur.listerDepartement(nomRegion);
		} catch(Exception e) {
			laListe = new ArrayList<String>();
		}
	}

	
}
