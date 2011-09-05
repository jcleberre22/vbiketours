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
 * A bar chart that uses a custom renderer to display different colors within a series.
 * No legend is displayed because there is only one series but the colors are not consistent.
 *
 */
public class ProblemeVol extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A custom renderer that returns a different color for each item in a single series.
	 */
	class CustomRenderer extends BarRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/** Tableau de couleurs. */
		private Paint[] colors;
	//	private String title = "Nombre de vol avec probleme";

		/**
		 * Creates a new renderer.
		 *
		 * @param colors  the colors.
		 */
		public CustomRenderer(final Paint[] colors) {
			this.colors = colors;
		}

		/**
		 * Returns the paint for an item.  Overrides the default behaviour inherited from
		 * AbstractSeriesRenderer.
		 *
		 * @param row  the series.
		 * @param column  the category.
		 *
		 * @return The item color.
		 */
		public Paint getItemPaint(final int row, final int column) {
			return this.colors[column % this.colors.length];
		}
	}

	/**
	 * Creates a new demo.
	 *
	 * @param title  the frame title.
	 */
	public ProblemeVol(final String title) {
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		this.add(chartPanel);
	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
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
	 * Creates a sample chart.
	 * 
	 * @param dataset  the dataset.
	 * 
	 * @return a sample chart.
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