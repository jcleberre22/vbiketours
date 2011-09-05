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
 * Classe generant un graphique. Celui ci est en forme de camembert
 * et se base sur une librairie JFreeChart (librairie libre).
 * @author nicolas.tabuteaud
 * @version 1.0 du 05/09/2011
 *
 */
public class Camembert extends JPanel{

    /**
	 * Serial Version IUD.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpanel;
	private static IControleur controleur;

	/**
     * Constructeur par defaut.
     * @param l'interface IControleur du package controleur.
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
     * Creation d'un dataset et du chart.
     * On insere des données dans le dataset. Et on integre le chart dans un panel.
	 * @return un dataset.
     */
    private void createDataset() {
        final DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Secteur 1(43,2%)", new Double(43.2));
        dataset.setValue("Secteur 2", new Double(10.0));
        dataset.setValue("Secteur 3", new Double(27.5));
        dataset.setValue("Secteur 4", new Double(17.5));
        dataset.setValue("Secteur 5", new Double(11.0));
        dataset.setValue("Secteur 6", new Double(19.4));
        final JFreeChart chart = ChartFactory.createPieChart(
                "Nombre de problème par secteur de vol", 	
                dataset,             						
                true,               					
                true,
                false
            );
        jpanel = new ChartPanel(chart);
    }
    
    /**
     * Méthode de test du camembert.
     * @param args
     */
    public static void main(String[] args) {
		new Camembert(controleur);
	}
}