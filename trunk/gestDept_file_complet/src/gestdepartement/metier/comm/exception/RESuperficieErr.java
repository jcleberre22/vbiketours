package gestdepartement.metier.comm.exception;

public class RESuperficieErr extends RuntimeException {
	/** identifiant de serialisation. */
	private static final long serialVersionUID = 1L;
	
	/** le message par d�faut de l'exception. */
	private static final String MESG_ERR = "La superficie d'un d�partement est obligatoirement sup�rieur � 1 !!";
	
	/** code pour i18n. */
	public static final String CODE_ERREUR = "SUPERFICIE_INVALIDE";
	
	public RESuperficieErr() {
		super(MESG_ERR);
	}
}