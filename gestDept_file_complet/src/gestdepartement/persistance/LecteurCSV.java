package gestdepartement.persistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Lecteur de fichier, specialise dans les fichiers csv. * ****
 * @author marc.leconte
 * @version 1.0
 */
public class LecteurCSV {
	/** acces au logger log4j.*/
	private static final Logger LELOGGER = Logger.getLogger(LecteurCSV.class);
	/** le client de la lecture. */
	private IClientLecture client;

	/** les enregistrements rejetés. */
	private List<String> enregistrementEchecs;

	/** le fichier a lire. */
	private FileReader fr;

	/** le nombre de ligne lues. */
	private int numLigne;

	/**
	 * Constructeur avec aggregation du client de la lecture.
	 * @param leClient qui va prendre a sa charge le tableau
	 * de chaine issue de la lecture d'une ligne.
	 */
	public LecteurCSV(IClientLecture leClient){
		client = leClient;
	}

	/**
	 * @return la liste des enregistrements en echecs.
	 */
	public List<String> getEnregistrementEchecs() {
		return enregistrementEchecs;
	}


	/**
	 * Lancement de la lecture en precisant le fichier a lire.
	 * @param leFichier contenant les informations a exploiter.
	 */
	public void lire(String leFichier){
		enregistrementEchecs = new ArrayList<String>();
		ouvrir(leFichier);
		traitementDuFlux();
		fermer();
	}

	/**
	 * Constitue le rapport de lecture sous la forme d'une chaine.
	 * @return une chaine contenant le rapport de lecture.
	 */
	public String rapporter(){
		if (numLigne == 0) {
			return "Aucune ligne lue";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("Nombre de ligne lues :").append(numLigne);
		sb.append("\nNombre de ligne en echecs : ").append(enregistrementEchecs.size());
		if (enregistrementEchecs.size() > 0){

			for (String string : enregistrementEchecs) {
				sb.append("\n").append(string);
			}
		}
		return sb.toString();
	}

	//METHODES PRIVEES
	/**
	 * Ouverture du file correspondant au fichier et 
	 * association a un filereader.
	 * @param leFichier
	 */
	private void ouvrir(String leFichier) {
		// Lecture fichier csv
		File f = new File(leFichier);
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			//tentative d'ouverture de façon relative au point d'exe
			URL is = new Object(){}.getClass().getClassLoader().getResource(leFichier);
			String nom = is.getFile();
			f = new File(nom);
			try {
				fr = new FileReader(f);
			} catch (FileNotFoundException e2) {
				throw new RuntimeException(traitementErreur(e2));
			}
		}
	}

	/**
	 * Ferme le fichier ouvert.
	 */
	private void fermer() {
		try {
			fr.close();
		} catch (IOException e) {
			LELOGGER.debug(traitementErreur(e));
		}
	}

	/**
	 * Traitement a effectuer sur chaque erreur.
	 * On reporte le message de l'erreur ainsi que le message de
	 *  la cause de l'erreur dans une chaine.
	 * @param erreur a traiter
	 * @return une chaine composée du message de l'erreur et 
	 * le cas echant du message de la cause.
	 */
	private String traitementErreur(Exception erreur) {
		String msg = erreur.getMessage();
		Throwable cause =  erreur.getCause();
		if (cause != null){
			msg += cause.getMessage();
		}
		return msg;
	}

	/**
	 * Boucle de lecture, chaque ligne lue est passée a la methode de 
	 * traitement de ligne.
	 */
	private void traitementDuFlux() {
		BufferedReader br = new BufferedReader(fr);
		String ligneLue;
		numLigne = 0;

		try {
			while ((ligneLue = br.readLine()) != null) {
				traitementLigne(ligneLue);
				numLigne++;
			}
		} catch (Exception e) {
			throw new RuntimeException(traitementErreur(e));
		}
	}

	/**
	 * Traitement d'une ligne lue.
	 * Ici on effectue un pré-traitement de ligne
	 * et on passe le résultat au client, avec le numero de ligne.
	 * Le client porra ainsi traiter ou non la premiere ligne 
	 * généralement entete de tableau.
	 * @param ligneLue la ligne lue a traiter
	 */
	private void traitementLigne(String ligneLue) {
		try{
			String[] tab = ligneLue.split("[;]");
			client.exploiteEnregistrement(tab, numLigne);
		} catch (Exception e){
			String echecs = String.format("%d %s %s", numLigne,ligneLue,traitementErreur(e));
			enregistrementEchecs.add(echecs);
		}
	}
}
