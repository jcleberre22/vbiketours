
package cindy.vue;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import cindy.controleur.IControleur;

/**
 * A simple demonstration application showing how to create a pie chart using data from a
 * {@link DefaultPieDataset}.  This demo also shows an "exploded" section in the chart.
 *
 */
public class Camembert{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpanel;
	private IControleur controleur;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public Camembert(IControleur controleur) {

      createDataset();

    }
    /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
    private void createDataset() {
        final DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Secteur 1(43,2%)", new Double(43.2));
        dataset.setValue("Secteur 2", new Double(10.0));
        dataset.setValue("Secteur 3", new Double(27.5));
        dataset.setValue("Secteur 4", new Double(17.5));
        dataset.setValue("Secteur 5", new Double(11.0));
        dataset.setValue("Secteur 6", new Double(19.4));
        //return dataset;
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final PieDataset dataset) {
        final JFreeChart chart = ChartFactory.createPieChart(
            "Nombre de problème par secteur de vol", 	 // chart title
            dataset,             						// dataset
            true,               						// include legend
            true,
            false
        );
        final PiePlot plot = (PiePlot) chart.getPlot();
        plot.setNoDataMessage("No data available");
    //    plot.setExplodePercent(1, 0.30);
        return chart;
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
  /*  public static void main(final String[] args) {

        final Camembert demo = new Camembert("Cindy - Statistique");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
*/
}