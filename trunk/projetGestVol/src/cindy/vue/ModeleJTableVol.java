package cindy.vue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cindy.controleur.IControleur;
import cindy.metier.comm.IVol;


public class ModeleJTableVol extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1683885302458627679L;

	/** la liste des vols. */
	private List<IVol> listeVol;
	/** le controleur accedant au metier. */
	private IControleur controleur;
	/** le nom des colonnes. */
	private final String[] NOM_COLONES = {"IDVOL","CIRCULATION","CATEGORIE","DATE DECOLLAGE","DATE ATTERISSAGE","ANNULATION"};
	
	/**
	* Recupere l'acces au metier, puis chrage la liste.
	* @param ctl acces au metier
	*/
	public ModeleJTableVol(IControleur ctl){
		System.out.println("construct model");
	  controleur = ctl;
	  System.out.println("ctl ok");
	  listeVol=new ArrayList<IVol>();
	  initListe();
	  System.out.println("init ok");
	  for (IVol v : listeVol) {
		System.out.println(v.toString());
	}
	  System.out.println("sortie construct");
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
		System.out.println("entree dans getvalueat");
	    if (indexLig < 0 || indexLig >= listeVol.size() ) return "";
	    IVol vol = listeVol.get(indexLig);
	    System.out.println("testID:"+vol.getId());
	    switch(indexCol){
		 case 0:return vol.getId();
		 case 1:return vol.getCirculation();
		 case 2:return vol.getLaCategorie();
		 case 3:return vol.getDecollage().getTime();
		 case 4:return vol.getAtterrissage().getTime();
		 case 5:return vol.isAnnulation();	
		 
	    }
	    return "";
	}
	
	@Override
	public String getColumnName(int col){ 
	      return NOM_COLONES[col]; 
	   }

	private void initListe() {
	    try {
		   listeVol = controleur.getListeVols(); 
	    } catch(Exception e) {
		throw new RuntimeException("impossible d'obtenir la liste");
	    }
	  }
	
}

