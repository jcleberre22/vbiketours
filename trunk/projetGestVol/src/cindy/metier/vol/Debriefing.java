package cindy.metier.vol;

/**
 * 
 * class Debriefing : debriefing dans laquelle on pourra saisir le d�briefing
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
	 * constructeur par d�faut n'exclu pas le fait qu'il n'y ai pas de contenu
	 * au d�part
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
