package gestdepartement.persistance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import gestdepartement.metier.comm.IPaysPersistant;
import gestdepartement.metier.comm.IPersistance;

public class DAOFicRegion implements IPersistance ,IClientLecture{
	private static final Logger LOG = Logger.getLogger(DAOFicRegion.class);
	/** le conteneur de region. */
	private IPaysPersistant conteneur;
	/** les regions lues. */
	private List<String> regionLues;
	
	/**
	 * On instancie la liste.
	 */
	public DAOFicRegion(){
		regionLues = new ArrayList<String>();
	}
	
	public void lireTous(Object cont) {
		exploiteConteneur(cont);
		LecteurCSV lecteur = new LecteurCSV(this);
		lecteur.lire("persistanceFile.csv");
		LOG.debug(lecteur.rapporter());
		LOG.debug("region(s) ajoutée(s) "+regionLues.size());
	}

	/**
	 * Le lecteur de csv fait appel a la methode suivante pour
	 * chaque ligne lues.
	 */
	public void exploiteEnregistrement(String[] lesChamps, int numLigne) {
		if (numLigne == 0){//on saute la premier ligne
			return;
		}
		if (regionLues.contains(lesChamps[4])==false){
			conteneur.ajouterRegion(lesChamps[4]);
			regionLues.add(lesChamps[4]);
			LOG.debug(lesChamps[4]);
		}
	}
	
	//METHODES PRIVEES
	private void exploiteConteneur(Object cont) {
		if (cont instanceof IPaysPersistant == false){
			throw new RuntimeException ("la persistance de la region ne sait travailler qu'avec un IPaysPersistant");
		}
		conteneur = (IPaysPersistant) cont;
	}

	@Override
	public void quitter(Object conteneur) {
		//rien a faire ici
		//le traitement sera realisé au niveau du DAOFicDepartement
	}

	@Override
	public void insererRegionPersistance(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierRegionPersistance(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerRegionPersistance(Object obj) throws SQLException,
			Exception {
		// TODO Auto-generated method stub
		
	}
}
