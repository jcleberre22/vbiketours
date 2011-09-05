package cindy.vue;

import java.awt.Color;
import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

/**
 * Classe generant un graphique. Celui ci est en forme de bar chart(histogrammes).
 * et se base sur la librairie JFreeChart (librairie libre).
 * @author nicolas.tabuteaud
 * @version 1.0 du 05/09/2011
 *
 */
public class ProblemeVol extends ApplicationFrame {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Une costume de rendu qui retourne une couleur différente pour chaque élément.
	 */
	class CustomRenderer extends BarRenderer {

		/** Tableau de couleurs. */
		private Paint[] colors;
		/** Titre du bar chart. */
		private String title = "Nombre de vol avec probleme";

		/**
		 * Creates a new renderer.
		 *
		 * @param couleurs.
		 */
		public CustomRenderer(final Paint[] colors) {
			this.colors = colors;
		}

		/**
		 * Renvoie la peinture d'un élément. 
		 * Remplace le comportement par défaut hérité de AbstractSeriesRenderer	
		 *
		 * @param ligne.
		 * @param colonne.
		 *
		 * @return l'item de la couleur
		 */
		public Paint getItemPaint(final int row, final int column) {
			return this.colors[column % this.colors.length];
		}
	}

	/**
	 * Test de la classe.
	 *
	 * @param title  the frame title.
	 */
	public ProblemeVol(final String title) {
		super(title);
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);
	}

    /**
     * Creation d'un dataset.
     * On insere des données dans le dataset. 
     * @return le datasetUtilities
     */
	private CategoryDataset createDataset() {
		final double[][] data = new double[][] {{4.0, 3.0, -2.0, 3.0, 6.0}};
		return DatasetUtilities.createCategoryDataset(
				"Series ",
				"Vol ",
				data
		);
	}

    /**
     * Creation du chart.
	 * @return un dataset.
     */
	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createBarChart(
				"Nombre de Vol/nombre de vol avec probleme",       
				"Vol",               
				"Value",                  
				dataset,                  
				PlotOrientation.VERTICAL, 
				false,                    
				true,
				false
		);

		chart.setBackgroundPaint(Color.lightGray);

		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("NO DATA!");

		final CategoryItemRenderer renderer = new CustomRenderer(
				new Paint[] {Color.red, Color.blue, Color.green,
						Color.yellow, Color.pink, Color.cyan,
						Color.magenta, Color.blue}
		);
		final ItemLabelPosition p = new ItemLabelPosition(
				ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 45.0
		);
		plot.setRenderer(renderer);

		final ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setLowerMargin(0.15);
		rangeAxis.setUpperMargin(0.15);

		return chart;

	}

	public static void main(final String[] args) {

		final ProblemeVol demo = new ProblemeVol("Nombre de vol avec probleme");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}