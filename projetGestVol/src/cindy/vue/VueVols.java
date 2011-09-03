package cindy.vue;

import java.awt.BorderLayout;
import java.awt.Container;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cindy.controleur.IControleur;
import cindy.metier.comm.ICategorie;
import cindy.metier.comm.IVol;

import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.toedter.calendar.JCalendar;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JComboBox;

public class VueVols extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControleur controleur;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public VueVols(IControleur ctrl) throws SQLException, Exception {
		setTitle("Gestion des vols");
		controleur=ctrl;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Creer un vol", null, layeredPane_1, null);
		layeredPane_1.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(404, 21, 1, 1);
		layeredPane_1.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(475, 21, 1, 1);
		layeredPane_1.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 207, 40);
		panel_7.add(panel_5);
		
		JLabel lblAaaaaaaaaaaaaaaa = new JLabel("aaaaaaaaaaaaaaaa");
		panel_5.add(lblAaaaaaaaaaaaaaaa);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 157, 34);
		layeredPane_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 5, 98, 24);
		panel_4.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("IDVol : ");
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBounds(113, 7, 39, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		try {
			textField.setText(String.valueOf((controleur.getListeVols().size()+1)));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 79, 272, 34);
		layeredPane_1.add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(5, 5, 98, 24);
		panel_9.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
		
		JLabel lblCirculation = new JLabel("Circulation : ");
		panel_10.add(lblCirculation);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 5, 164, 26);
		panel_9.add(comboBox);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBounds(10, 149, 272, 34);
		layeredPane_1.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(5, 5, 98, 24);
		panel_11.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.X_AXIS));
		
		JLabel lblCategorie = new JLabel("Categorie : ");
		lblCategorie.setHorizontalAlignment(SwingConstants.LEFT);
		panel_12.add(lblCategorie);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(103, 5, 163, 26);
		for (ICategorie cat : controleur.getListeCategories()) {
			comboBox_1.addItem(cat.getLibelleCategorie());
		}
		panel_11.add(comboBox_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBounds(317, 11, 306, 34);
		layeredPane_1.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(5, 5, 295, 29);
		panel_13.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS));
		
		JLabel lblDateDecollage = new JLabel("Date Decollage :   ");
		panel_14.add(lblDateDecollage);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
		panel_14.add(spinner);
		
		JButton btnDefinir = new JButton("Definir");
		btnDefinir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VueCalendrier cal=new VueCalendrier(spinner);
				
				cal.setVisible(true);
			}
		});
		panel_14.add(btnDefinir);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(317, 79, 306, 34);
		layeredPane_1.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 295, 29);
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblDateAtterrissage = new JLabel("Date Atterrissage :");
		panel_1.add(lblDateAtterrissage);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
		panel_1.add(spinner_1);
		
		JButton button = new JButton("Definir");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VueCalendrier cal=new VueCalendrier(spinner_1);
				cal.setVisible(true);
			}
		});
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(319, 149, 157, 34);
		layeredPane_1.add(panel_2);

		JPanel panel_15 = new JPanel();
		panel_15.setBounds(5, 5, 98, 24);
		panel_2.add(panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
		
		JLabel label_4 = new JLabel("Annulation : ");
		panel_15.add(label_4);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(115, 5, 21, 23);
		panel_2.add(checkBox);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, tabbedPane}));
	}
}
