package gestdepartement.persistance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import gestdepartement.metier.comm.IDepartementConsultable;
import gestdepartement.metier.comm.IPaysPersistant;
import gestdepartement.metier.comm.IPersistance;
/**
 * Deuxieme lecture du fichier en vue d'exploiter les
 * enregistrement de departements. 
 * @author marc.leconte
 * @version 1.0 du 14/06/2011
 */
public class DAOFicDepartement implements IPersistance, IClientLecture {
	/** acces au logger. */
	private static final Logger LOG = Logger.getLogger(DAOFicDepartement.class);
	private static final String NOM_FICHIER = "persistanceFile.csv";
	/** le conteneur de departement 
	 * (indirectement on peut ajouter un departement a
	 *  une region en s'adressant au pays).
	 */
	private IPaysPersistant conteneur;

	public void lireTous(Object cont) {
		exploiteConteneur(cont);
		LecteurCSV lecteur = new LecteurCSV(this);
		lecteur.lire(NOM_FICHIER);
		LOG.debug(lecteur.rapporter());
	}


	public void exploiteEnregistrement(String[] lesChamps, int numLigne) {
		if (numLigne == 0){//on saute la premier ligne
			return;
		}
		int nombreHabitant = Integer.parseInt(lesChamps[1]);
		int superficie = Integer.parseInt(lesChamps[2]);
		conteneur.ajouterDepartement(lesChamps[4],
				lesChamps[3], lesChamps[0], nombreHabitant, superficie);
	}
	/**
	 * On ecrit le fichier correspondant a l'etat du metier.
	 * Département;Population légale de 2008;Superficie (km²);Numéro de département;region
	 */
	public void quitter(Object cont) {
		exploiteConteneur(cont);
		FileWriter fw = ouvrir(NOM_FICHIER);
		BufferedWriter bw = new BufferedWriter(fw);
		String entete = "Département;Population légale de 2008;Superficie (km²);Numéro de département;region";
		ecrire(bw,entete);
		List<IDepartementConsultable> lst = conteneur.listerDepartementsCons();
		for (IDepartementConsultable departement : lst) {

			String ligne =String.format("%s;%d;%d;%s;%s", departement.getNom(),
					departement.getNombreHabitant(),departement.getSuperficie(),
					departement.getCode(),departement.getAppartenance());
			ecrire(bw,ligne);
			
		}
		fermer(bw);
	}

	//METHODES PRIVEES
	private void exploiteConteneur(Object cont) {
		if (cont instanceof IPaysPersistant == false){
			throw new RuntimeException ("la persistance des regions ne sait travailler qu'avec un IPaysPersistant");
		}
		conteneur = (IPaysPersistant) cont;
	}
	private void ecrire(BufferedWriter bw, String ligne) {
		try {
			bw.write(ligne);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Probleme a l'ecriture de la ligne !! "+ligne+
					" erreur :"+e.getMessage());
		}
	}
	private void fermer(BufferedWriter bw) {
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Probleme a la fermeture du fichier!! "+e.getMessage());
		}		
	}


	private FileWriter ouvrir(String leFichier) {
		File f = new File(leFichier);
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			return fw;
		} catch (Exception e) {
			throw new RuntimeException("impossible d'ouvrir le fichier "+leFichier+ " erreur:"+e.getMessage());
		}
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
