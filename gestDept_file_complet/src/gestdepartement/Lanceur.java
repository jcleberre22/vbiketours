package gestdepartement;

import protocolreqrep.navigation.Contexte;

public class Lanceur {
	/**
	 * Les classes executables doivent
	 * avoir un constructeur privé.
	 */
	private Lanceur() {
	}
	/**
	 * point d'entrée du programme.
	 * @param args non utilises
	 */
	public static void main(String[] args) {
		Contexte.init();
	}
}
