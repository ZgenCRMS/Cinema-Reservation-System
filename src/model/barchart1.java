package model;

import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.ResultSet;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

/**
 *
 * @author Heshan Nawarathna
 */
public class barchart1 {

    public static void loadChartToJPanel(javax.swing.JPanel panel) {
        ChartPanel chartPanel = createChartPanel(panel.getSize().width, panel.getSize().height);
        if (chartPanel != null) {
            panel.removeAll();
            panel.setLayout(new java.awt.BorderLayout());
            panel.add(chartPanel, java.awt.BorderLayout.CENTER);
            panel.validate();
        }
    }

    private static ChartPanel createChartPanel(int width, int height) {
        try {
            DefaultCategoryDataset dataset = createDataset();

            JFreeChart chart = ChartFactory.createBarChart(
                    "This Month Sales", "Date", "Sales", dataset);

            // Backgrounds
            chart.setBackgroundPaint(Color.decode("#2b2b2b")); // Chart background
            chart.getPlot().setBackgroundPaint(Color.decode("#2b2b2b")); // Plot area
            chart.getPlot().setOutlinePaint(Color.decode("#2b2b2b"));    // Outline

            //Bar Colors
            BarRenderer br = new BarRenderer();
            br.setSeriesPaint(0, new Color(255, 193, 7)); // Amber Yellow
            chart.getCategoryPlot().setRenderer(br);

            //Label Styling
            CategoryPlot plot = chart.getCategoryPlot();
            plot.getDomainAxis().setTickLabelPaint(Color.WHITE); // X axis label
            plot.getRangeAxis().setTickLabelPaint(Color.WHITE);  // Y axis label
            plot.getDomainAxis().setLabelPaint(Color.WHITE);      // X title
            plot.getRangeAxis().setLabelPaint(Color.WHITE);       // Y title

            //Title
            chart.getTitle().setPaint(Color.WHITE);
            chart.getTitle().setFont(new Font("Dialog", Font.BOLD, 16));

            //Gridlines
            plot.setRangeGridlinePaint(Color.GRAY);

            //ChartPanel Settings
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setSize(width, height);
            chartPanel.setBackground(Color.decode("#2b2b2b")); // match with chart
            chartPanel.setVisible(true);

            return chartPanel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {

            ResultSet rs = mySQL.executeSearch("SELECT DATE_FORMAT(date, '%m-%d') as sale_date, SUM(paid_amount) as total_sales "
                    + "FROM invoice WHERE MONTH(date) = MONTH(CURDATE())"
                    + "GROUP BY sale_date "
                    + "ORDER BY sale_date");

            while (rs.next()) {
                String date = rs.getString("sale_date");
                double sales = rs.getDouble("total_sales");
                dataset.addValue(sales, "Sales", date);
            }
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

}
