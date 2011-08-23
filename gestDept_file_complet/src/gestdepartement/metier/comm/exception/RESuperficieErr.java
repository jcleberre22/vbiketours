package gestdepartement.metier.comm.exception;

public class RESuperficieErr extends RuntimeException {
	/** identifiant de serialisation. */
	private static final long serialVersionUID = 1L;
	
	/** le message par défaut de l'exception. */
	private static final String MESG_ERR = "La superficie d'un département est obligatoirement supérieur à 1 !!";
	
	/** code pour i18n. */
	public static final String CODE_ERREUR = "SUPERFICIE_INVALIDE";
	
	public RESuperficieErr() {
		super(MESG_ERR);
	}
}