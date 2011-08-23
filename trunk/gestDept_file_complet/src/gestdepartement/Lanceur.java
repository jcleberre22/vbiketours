package gestdepartement;

import protocolreqrep.navigation.Contexte;

public class Lanceur {
	/**
	 * Les classes executables doivent
	 * avoir un constructeur priv�.
	 */
	private Lanceur() {
	}
	/**
	 * point d'entr�e du programme.
	 * @param args non utilises
	 */
	public static void main(String[] args) {
		Contexte.init();
	}
}
