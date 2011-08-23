package gestdepartement.ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

public class IHMGereRegion implements ListSelectionListener{
	
	private JPanel lePanel;
	private JTable laTableRegion,laTableDepartement;
	private ActionListener ecouteur;
	
	public void PanelGereRegion(){
		initComposant();
	}

	public JPanel getLePanel() {
		return lePanel;
	}
	
	public void setModel(TableModel dataModel){
		laTableRegion.setModel(dataModel);
	}
	
	
	private void initComposant() {
		lePanel = new JPanel(new BorderLayout(25,25));
		lePanel.add(getTableRegion(),BorderLayout.WEST);
		lePanel.add(getTableDepartement(),BorderLayout.CENTER);
	}

	private Component getTableRegion() {
		//RegionModel modelProm = new TestModel(ctl);
		JPanel preg = new JPanel();
		preg.setMaximumSize(new Dimension(180, 520));
		preg.setPreferredSize(new Dimension(180, 520));
		laTableRegion = new JTable();
		laTableRegion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		laTableRegion.getSelectionModel().addListSelectionListener(this);
		JScrollPane js =new JScrollPane(laTableRegion);
		js.setPreferredSize(new Dimension(150, 500));
		preg.add(js);
		return preg;
	}
	
	private Component getTableDepartement() {
		//RegionModel modelProm = new TestModel(ctl);
		laTableDepartement = new JTable();
		laTableDepartement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		return new JScrollPane(laTableDepartement);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (ecouteur == null) return;
		int index = laTableRegion.getSelectedRow();
		ActionEvent action = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "SelRegion;"+index);
		ecouteur.actionPerformed(action);
		
	}
	
	public void setModelDepartement(DepartementModel depModel) {
		laTableDepartement.setModel(depModel);
	}

	public void addActionListener(ActionListener ect) {
		ecouteur = ect;
		
	}
	
	
}
