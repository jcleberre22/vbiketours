package serveur;


import org.hsqldb.util.DatabaseManagerSwing;

/**
 * Acces au manager HSQL pour interrogation des tables en sql.
 * Permet de tester ses requêtes.
 * @author PIF
 * @version 1.0 du 21/07/2011
 */
public class Manager {
	public static void main(String[] args) {
		String[] info = {"--driver","org.hsqldb.jdbcDriver",
				"--url","jdbc:hsqldb:hsql://127.0.0.1",
				"--user","sa",
				"--password",""};

		DatabaseManagerSwing.main(info);
	}
}
