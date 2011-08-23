package gestdepartement.metier.comm;

public interface IRegionPersistant {
	
	public int getIdt();
	
	void ajouterDepartement(int idt, String code, String nom,int nombreHabitant,int superficie );

}
