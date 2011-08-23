package gestdepartement.controleur;

import java.util.ArrayList;
import java.util.List;

import gestdepartement.ihm.BuilderVue;
import gestdepartement.metier.FacadeMetier;
import gestdepartement.metier.comm.IDepartementConsultable;
import gestdepartement.metier.comm.IUseCase;

public class Controleur implements IUseCase {
	private IUseCase metier;
	public Controleur(){
		metier = new FacadeMetier();
		new BuilderVue(this);
	}
	
	@Override
	public void ajouterDepartement(String nomReg, String code, String nom,
			int nombreHabitant, int superficie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterRegion(String nomReg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDepartement(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNomPays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IDepartementConsultable> listerDepartementTries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listerDepartements() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> listerRegion() {
		try {
			return metier.listerRegion();
		} catch (Exception e){
			BuilderVue.afficherErreur(e.getMessage());
			return new ArrayList<String>();
		}
	}
	
	public List<String> listerDepartement(String nomRegion) {
		try {
			return metier.listerDepartement(nomRegion);
		} catch (Exception e){
			BuilderVue.afficherErreur(e.getMessage());
			return new ArrayList<String>();
		}
	}
	
	@Override
	public void modifierDepartement(String code, String nom,
			int nombreHabitant, int superficie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierRegion(String region, String nvxNom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitter() {
		try {
			metier.quitter();
		} catch (Exception e){
			BuilderVue.afficherErreur(e.getMessage());
		}
	}

	@Override
	public void supprimerDepartement(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerRegion(String nomReg) {
		// TODO Auto-generated method stub
		
	}

}
