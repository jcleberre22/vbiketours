package cindy.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import cindy.controleur.IControleur;
import cindy.metier.comm.ICategorie;
import cindy.metier.comm.ICirculation;
import cindy.metier.comm.IVol;
import cindy.outils.Outils;

public class VueVols extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControleur controleur;
	private JTable table;
	private JTextField textField_Id;
	private JSpinner spinner_decol;
	private JSpinner spinner_atter;


	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public VueVols(IControleur ctrl) throws SQLException, Exception {
		
		setTitle("Gestion des vols");
		controleur=ctrl;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//création de la barre de menu
		JMenuBar jmb = new JMenuBar();
		//création des menu
		JMenu fichier = new JMenu("Fichier");
		JMenu aide = new JMenu("Aide");
		jmb.add(fichier);
		jmb.add(aide);
		//création des item
		JMenuItem apropos = new JMenuItem("Apropos");
		apropos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new APropos();
			}
		});
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Consulter les vols", null, layeredPane, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 11, 699, 155);
		layeredPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowSelectionAllowed(true);
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table.setModel(new ModeleJTableVol(controleur));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(233, 182, 253, 34);
		layeredPane.add(panel_1);
		
		JButton button_1 = new JButton("Modifier");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idVol = table.getSelectedRow();
				IVol vol;
				try {
					vol = controleur.getListeVols().get(idVol);
					VueModifierVol modif=new VueModifierVol(controleur, table,vol);
					modif.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(6, 5, 80, 28);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idVol = table.getSelectedRow();
				IVol vol;
				try {
					vol = controleur.getListeVols().get(idVol);
					controleur.supprimerVol(vol);
					Outils.rafraichirTableau(table, controleur);
					textField_Id.setText(String.valueOf((idVol-1)));
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(137, 5, 86, 28);
		panel_1.add(button_2);
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Creer un vol", null, layeredPane_1, null);
		layeredPane_1.setLayout(null);
		
		JPanel panel_Id = new JPanel();
		panel_Id.setBounds(10, 11, 272, 34);
		layeredPane_1.add(panel_Id);
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
		try {
			textField_Id.setText(String.valueOf((controleur.getListeVols().size()+1)));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel_circu = new JPanel();
		panel_circu.setBounds(10, 79, 272, 34);
		layeredPane_1.add(panel_circu);
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
		panel_circu.add(comboBox_circu);
		
		JPanel panel_cat = new JPanel();
		panel_cat.setLayout(null);
		panel_cat.setBounds(10, 149, 272, 34);
		layeredPane_1.add(panel_cat);
		
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
		panel_cat.add(comboBox_cat);
		
		JPanel panel_boutons = new JPanel();
		panel_boutons.setBounds(568, 182, 150, 34);
		layeredPane_1.add(panel_boutons);
		panel_boutons.setLayout(null);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setBounds(6, 5, 70, 28);
		panel_boutons.add(btnAnnuler);
		
		JButton btnCreer = new JButton("Creer");
		btnCreer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idVol=Integer.parseInt(textField_Id.getText());
				int circulation=comboBox_circu.getSelectedIndex()+1;
				int categorieDeVol=comboBox_cat.getSelectedIndex()+1;
				Date date = (Date)spinner_decol.getValue();
				GregorianCalendar dateDecollage=new GregorianCalendar();
				dateDecollage.setTime(date);
				GregorianCalendar dateAtterrissage = new GregorianCalendar();
				date=(Date)spinner_atter.getValue();
				dateAtterrissage.setTime(date);
				controleur.creerVol(idVol, circulation, categorieDeVol, dateDecollage, dateAtterrissage, false);
				Outils.rafraichirTableau(table, controleur);
				textField_Id.setText(String.valueOf((idVol+1)));
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		btnCreer.setBounds(88, 5, 59, 28);
		panel_boutons.add(btnCreer);
		
		JPanel panel = new JPanel();
		panel.setBounds(318, 11, 331, 140);
		layeredPane_1.add(panel);
		panel.setLayout(null);
		
		JPanel panel_decol = new JPanel();
		panel_decol.setBounds(15, 6, 310, 34);
		panel.add(panel_decol);
		panel_decol.setLayout(new BoxLayout(panel_decol, BoxLayout.X_AXIS));
		
		JLabel lblDateDecollage = new JLabel("Date Decollage :     ");
		panel_decol.add(lblDateDecollage);
		
		spinner_decol = new JSpinner();
		spinner_decol.setFont(new Font("SansSerif", Font.PLAIN, 12));
		spinner_decol.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
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
		spinner_atter.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
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
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, tabbedPane}));
	}
}
