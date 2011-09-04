
package cindy.vue;

import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import cindy.controleur.Controleur;
import cindy.controleur.IControleur;

/**
 * A simple demonstration application showing how to create a pie chart using data from a
 * {@link DefaultPieDataset}.  This demo also shows an "exploded" section in the chart.
 *
 */
public class Camembert extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpanel;
	private static IControleur controleur;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public Camembert(IControleur controleur) {
    	try {
			controleur = new Controleur();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
      createDataset();
      this.setVisible(true);
    }
    /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
    private void createDataset() {
    	//cr�ation du sch�ma
        final DefaultPieDataset dataset = new DefaultPieDataset();
        //insertion des donn�es dansle cmember
        dataset.setValue("Secteur 1(43,2%)", new Double(43.2));
        dataset.setValue("Secteur 2", new Double(10.0));
        dataset.setValue("Secteur 3", new Double(27.5));
        dataset.setValue("Secteur 4", new Double(17.5));
        dataset.setValue("Secteur 5", new Double(11.0));
        dataset.setValue("Secteur 6", new Double(19.4));
        //cr�ation d'un chart
        final JFreeChart chart = ChartFactory.createPieChart(
                "Nombre de probl�me par secteur de vol", 	 // chart title
                dataset,             						// dataset
                true,               						// include legend
                true,
                false
            );
        //int�gration du chart au panel
        jpanel = new ChartPanel(chart);
    }

    public static void main(String[] args) {
		new Camembert(controleur);
	}
}