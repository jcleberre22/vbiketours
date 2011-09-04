package cindy.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

public class VueCalendrier extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3820355815980650845L;
	private final JPanel contentPanel = new JPanel();
	private JCalendar calendrier;
	@SuppressWarnings("unused")
	private JSpinner spinner;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VueCalendrier dialog = new VueCalendrier(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VueCalendrier(final JSpinner spinner) {
		this.spinner=spinner;
		setBounds(100, 100, 590, 305);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(6, 30, 337, 239);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			calendrier=new JCalendar();
			calendrier.setMaxDayCharacters(1);
			calendrier.setBounds(6, 6, 320, 223);
			calendrier.setTodayButtonVisible(true);
			panel.add(calendrier);
		}
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(364, 54, 208, 35);
		contentPanel.add(horizontalBox);
		
		JLabel label = new JLabel("\u00E0 :   ");
		horizontalBox.add(label);
		
		final JSpinner spinnerH = new JSpinner();
		spinnerH.setPreferredSize(new Dimension(30, 20));
		spinnerH.setMinimumSize(new Dimension(20, 20));
		spinnerH.setMaximumSize(new Dimension(50, 25));
		spinnerH.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		horizontalBox.add(spinnerH);
		
		JLabel lblH = new JLabel(" H ");
		horizontalBox.add(lblH);
		
		final JSpinner spinnerM = new JSpinner();
		spinnerM.setMinimumSize(new Dimension(20, 20));
		spinnerM.setPreferredSize(new Dimension(30, 20));
		spinnerM.setMaximumSize(new Dimension(50, 25));
		spinnerM.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		horizontalBox.add(spinnerM);
		
		JLabel lblM = new JLabel(" M ");
		horizontalBox.add(lblM);
		
		final JSpinner spinnerS = new JSpinner();
		spinnerS.setMinimumSize(new Dimension(20, 20));
		spinnerS.setPreferredSize(new Dimension(35, 20));
		spinnerS.setMaximumSize(new Dimension(50, 25));
		spinnerS.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		horizontalBox.add(spinnerS);
		
		JLabel lblS = new JLabel(" S ");
		horizontalBox.add(lblS);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(431, 231, 124, 25);
		contentPanel.add(horizontalBox_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int heures=(Integer)spinnerH.getValue();
				int minutes=(Integer)spinnerM.getValue();
				int secondes=(Integer)spinnerS.getValue();
				Calendar date = calendrier.getCalendar();
				GregorianCalendar gc=new GregorianCalendar(date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH),heures,minutes,secondes);
				spinner.setValue(gc.getTime());		
				System.out.println("Date : "+calendrier.getCalendar().getTime());
				dispose();
			}
		});
		horizontalBox_1.add(btnOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		horizontalBox_1.add(btnAnnuler);
	}
}
