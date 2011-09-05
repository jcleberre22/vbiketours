package cindy.vue;

import java.awt.Color;
import java.awt.Paint;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

/**
 * Classe generant un graphique. Celui ci est en forme de bar chart(Histogramme)
 * et se base sur une librairie JFreeChart (librairie libre).
 * @author nicolas.tabuteaud
 * @version 1.0 du 05/09/2011
 *
 */
public class ProblemeVol extends JPanel {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode de personnalisation qui retourne une couleur différente 
	 * pour chaque élément dans une série unique.
	 */
	class CustomRenderer extends BarRenderer {

		/**
		 * Serial Version UID
		 */
		private static final long serialVersionUID = 1L;
		/** Tableau de couleurs. */
		private Paint[] colors;

		/**
		 * Creation d'un nouveau rendu
		 *
		 * @param couleurs
		 */
		public CustomRenderer(final Paint[] colors) {
			this.colors = colors;
		}

		/**
		 * Renvoie la peinture d'un élément. 
		 * Remplace le comportement par défaut hérité d'AbstractSeriesRenderer.
		 *
		 * @param ligne
		 * @param colonne
		 * @return l'item couleur
		 */
		public Paint getItemPaint(final int row, final int column) {
			return this.colors[column % this.colors.length];
		}
	}

	/**
	 * Constructeur  du Bart Chart.
	 * @param titre 
	 */
	public ProblemeVol(final String title) {
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		this.add(chartPanel);
	}

	/**
	 *Creation d'un datasetUtilities.
	 * 
	 * @return le dataset
	 */
	private CategoryDataset createDataset() {
		final double[][] data = new double[][] {{4.0, 3.0, 5.0, 3.0, 6.0}};
		return DatasetUtilities.createCategoryDataset(
				"Series ",
				" ",
				data
		);
	}

	/**
	 * Creation du chart.
	 * 
	 * @param dataset  
	 * 
	 * @return le chart
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createBarChart(
				"Nombre de problèmes par secteur de vol",       
				"Secteur de vol",               
				"Nb problèmes",                  
				dataset,                  
				PlotOrientation.VERTICAL, 
				false,                    
				true,
				false
		);

		chart.setBackgroundPaint(Color.lightGray);

		// get a reference to the plot for further customisation...
		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("NO DATA!");

		final CategoryItemRenderer renderer = new CustomRenderer(
				new Paint[] {Color.red, Color.blue, Color.green,
						Color.yellow, Color.pink, Color.cyan,
						Color.magenta, Color.blue}
		);

		plot.setRenderer(renderer);

		final ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setLowerMargin(0.15);
		rangeAxis.setUpperMargin(0.15);

		return chart;

	}
}