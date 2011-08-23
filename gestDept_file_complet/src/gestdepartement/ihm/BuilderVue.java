package gestdepartement.ihm;

import gestdepartement.metier.comm.IUseCase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
/**
 * Assemble les composants graphique et transfere les actions
 * en commande sur le controleur.
 * @author marc.leconte
 * @version 1.0
 */
public class BuilderVue implements ActionListener {
	public static final String VUE_ERREUR = null;
	private VuePrincipale principal;
	private IUseCase controleur;
	
	
	public BuilderVue(){
		this(null);
		
	}
	public BuilderVue(IUseCase ctl) {
		controleur = ctl;
		principal = new VuePrincipale();
		//principal.addActionListener(this);
		associerMenu();
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		if ("Quitter".equals(command)){
			controleur.quitter();
			principal.dispose();
		}
		if ("Consulter Region".equals(command)){
			new EcouteurRegion(controleur,principal);
		}
	}

	private void associerMenu() {
		DecoupageMenu menu = new DecoupageMenu();
		//menu.addActionListener(this);
	}
	//TEST
	public static void main(String[] args) {
		new BuilderVue();
	}

	public static void afficherErreur(String message) {
		JOptionPane.showMessageDialog(null, message, "Une erreur est survenu", JOptionPane.ERROR_MESSAGE);

	}
}
