package cindy.vue;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cindy.controleur.IControleur;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollPane;

public class VueVols extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControleur controleur;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VueVols(IControleur ctrl) {
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
		tabbedPane.addTab("Creer un vol", null, layeredPane, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 699, 155);
		layeredPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table.setModel(new ModeleJTableVol(controleur));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, tabbedPane}));
	}
}
