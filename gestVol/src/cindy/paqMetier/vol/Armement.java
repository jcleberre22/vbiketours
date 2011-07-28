package cindy.paqMetier.vol;

import cindy.paqMetier.comm.IArmement;

/**
 * 
 * @author J.Martinez
 *	class : armement qui permet de récupérer l'armement
 *	utilisé par un avion
 */
public class Armement implements IArmement{

	//attributs
	private int type;
	private String descriptionArmement;
	
	
	//Constructeur
	/**
	 * constructeur de la classe.
	 * Celui-ci exige qu'un type d'armement
	 * soit spécifié
	 * @param name
	 */
	public Armement(int typeEquipement){
		setType(typeEquipement);
		setDescriptionArmement(typeEquipement);
	}
	
	/**
	 * Constructeur par défaut.
	 * Donne un armement de base
	 * lors de sa déclaration pour
	 * un avion
	 */
	public Armement(){
		type = 0;
	}

	//Accesseur
	/**
	 * Retourne le nom de l'armement.
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * @return la description associé à un armement
	 */
	public String getDescriptionArmement() {
		return descriptionArmement;
	}

	/**
	 * permet de donner la description de l'armement
	 * en fonction du pack choisi
	 * @param descriptionArmement
	 */
	private void setDescriptionArmement(int packArmement) {
		if(packArmement >= 0 || packArmement <= 5)
			switch (packArmement) {
			case 0:
				this.descriptionArmement = "Série";
				break;
			case 1 :
				this.descriptionArmement = "Pack missiles tête chercheuse";
				break;
			case 2:
				this.descriptionArmement = "Pack missiles courte portée";
				break;
			case 3:
				this.descriptionArmement = "Pack missiles longue portée";
				break;
			case 4:
				this.descriptionArmement = "Pack missiles lourd";
				break;
			case 5:
				this.descriptionArmement = "Pack destruction massive + nucléaire";
			}
		else
			throw new RuntimeException("le pack d'armement choisi n'existe pas");
	}

	/**
	 * Fixe un nom pour l'armement.
	 * Renvoi une exception si
	 * le nom est null
	 * @param nom
	 */
	private void setType(int letype) {
			if(letype < 0 || letype > 5){				
				throw new RuntimeException("Armement: numero d'armement incorrect");
			}
			this.type = letype;
		}
}
