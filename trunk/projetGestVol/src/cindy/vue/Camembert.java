
package cindy.vue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import cindy.controleur.IControleur;
import cindy.metier.comm.ISortieAerienne;
import cindy.metier.comm.IVol;

//TODO pb getlisteVols!

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
	private IControleur controleur;
	private List<IVol> listeVols;
	List<ISortieAerienne> listeSortie;
	@SuppressWarnings("unused")
	private int nbVolAProbleme;
	@SuppressWarnings("unused")
	private int nbVolTotal;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
	 * @throws Exception 
	 * @throws SQLException 
     */
    public Camembert(IControleur controleur) throws SQLException, Exception {
    	nbVolAProbleme=0;
    	nbVolTotal=0;
    	this.controleur=controleur;
    	//initPourcentage();
    	this.add(createDataset());

    }
    public void initPourcentage() throws SQLException, Exception {
    	
    	listeVols=controleur.getListeVols();
    	listeSortie=new ArrayList<ISortieAerienne>();
    	for (IVol vol : listeVols) {
			for (ISortieAerienne s : vol.getLesSorties()) {
				listeSortie.add(s);
				nbVolTotal+=1;
			}
		}
    	for (ISortieAerienne sortie : listeSortie) {
			if (sortie.getEvent().size()!=0){
				nbVolAProbleme+=1;
			}
		}
		
	}
	/**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     * @throws Exception 
     * @throws SQLException 
     */
    private ChartPanel createDataset() {

        final DefaultPieDataset dataset = new DefaultPieDataset();
//        double pourcVolAPb=(nbVolAProbleme/nbVolTotal)*100;
//        dataset.setValue("Nombre de vols avec Problème(s)", new Double(pourcVolAPb));
//        dataset.setValue("Nombre de vols sans problème(s)", new Double(100-pourcVolAPb));
        dataset.setValue("Nombre de vols avec Problème(s)", new Double(43.2));
        dataset.setValue("Nombre de vols sans problème(s)", new Double(66.8));
        ChartPanel cp = new ChartPanel(createChart(dataset));
        return cp;
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
        return chart;
    }
    

}