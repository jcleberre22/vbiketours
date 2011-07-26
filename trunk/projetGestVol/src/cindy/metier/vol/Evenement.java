package cindy.metier.vol;

import java.util.List;

/**
 * 
 *	class: Evenement qui va permettre de choisir dans
 *	la liste des évènements types puis saisir
 *	l'évènement survenu durant le vol
 *	@author J.Martinez
 *	@version 1.0 du 27/07/2011
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
