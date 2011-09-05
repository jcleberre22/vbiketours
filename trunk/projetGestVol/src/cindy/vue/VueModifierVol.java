package cindy.vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cindy.controleur.IControleur;
import cindy.metier.comm.ICategorie;
import cindy.metier.comm.ICirculation;
import cindy.metier.comm.IVol;
import cindy.metier.vol.Vol;
import cindy.outils.Outils;

import javax.swing.JCheckBox;

/**
 * Fenetre modifier un vol. JFrame appelé par la classe VueVols.
 * @author jc.leberre
 * @version 1.0 du 04/09/2011 modifié le 05/09/2001 par jp.martinez
 * 
 *
 */
public class VueModifierVol extends JFrame {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4843299780878635525L;
	/** Conteneur du JPanel */
	private final JPanel contentPanel = new JPanel();
	/** Champs pour les dates de decollage */
	private JSpinner spinner_decol;
	/** Interface du controleur */
	private IControleur controleur;
	/** Champs de texte de l'ID */
	private JTextField textField_Id;
	/** Champs pour les dates d'atterissage */
	private JSpinner spinner_atter;
	/** Tableau contenant les données de la table */
	private JTable table;
	/** Bouton Box annuler un vol */
	private JCheckBox checkBox;

	/**
	 * Lanceur de l'application pour les tests.
	 */
	public static void main(String[] args) {
		try {
			VueModifierVol dialog = new VueModifierVol(null,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public VueModifierVol(final IControleur controleur,final JTable table, final IVol vol) throws SQLException, Exception {
		setTitle("Cindy - Modifier un vol");
		this.controleur=controleur;
		this.table=table;
		setBounds(100, 100, 677, 290);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JPanel panel_Id = new JPanel();
		panel_Id.setBounds(10, 11, 272, 34);
		contentPanel.add(panel_Id);
		panel_Id.setLayout(null);
		
		JPanel panel_lblId = new JPanel();
		panel_lblId.setBounds(5, 5, 98, 24);
		panel_Id.add(panel_lblId);
		panel_lblId.setLayout(new BoxLayout(panel_lblId, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("IDVol : ");
		panel_lblId.add(lblNewLabel_1);
		
		textField_Id = new JTextField();
		textField_Id.setEditable(false);
		textField_Id.setHorizontalAlignment(SwingConstants.TRAILING);
		textField_Id.setBounds(102, 5, 37, 24);
		panel_Id.add(textField_Id);
		textField_Id.setColumns(10);
		textField_Id.setText(String.valueOf(vol.getId()));
			
		JPanel panel_circu = new JPanel();
		panel_circu.setBounds(10, 79, 272, 34);
		contentPanel.add(panel_circu);
		panel_circu.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(5, 5, 98, 24);
		panel_circu.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JLabel lblCirculation = new JLabel("Circulation : ");
		panel_10.add(lblCirculation);
		
		final JComboBox comboBox_circu = new JComboBox();
		comboBox_circu.setBounds(102, 5, 164, 26);
		for (ICirculation cat : controleur.getListeCirculations()) {
			comboBox_circu.addItem(cat.getLibelleCirculation());
		}
		comboBox_circu.setSelectedIndex(vol.getCirculation()-1);
		panel_circu.add(comboBox_circu);
		
		JPanel panel_cat = new JPanel();
		panel_cat.setLayout(null);
		panel_cat.setBounds(10, 149, 272, 34);
		contentPanel.add(panel_cat);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(5, 5, 98, 24);
		panel_cat.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		JLabel lblCategorie = new JLabel("Categorie : ");
		lblCategorie.setHorizontalAlignment(SwingConstants.LEFT);
		panel_12.add(lblCategorie);
		
		final JComboBox comboBox_cat = new JComboBox();
		comboBox_cat.setBounds(103, 5, 163, 26);
		for (ICategorie cat : controleur.getListeCategories()) {
			comboBox_cat.addItem(cat.getLibelleCategorie());
		}
		comboBox_cat.setSelectedIndex(vol.getLaCategorie()-1);
		panel_cat.add(comboBox_cat);
		
		JPanel panel = new JPanel();
		panel.setBounds(318, 11, 331, 140);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_decol = new JPanel();
		panel_decol.setBounds(15, 6, 310, 34);
		panel.add(panel_decol);
		panel_decol.setLayout(new BoxLayout(panel_decol, BoxLayout.X_AXIS));
		
		JLabel lblDateDecollage = new JLabel("Date Decollage :     ");
		panel_decol.add(lblDateDecollage);
		
		spinner_decol = new JSpinner();
		spinner_decol.setFont(new Font("SansSerif", Font.PLAIN, 12));
		spinner_decol.setModel(new SpinnerDateModel(vol.getDecollage().getTime(), null, null, Calendar.DAY_OF_YEAR));
		panel_decol.add(spinner_decol);
		
		JButton btnDefinir = new JButton("Definir");
		btnDefinir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VueCalendrier cal=new VueCalendrier(spinner_decol);
				
				cal.setVisible(true);
			}
		});
		panel_decol.add(btnDefinir);
		
		JPanel panel_atter = new JPanel();
		panel_atter.setBounds(15, 67, 310, 34);
		panel.add(panel_atter);
		panel_atter.setLayout(new BoxLayout(panel_atter, BoxLayout.X_AXIS));
		
		JLabel lblDateAtterrissage = new JLabel("Date Atterrissage :  ");
		panel_atter.add(lblDateAtterrissage);
		
		spinner_atter = new JSpinner();
		spinner_atter.setModel(new SpinnerDateModel(vol.getAtterrissage().getTime(), null, null, Calendar.DAY_OF_YEAR));
		panel_atter.add(spinner_atter);
		
		JButton button = new JButton("Definir");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VueCalendrier cal=new VueCalendrier(spinner_atter);
				cal.setVisible(true);
			}
		});
		panel_atter.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(464, 212, 185, 34);
		contentPanel.add(panel_1);
		
		JButton button_1 = new JButton("Annuler");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(23, 5, 70, 28);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Modifier");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idVol=Integer.parseInt(textField_Id.getText());
				System.out.println("IDVOL:"+idVol);
				int circulation=comboBox_circu.getSelectedIndex()+1;
				int categorieDeVol=comboBox_cat.getSelectedIndex()+1;
				Date date = (Date)spinner_decol.getValue();
				GregorianCalendar dateDecollage=new GregorianCalendar();
				dateDecollage.setTime(date);
				GregorianCalendar dateAtterrissage = new GregorianCalendar();
				date=(Date)spinner_atter.getValue();
				dateAtterrissage.setTime(date);
				boolean annulation=checkBox.isSelected();
				IVol nouveauVol= new Vol(idVol, circulation, categorieDeVol, dateDecollage, dateAtterrissage, annulation);
				controleur.modifierVol(vol, nouveauVol);
				Outils.rafraichirTableau(table, controleur);
				dispose();
			}
		});
		button_2.setBounds(105, 5, 77, 28);
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(328, 149, 185, 34);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAnnuler = new JLabel("Annuler :        ");
		lblAnnuler.setBounds(6, 8, 72, 16);
		panel_2.add(lblAnnuler);
		
		checkBox = new JCheckBox("");
		checkBox.setBounds(113, 6, 18, 18);
		panel_2.add(checkBox);
	}
}
