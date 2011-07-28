package cindy.paqMetier.vol;

import java.util.List;

/**
 * 
 * @author J.Martinez
 *	class: Evenement qui va permettre de choisir dans
 *	la liste des évènements types puis saisir
 *	l'évènement survenu durant le vol
 */
public class Evenement {
	
	//Attributs
	private List<String> typeEvenement;
	
	//Constructeur
	public Evenement(){
		
	}
	
	//Accesseurs
	public List<String> getTypeEvenement() {
		return typeEvenement;
	}

	public void setTypeEvenement(List<String> typeEvenement) {
		this.typeEvenement = typeEvenement;
	}
	
	
}
