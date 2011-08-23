package gestdepartement.persistance;

import gestdepartement.metier.comm.IPersistance;

/**
 * Fabrique les instances de persistance.
 * @author marc.leconte
 * @version 1.0 du 14/06/2011
 */
public class FabriquePersistance {
	/** type de persistance pour les regions. */
	public static final int REGION = 1;
	/** type de persistance pour les departements. */
	public static final int DEPARTEMENT = 2;

	/**
	 * Constructeur privé,
	 * les fabriques ne peuvent pas etre instanciee.
	 */
	private FabriquePersistance(){
	}
	
	public static IPersistance getInstance(int type){
		switch(type) {
		case REGION :
			return new DAOFicRegion();
		case DEPARTEMENT:
			return new DAOFicDepartement();
		}
		return null;
	}
}
