package gestdepartement.metier.comm.exception;

public class RENomDeptNull extends RuntimeException {
	/** identifiant de serialisation. */
	private static final long serialVersionUID = 1L;
	
	/** le message par d�faut de l'exception. */
	private static final String MESG_ERR = "Le nom du departement doit etre renseign� !!";
	
	/** code pour i18n. */
	public static final String CODE_ERREUR = "NOM_DEPT_NULL";
	
	public RENomDeptNull() {
		super(MESG_ERR);
	}
}