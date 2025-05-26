package model;

import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.ResultSet;
import model.mySQL;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;

/**
 *
 * @author Heshan Nawarathna
 */
public class cinemaPC {

    public static void loadChartToPanel(javax.swing.JPanel panel) {
        try {
            ChartPanel chartPanel = createChartPanel(panel.getWidth(), panel.getHeight());
            if (chartPanel != null) {
                panel.removeAll();
                panel.setLayout(new java.awt.BorderLayout());
                panel.add(chartPanel, java.awt.BorderLayout.CENTER);

                panel.validate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ChartPanel createChartPanel(int width, int height) {
        try {
            DefaultPieDataset dataset = createDataset();
            JFreeChart chart = ChartFactory.createPieChart(
                    "Monthly Popular Movies", dataset, true, true, false
            );

            PiePlot plot = (PiePlot) chart.getPlot();

            // Custom section colors
            plot.setSectionPaint("Richerd", new Color(255, 193, 7));  // amber
            plot.setSectionPaint("Sammany", new Color(244, 67, 54));  // red
            plot.setSectionPaint("Atles", new Color(3, 169, 244));    // light blue

            // Use background color #2b2b2b
            Color backgroundColor = Color.decode("#2b2b2b");
            Color lightText = Color.WHITE;

            chart.setBackgroundPaint(backgroundColor);
            plot.setBackgroundPaint(backgroundColor);
            plot.setOutlinePaint(backgroundColor);

            // Label styling
            plot.setLabelBackgroundPaint(backgroundColor);
            plot.setLabelPaint(lightText);
            plot.setLabelFont(new Font("Dialog", Font.BOLD, 12));

            // Title and legend styling
            chart.getTitle().setPaint(lightText);
            chart.getLegend().setBackgroundPaint(backgroundColor);
            chart.getLegend().setItemPaint(lightText);

            return new ChartPanel(chart);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private static DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            ResultSet rs = mySQL.executeSearch("SELECT movie.name AS movie_name, COUNT(*) AS ticket_count, DATE_FORMAT(schedule.schedule_date, '%Y-%m') AS month FROM movie_invoiceitem JOIN schedule ON movie_invoiceitem.schedule_id = schedule.id JOIN movie ON schedule.movie_movie_id = movie.movie_id GROUP BY movie.movie_id, month ORDER BY month DESC, ticket_count DESC LIMIT 3;");
            while (rs.next()) {
                String movie = rs.getString("movie_name");
                int totalSold = rs.getInt("ticket_count");
                dataset.setValue(movie, totalSold);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }

}
