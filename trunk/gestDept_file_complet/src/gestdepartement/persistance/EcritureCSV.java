package gestdepartement.persistance;

import gestdepartement.metier.comm.IDepartementConsultable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
/*
 le bug provenait de la fermeture du filewriter en attribut au lieu du BufferedWriter
 le flush() du buffer n'etait donc pas effectif !!
*/
 
public class EcritureCSV {
	private static final Logger LELOGGER = Logger.getLogger(LecteurCSV.class);
	
	//private FileWriter fr;
	private BufferedWriter leFlux;//FIXME le buffer est ici
	private int numLigne;
	
	public EcritureCSV(){
	}
	
	public void ecrire(String leFichier, List<IDepartementConsultable> listDep) {
		ouvrir(leFichier);
		ecrireDonnees(listDep);
		fermer();
	}
	
	public String rapporter(){
		if (numLigne == 0) {
			return "Aucune ligne ecrite";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("Nombre de ligne ecrites :").append(numLigne);
		return sb.toString();
	}
	
	private void ouvrir(String leFichier) {
		// Lecture fichier csv
		File f = new File(leFichier);
		try {
			FileWriter fr = new FileWriter(f);
			leFlux = new BufferedWriter(fr);
		} catch (IOException e) {
			//tentative d'ouverture de façon relative au point d'exe
			URL is = new Object(){}.getClass().getClassLoader().getResource(leFichier);
			String nom = is.getFile();
			f = new File(nom);
			try {
				FileWriter  fr = new FileWriter(f);
				leFlux = new BufferedWriter(fr);
			} catch (IOException e2) {
				throw new RuntimeException(traitementErreur(e2));
			}
		}
	}

	/**
	 * Ferme le fichier ouvert.
	 */
	private void fermer() {
		try {
			leFlux.flush();//FIXME 
			leFlux.close();
		} catch (IOException e) {
			LELOGGER.debug(traitementErreur(e));
		}
	}
	
	private String traitementErreur(Exception erreur) {
		String msg = erreur.getMessage();
		Throwable cause =  erreur.getCause();
		if (cause != null){
			msg += cause.getMessage();
		}
		return msg;
	}
	

	
	/**
	 * Ecriture des lignes des données sur les départements
	 * 
	 */
	private void ecrireDonnees(List<IDepartementConsultable> listDep) {
		Iterator<IDepartementConsultable> it = listDep.iterator();
		
		
		try{
			leFlux.write ("Département;Population légale de 2008;Superficie (km²);Numéro de département;region");
			leFlux.newLine();
			while(it.hasNext()) {
				IDepartementConsultable departement = it.next();
				String ligne =String.format("%s;%d;%d;%s;%s", departement.getNom(),
						departement.getNombreHabitant(),departement.getSuperficie(),
						departement.getCode(),departement.getAppartenance());
				
				LELOGGER.debug(ligne);
				leFlux.write (ligne);
				leFlux.newLine();
				numLigne++;
			}
		} catch (Exception e){
			LELOGGER.error(e.getMessage());
		}
	}
}
