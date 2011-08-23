package gestdepartement.metier.comm.exception;

public class RECodeDeptNull extends RuntimeException {
	/** identifiant de serialisation. */
	private static final long serialVersionUID = 1L;
	
	/** le message par d�faut de l'exception. */
	private static final String MESG_ERR = "Le code du d�partement doit �tre renseign� !!";
	
	/** code pour i18n. */
	public static final String CODE_ERREUR = "CODE_DEPT_NULL";
	
	public RECodeDeptNull() {
		super(MESG_ERR);
	}
}
