package cindy.paqMetier.vol;

import cindy.paqMetier.comm.IDate;

/**
 * Classe Date. Classe permettant de creer des dates et de pouvoir les
 * conservées
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 25/07/2011
 */
public class Date implements IDate {
	private String jour;
	private String mois;
	private String annee;
	private String heure;
	private String minutes;
	private String secondes;

	/**
	 * Constructeur de la classe Date. liste des paramètres:
	 * 
	 * @param jour
	 * @param mois
	 * @param annee
	 * @param heure
	 * @param minutes
	 * @param secondes
	 */
	public Date(String jour, String mois, String annee, String heure,
			String minutes, String secondes) {
		setJour(jour);
		setMois(mois);
		setAnnee(annee);
		setHeure(heure);
		setMinutes(minutes);
		setSecondes(secondes);
	}

	/**
	 * Permet de recuperer la date
	 * 
	 * @return la date au format jj/mm/aaaa
	 */
	public String obtenirDate() {
		String date = jour + "/" + mois + "/" + annee;
		return date;
	}

	/**
	 * Permet de recuperer l'heure complete
	 * 
	 * @return l'heure au format hh:mm:ss
	 */
	public String obtenirHeureComplete() {
		String heureComplete = heure + ":" + minutes + ":" + secondes;
		return heureComplete;
	}

	// GETTERS PUBLIQUES
	public String getJour() {
		return jour;
	}

	public String getMois() {
		return mois;
	}

	public String getAnnee() {
		return annee;
	}

	public String getHeure() {
		return heure;
	}

	public String getMinutes() {
		return minutes;
	}

	public String getSecondes() {
		return secondes;
	}

	// SETTERS PRIVES

	public void setJour(String jour) {
		int j=Integer.parseInt(jour);
		if (jour == null) {
			throw new RuntimeException("jour null");
		} else if(j<=31 && j>0){
			this.jour = jour;
		}else{
			throw new RuntimeException("jour incorrect");
		}
	}

	public void setMois(String mois) {
		int m=Integer.parseInt(mois);
		if (mois == null) {
			throw new RuntimeException("mois null");
		} else if(m<=12 && m>0){
			this.mois=mois;
		}else {
			throw new RuntimeException("mois incorrect");
		}
	}

	public void setAnnee(String annee) {
		int an=Integer.parseInt(annee);
		if (annee == null) {
			throw new RuntimeException("annee null");
		} else if(an<1950 && an>9999){
			this.annee=annee;
		}
		this.annee = annee;
	}

	public void setHeure(String heure) {
		int h=Integer.parseInt(heure);
		if (heure == null) {
			throw new RuntimeException("heure null");
		} else if(h<=12 && h>=0){
			this.heure=heure;
		}else{
			throw new RuntimeException("heure incorrecte");
		}
		
	}

	public void setMinutes(String minutes) {
		int min=Integer.parseInt(minutes);
		if (minutes == null) {
			throw new RuntimeException("minutes null");
		} else if(min<60 && min>=0){
			this.minutes = minutes;
		}else{
			throw new RuntimeException("minutes incorrectes");
		}
	}

	public void setSecondes(String secondes) {
		int sec=Integer.parseInt(secondes);
		if (secondes == null) {
			throw new RuntimeException("secondes null");
		} else if(sec<60 && sec>=0){
			this.secondes = secondes;
		}else{
			throw new RuntimeException("secondes incorrect");
		}
	}

}