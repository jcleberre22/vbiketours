package gestdepartement.metier.comm;
/**
 * Interface nécessaire pour tester les départements.
 * @author marc.leconte
 * @version 1.0 du 12/06/2011
 */
public interface IDepartementTest {
	/**
	 * @return le code du departement.
	 */
	String getCode();
	/**
	 * Fixe la region d'appartenance du departement.
	 * L'instanciation par spring nexcessite l'injection
	 * de dependance de la region.
	 * @param appartenance region de rattachement du
	 * departement.
	 */
	void setAppartenance(IRegion appartenance);
}
