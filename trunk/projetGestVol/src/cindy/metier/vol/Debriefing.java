package cindy.metier.vol;

/**
 * 
 * class Debriefing : debriefing dans laquelle on pourra saisir le débriefing
 * d'une mission qui sera contenu dans une String
 * 
 * @author J.Martinez
 * @version 1.0 du 27/07/2011
 */
public class Debriefing {

	// Attributs
	String contenu;

	// Constructeur
	/**
	 * constructeur par défaut n'exclu pas le fait qu'il n'y ai pas de contenu
	 * au départ
	 */
	public Debriefing() {
		contenu = " ";
	}

	// Accesseurs
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
