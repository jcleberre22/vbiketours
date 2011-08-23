package gestdepartement.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestdepartement.metier.comm.IUseCase;

public class EcouteurRegion implements ActionListener{
	private IUseCase controleur;
	private VuePrincipale principal;
	private int selection;
	private RegionModel rm;
	private DepartementModel depModel ;
	public EcouteurRegion(IUseCase cont, VuePrincipale princ) {
		controleur = cont;
		principal = princ;
		assembleVue();
	}
	private void assembleVue() {
		selection = -1;
		rm = new RegionModel(controleur);
		IHMGereRegion pgr = new IHMGereRegion();
		pgr.setModel(rm);
		depModel = new DepartementModel(controleur,null);
		pgr.setModelDepartement(depModel);
		pgr.addActionListener(this);
		principal.ajouter(pgr.getLePanel());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] info = e.getActionCommand().split(";");
		int num = Integer.parseInt(info[1]);
		if (selection != num){
			selection = num;
			if (selection != -1){
				String nomRegion = rm.getValueAt(selection, 0).toString();
				depModel.setNomRegion(nomRegion);
			}
		}
	}

}
