package cindy;

import java.sql.SQLException;

import cindy.controleur.Controleur;

/**
 * Classe Lanceur
 * Point de depart de l'application.
 * Instancie le controleur
 * @author JC
 * @version du 31/08/2011
 */

public class Lanceur {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, Exception {
		new Controleur();
	}

}
