package gestdepartement.metier.comm.exception;

public class RENombreHabErr extends RuntimeException {
	/** identifiant de serialisation. */
	private static final long serialVersionUID = 1L;
	
	/** le message par défaut de l'exception. */
	private static final String MESG_ERR = "Le nombre d'habitant doit être supérieur à 0 !!";
	
	/** code pour i18n. */
	public static final String CODE_ERREUR = "NB_HAB_INVALIDE";
	
	public RENombreHabErr() {
		super(MESG_ERR);
	}

}
