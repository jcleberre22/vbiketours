package cindy.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cindy.controleur.Controleur;

/**
 * Assemble les composants graphique et transfere les actions
 * en commande sur le controleur.
 * @author nicolas.tabuteaud
 * @version 1.0 du 31/08/2011
 */
public class BuilderVue implements ActionListener {
	
	private Controleur controleur;
	private VuePrincipale principal;

	public BuilderVue(){
		this(null);
		
	}
	
	public BuilderVue(Controleur ctl) {
		controleur = ctl;
		principal = new VuePrincipale(controleur);
		//associerMenu();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		if ("Quitter".equals(command)){
		//	controleur.quitter();
			principal.dispose();
		}
		
		if ("A Propos".equals(command)){
			new APropos();
		}
	}
	
	public void associerAPropos(){
		
		APropos app = new APropos();
		
	}
	
	
}
