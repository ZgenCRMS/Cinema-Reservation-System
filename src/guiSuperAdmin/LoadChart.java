/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package guiSuperAdmin;

import java.awt.Color;
import java.sql.ResultSet;
import model.aminPC;
import model.barchart;
import model.barchart1;
import model.cinemaPC;
import model.mySQL;

/**
 *
 * @author User
 */
public class LoadChart extends javax.swing.JPanel {

    /**
     * Creates new form LoadChart
     */
    public LoadChart() {
        initComponents();
        loardChart();
        invcount();
        minvcount();
        Ainvcount();
        DailyInvTotal();
        weeklyInvTotal();
        MonthlyInvTotal();
        yearlyInvTotal();
        Cinemainvcount();
        cinemaminvcount();
        cinemaAinvcount();
        cinemaDailyInvTotal();
        cinemaweeklyInvTotal();
        cinemaMonthlyInvTotal();
        cinemayearlyInvTotal();
    }

    private void loardChart() {

        aminPC.loadChartToPanel(jPanel79);
        barchart.loadChartToJPanel(jPanel82);
        cinemaPC.loadChartToPanel(jPanel152);
        barchart1.loadChartToJPanel(jPanel155);

    }

    //cinema data loading
    private void Cinemainvcount() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT COUNT(*) AS total FROM invoice WHERE DATE(date) = CURDATE()");

            if (resultSet.next()) {
                int count = resultSet.getInt("total");
                jLabel35.setText("" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cinemaminvcount() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT COUNT(*) AS total FROM snack_invoice WHERE MONTH(date) = MONTH(CURDATE())");

            if (resultSet.next()) {
                int count = resultSet.getInt("total");
                jLabel37.setText("" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cinemaAinvcount() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT COUNT(*) AS total FROM snack_invoice WHERE YEAR(date) = YEAR(CURDATE())");

            if (resultSet.next()) {
                int count = resultSet.getInt("total");
                jLabel39.setText("" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cinemaDailyInvTotal() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT SUM(paid_amount) AS daily_total "
                    + "FROM invoice WHERE DATE(date) = CURDATE()");

            if (resultSet.next()) {
                double dailyTotal = resultSet.getDouble("daily_total");
                if (resultSet.wasNull()) {
                    dailyTotal = 0;
                }
                jLabel41.setText("" + dailyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void cinemaweeklyInvTotal() {
        try {

            String query = "SELECT SUM(paid_amount) AS weekly_total FROM invoice WHERE WEEK(date) = WEEK(CURDATE())";

            ResultSet resultSet = mySQL.executeSearch(query);

            if (resultSet.next()) {
                double weeklyTotal = resultSet.getDouble("weekly_total");
                if (resultSet.wasNull()) {
                    weeklyTotal = 0;
                }
                jLabel42.setText("" + weeklyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void cinemaMonthlyInvTotal() {
        try {

            String query = "SELECT SUM(paid_amount) AS monthly_total FROM invoice WHERE MONTH(date) = MONTH(CURDATE())";

            ResultSet resultSet = mySQL.executeSearch(query);

            if (resultSet.next()) {
                double monthlyTotal = resultSet.getDouble("monthly_total");
                if (resultSet.wasNull()) {
                    monthlyTotal = 0;
                }
                jLabel43.setText("" + monthlyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void cinemayearlyInvTotal() {
        try {

            String query = "SELECT YEAR(date) AS Invoice_Year, SUM(paid_amount) AS Total_Amount FROM invoice GROUP BY YEAR(date)ORDER BY Invoice_Year DESC";

            ResultSet resultSet = mySQL.executeSearch(query);

            if (resultSet.next()) {
                double yearlyTotal = resultSet.getDouble("Total_Amount");
                if (resultSet.wasNull()) {
                    yearlyTotal = 0;
                }
                jLabel44.setText("" + yearlyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //snackbar data loading
    private void invcount() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT COUNT(*) AS total FROM snack_invoice WHERE DATE(date) = CURDATE()");

            if (resultSet.next()) {
                int count = resultSet.getInt("total");
                jLabel28.setText("" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void minvcount() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT COUNT(*) AS total FROM snack_invoice WHERE MONTH(date) = MONTH(CURDATE())");

            if (resultSet.next()) {
                int count = resultSet.getInt("total");
                jLabel30.setText("" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Ainvcount() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT COUNT(*) AS total FROM snack_invoice WHERE YEAR(date) = YEAR(CURDATE())");

            if (resultSet.next()) {
                int count = resultSet.getInt("total");
                jLabel32.setText("" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DailyInvTotal() {
        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT SUM(paid_amount) AS daily_total "
                    + "FROM snack_invoice WHERE DATE(date) = CURDATE()");

            if (resultSet.next()) {
                double dailyTotal = resultSet.getDouble("daily_total");
                if (resultSet.wasNull()) {
                    dailyTotal = 0;
                }
                jLabel25.setText("" + dailyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void weeklyInvTotal() {
        try {

            String query = "SELECT SUM(paid_amount) AS weekly_total FROM snack_invoice WHERE WEEK(date) = WEEK(CURDATE())";

            ResultSet resultSet = mySQL.executeSearch(query);

            if (resultSet.next()) {
                double weeklyTotal = resultSet.getDouble("weekly_total");
                if (resultSet.wasNull()) {
                    weeklyTotal = 0;
                }
                jLabel22.setText("" + weeklyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void MonthlyInvTotal() {
        try {

            String query = "SELECT SUM(paid_amount) AS monthly_total FROM snack_invoice WHERE MONTH(date) = MONTH(CURDATE())";

            ResultSet resultSet = mySQL.executeSearch(query);

            if (resultSet.next()) {
                double monthlyTotal = resultSet.getDouble("monthly_total");
                if (resultSet.wasNull()) {
                    monthlyTotal = 0;
                }
                jLabel19.setText("" + monthlyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void yearlyInvTotal() {
        try {

            String query = "SELECT YEAR(date) AS Invoice_Year, SUM(paid_amount) AS Total_Amount FROM snack_invoice GROUP BY YEAR(date)ORDER BY Invoice_Year DESC";

            ResultSet resultSet = mySQL.executeSearch(query);

            if (resultSet.next()) {
                double yearlyTotal = resultSet.getDouble("Total_Amount");
                if (resultSet.wasNull()) {
                    yearlyTotal = 0;
                }
                jLabel17.setText("" + yearlyTotal);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel22 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jPanel87 = new javax.swing.JPanel();
        jPanel88 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        jPanel91 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jPanel93 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jPanel95 = new javax.swing.JPanel();
        jPanel96 = new javax.swing.JPanel();
        jPanel97 = new javax.swing.JPanel();
        jPanel98 = new javax.swing.JPanel();
        jPanel99 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        jPanel102 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jPanel105 = new javax.swing.JPanel();
        jPanel106 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jPanel109 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jPanel112 = new javax.swing.JPanel();
        jPanel113 = new javax.swing.JPanel();
        jPanel114 = new javax.swing.JPanel();
        jPanel115 = new javax.swing.JPanel();
        jPanel116 = new javax.swing.JPanel();
        jPanel117 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jPanel121 = new javax.swing.JPanel();
        jPanel122 = new javax.swing.JPanel();
        jPanel123 = new javax.swing.JPanel();
        jPanel124 = new javax.swing.JPanel();
        jPanel125 = new javax.swing.JPanel();
        jPanel126 = new javax.swing.JPanel();
        jPanel127 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel128 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel129 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel130 = new javax.swing.JPanel();
        jPanel131 = new javax.swing.JPanel();
        jPanel132 = new javax.swing.JPanel();
        jPanel133 = new javax.swing.JPanel();
        jPanel134 = new javax.swing.JPanel();
        jPanel135 = new javax.swing.JPanel();
        jPanel136 = new javax.swing.JPanel();
        jPanel137 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel138 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel139 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jPanel141 = new javax.swing.JPanel();
        jPanel142 = new javax.swing.JPanel();
        jPanel143 = new javax.swing.JPanel();
        jPanel144 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel145 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel146 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jPanel148 = new javax.swing.JPanel();
        jPanel149 = new javax.swing.JPanel();
        jPanel150 = new javax.swing.JPanel();
        jPanel151 = new javax.swing.JPanel();
        jPanel152 = new javax.swing.JPanel();
        jPanel153 = new javax.swing.JPanel();
        jPanel154 = new javax.swing.JPanel();
        jPanel155 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(897, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1454, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(897, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1454, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setPreferredSize(new java.awt.Dimension(10, 385));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel4.setPreferredSize(new java.awt.Dimension(10, 385));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );

        add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.BorderLayout());

        jPanel12.setPreferredSize(new java.awt.Dimension(1208, 10));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel78.setLayout(new java.awt.BorderLayout());

        jPanel83.setPreferredSize(new java.awt.Dimension(1208, 10));

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel78.add(jPanel83, java.awt.BorderLayout.PAGE_START);

        jPanel84.setPreferredSize(new java.awt.Dimension(1208, 10));

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel78.add(jPanel84, java.awt.BorderLayout.PAGE_END);

        jPanel85.setLayout(new java.awt.BorderLayout());

        jPanel86.setLayout(new java.awt.BorderLayout());

        jPanel87.setPreferredSize(new java.awt.Dimension(1059, 10));

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel86.add(jPanel87, java.awt.BorderLayout.PAGE_START);

        jPanel88.setPreferredSize(new java.awt.Dimension(1059, 10));

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel86.add(jPanel88, java.awt.BorderLayout.PAGE_END);

        jPanel89.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );

        jPanel86.add(jPanel89, java.awt.BorderLayout.LINE_START);

        jPanel90.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );

        jPanel86.add(jPanel90, java.awt.BorderLayout.LINE_END);

        jPanel91.setLayout(new java.awt.BorderLayout());

        jPanel92.setOpaque(false);
        jPanel92.setPreferredSize(new java.awt.Dimension(1039, 170));
        jPanel92.setLayout(new java.awt.BorderLayout());

        jPanel93.setBackground(new java.awt.Color(43, 43, 43));
        jPanel93.setPreferredSize(new java.awt.Dimension(1059, 20));

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1414, Short.MAX_VALUE)
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel92.add(jPanel93, java.awt.BorderLayout.PAGE_START);

        jPanel94.setBackground(new java.awt.Color(43, 43, 43));
        jPanel94.setPreferredSize(new java.awt.Dimension(1059, 20));

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1414, Short.MAX_VALUE)
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel92.add(jPanel94, java.awt.BorderLayout.PAGE_END);

        jPanel95.setBackground(new java.awt.Color(43, 43, 43));
        jPanel95.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel92.add(jPanel95, java.awt.BorderLayout.LINE_END);

        jPanel96.setBackground(new java.awt.Color(43, 43, 43));
        jPanel96.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel92.add(jPanel96, java.awt.BorderLayout.LINE_START);

        jPanel97.setBackground(new java.awt.Color(102, 102, 102));
        jPanel97.setLayout(new java.awt.BorderLayout());

        jPanel98.setBackground(new java.awt.Color(102, 102, 102));
        jPanel98.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel98.setLayout(new java.awt.BorderLayout());

        jPanel99.setPreferredSize(new java.awt.Dimension(1059, 25));
        jPanel99.setLayout(new java.awt.BorderLayout());

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Invoice Count");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel99.add(jLabel33, java.awt.BorderLayout.CENTER);

        jPanel98.add(jPanel99, java.awt.BorderLayout.PAGE_START);

        jPanel100.setLayout(new java.awt.BorderLayout());

        jPanel101.setPreferredSize(new java.awt.Dimension(1059, 35));
        jPanel101.setLayout(new java.awt.BorderLayout());

        jPanel102.setPreferredSize(new java.awt.Dimension(90, 130));
        jPanel102.setLayout(new java.awt.BorderLayout());

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Today     :");
        jPanel102.add(jLabel34, java.awt.BorderLayout.CENTER);

        jPanel101.add(jPanel102, java.awt.BorderLayout.LINE_START);

        jPanel103.setLayout(new java.awt.BorderLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 0, 51));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Invoice Count");
        jPanel103.add(jLabel35, java.awt.BorderLayout.CENTER);

        jPanel101.add(jPanel103, java.awt.BorderLayout.CENTER);

        jPanel100.add(jPanel101, java.awt.BorderLayout.PAGE_START);

        jPanel104.setLayout(new java.awt.BorderLayout());

        jPanel105.setPreferredSize(new java.awt.Dimension(1059, 35));
        jPanel105.setLayout(new java.awt.BorderLayout());

        jPanel106.setPreferredSize(new java.awt.Dimension(90, 130));
        jPanel106.setLayout(new java.awt.BorderLayout());

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Monthly :");
        jPanel106.add(jLabel36, java.awt.BorderLayout.CENTER);

        jPanel105.add(jPanel106, java.awt.BorderLayout.LINE_START);

        jPanel107.setLayout(new java.awt.BorderLayout());

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 0, 51));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Invoice Count");
        jPanel107.add(jLabel37, java.awt.BorderLayout.CENTER);

        jPanel105.add(jPanel107, java.awt.BorderLayout.CENTER);

        jPanel104.add(jPanel105, java.awt.BorderLayout.PAGE_START);

        jPanel108.setLayout(new java.awt.BorderLayout());

        jPanel109.setPreferredSize(new java.awt.Dimension(90, 130));
        jPanel109.setLayout(new java.awt.BorderLayout());

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Annualy :");
        jPanel109.add(jLabel38, java.awt.BorderLayout.CENTER);

        jPanel108.add(jPanel109, java.awt.BorderLayout.LINE_START);

        jPanel110.setLayout(new java.awt.BorderLayout());

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 0, 51));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Invoice Count");
        jPanel110.add(jLabel39, java.awt.BorderLayout.CENTER);

        jPanel108.add(jPanel110, java.awt.BorderLayout.CENTER);

        jPanel104.add(jPanel108, java.awt.BorderLayout.CENTER);

        jPanel100.add(jPanel104, java.awt.BorderLayout.CENTER);

        jPanel98.add(jPanel100, java.awt.BorderLayout.CENTER);

        jPanel97.add(jPanel98, java.awt.BorderLayout.LINE_START);

        jPanel111.setBackground(new java.awt.Color(255, 255, 255));
        jPanel111.setLayout(new java.awt.BorderLayout());

        jPanel112.setBackground(new java.awt.Color(43, 43, 43));
        jPanel112.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel111.add(jPanel112, java.awt.BorderLayout.LINE_START);

        jPanel113.setLayout(new java.awt.BorderLayout());

        jPanel114.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel114.setLayout(new java.awt.BorderLayout());

        jPanel115.setLayout(new java.awt.BorderLayout());

        jPanel116.setBackground(new java.awt.Color(51, 51, 51));
        jPanel116.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel116.setLayout(new java.awt.BorderLayout());

        jPanel117.setLayout(new java.awt.BorderLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/td.png"))); // NOI18N
        jPanel117.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel116.add(jPanel117, java.awt.BorderLayout.CENTER);

        jPanel118.setForeground(new java.awt.Color(250, 250, 250));
        jPanel118.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel118.setLayout(new java.awt.BorderLayout());

        jLabel40.setBackground(new java.awt.Color(250, 250, 250));
        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(242, 242, 242));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Today Sales ");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
        });
        jPanel118.add(jLabel40, java.awt.BorderLayout.CENTER);

        jPanel116.add(jPanel118, java.awt.BorderLayout.PAGE_END);

        jPanel115.add(jPanel116, java.awt.BorderLayout.PAGE_START);

        jPanel119.setForeground(new java.awt.Color(255, 255, 255));
        jPanel119.setLayout(new java.awt.BorderLayout());

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(207, 0, 6));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel119.add(jLabel41, java.awt.BorderLayout.CENTER);

        jPanel115.add(jPanel119, java.awt.BorderLayout.CENTER);

        jPanel114.add(jPanel115, java.awt.BorderLayout.CENTER);

        jPanel113.add(jPanel114, java.awt.BorderLayout.LINE_START);

        jPanel120.setLayout(new java.awt.BorderLayout());

        jPanel121.setBackground(new java.awt.Color(43, 43, 43));
        jPanel121.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel120.add(jPanel121, java.awt.BorderLayout.LINE_START);

        jPanel122.setLayout(new java.awt.BorderLayout());

        jPanel123.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel123MouseClicked(evt);
            }
        });
        jPanel123.setLayout(new java.awt.BorderLayout());

        jPanel124.setLayout(new java.awt.BorderLayout());

        jPanel125.setLayout(new java.awt.BorderLayout());

        jPanel126.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel126.setLayout(new java.awt.BorderLayout());

        jPanel127.setLayout(new java.awt.BorderLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/vs1.png"))); // NOI18N
        jPanel127.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanel126.add(jPanel127, java.awt.BorderLayout.CENTER);

        jPanel128.setForeground(new java.awt.Color(250, 250, 250));
        jPanel128.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel128.setLayout(new java.awt.BorderLayout());

        jLabel23.setBackground(new java.awt.Color(250, 250, 250));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(242, 242, 242));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Weekly Sales ");
        jLabel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        jPanel128.add(jLabel23, java.awt.BorderLayout.CENTER);

        jPanel126.add(jPanel128, java.awt.BorderLayout.PAGE_END);

        jPanel125.add(jPanel126, java.awt.BorderLayout.PAGE_START);

        jPanel129.setForeground(new java.awt.Color(255, 255, 255));
        jPanel129.setLayout(new java.awt.BorderLayout());

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(207, 0, 6));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel129.add(jLabel42, java.awt.BorderLayout.CENTER);

        jPanel125.add(jPanel129, java.awt.BorderLayout.CENTER);

        jPanel124.add(jPanel125, java.awt.BorderLayout.CENTER);

        jPanel123.add(jPanel124, java.awt.BorderLayout.CENTER);

        jPanel122.add(jPanel123, java.awt.BorderLayout.LINE_START);

        jPanel130.setLayout(new java.awt.BorderLayout());

        jPanel131.setBackground(new java.awt.Color(43, 43, 43));
        jPanel131.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel131Layout = new javax.swing.GroupLayout(jPanel131);
        jPanel131.setLayout(jPanel131Layout);
        jPanel131Layout.setHorizontalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel131Layout.setVerticalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel130.add(jPanel131, java.awt.BorderLayout.LINE_START);

        jPanel132.setLayout(new java.awt.BorderLayout());

        jPanel133.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel133.setLayout(new java.awt.BorderLayout());

        jPanel134.setLayout(new java.awt.BorderLayout());

        jPanel135.setLayout(new java.awt.BorderLayout());

        jPanel136.setBackground(new java.awt.Color(51, 51, 51));
        jPanel136.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel136.setLayout(new java.awt.BorderLayout());

        jPanel137.setLayout(new java.awt.BorderLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ts.png"))); // NOI18N
        jPanel137.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel136.add(jPanel137, java.awt.BorderLayout.CENTER);

        jPanel138.setForeground(new java.awt.Color(250, 250, 250));
        jPanel138.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel138.setLayout(new java.awt.BorderLayout());

        jLabel20.setBackground(new java.awt.Color(250, 250, 250));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(242, 242, 242));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Monthly Sales ");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
        jPanel138.add(jLabel20, java.awt.BorderLayout.CENTER);

        jPanel136.add(jPanel138, java.awt.BorderLayout.PAGE_END);

        jPanel135.add(jPanel136, java.awt.BorderLayout.PAGE_START);

        jPanel139.setForeground(new java.awt.Color(255, 255, 255));
        jPanel139.setLayout(new java.awt.BorderLayout());

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(207, 0, 6));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel139.add(jLabel43, java.awt.BorderLayout.CENTER);

        jPanel135.add(jPanel139, java.awt.BorderLayout.CENTER);

        jPanel134.add(jPanel135, java.awt.BorderLayout.CENTER);

        jPanel133.add(jPanel134, java.awt.BorderLayout.CENTER);

        jPanel132.add(jPanel133, java.awt.BorderLayout.LINE_START);

        jPanel140.setLayout(new java.awt.BorderLayout());

        jPanel141.setBackground(new java.awt.Color(43, 43, 43));
        jPanel141.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel141Layout = new javax.swing.GroupLayout(jPanel141);
        jPanel141.setLayout(jPanel141Layout);
        jPanel141Layout.setHorizontalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel141Layout.setVerticalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel140.add(jPanel141, java.awt.BorderLayout.LINE_START);

        jPanel142.setLayout(new java.awt.BorderLayout());

        jPanel143.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel143.setLayout(new java.awt.BorderLayout());

        jPanel144.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ann.png"))); // NOI18N
        jPanel144.add(jLabel8, java.awt.BorderLayout.CENTER);

        jPanel143.add(jPanel144, java.awt.BorderLayout.CENTER);

        jPanel145.setForeground(new java.awt.Color(250, 250, 250));
        jPanel145.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel145.setLayout(new java.awt.BorderLayout());

        jLabel16.setBackground(new java.awt.Color(250, 250, 250));
        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(242, 242, 242));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Annualy Sales ");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel145.add(jLabel16, java.awt.BorderLayout.CENTER);

        jPanel143.add(jPanel145, java.awt.BorderLayout.PAGE_END);

        jPanel142.add(jPanel143, java.awt.BorderLayout.PAGE_START);

        jPanel146.setForeground(new java.awt.Color(255, 255, 255));
        jPanel146.setLayout(new java.awt.BorderLayout());

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(207, 0, 6));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel146.add(jLabel44, java.awt.BorderLayout.CENTER);

        jPanel142.add(jPanel146, java.awt.BorderLayout.CENTER);

        jPanel140.add(jPanel142, java.awt.BorderLayout.CENTER);

        jPanel132.add(jPanel140, java.awt.BorderLayout.CENTER);

        jPanel130.add(jPanel132, java.awt.BorderLayout.CENTER);

        jPanel122.add(jPanel130, java.awt.BorderLayout.CENTER);

        jPanel120.add(jPanel122, java.awt.BorderLayout.CENTER);

        jPanel113.add(jPanel120, java.awt.BorderLayout.CENTER);

        jPanel111.add(jPanel113, java.awt.BorderLayout.CENTER);

        jPanel97.add(jPanel111, java.awt.BorderLayout.CENTER);

        jPanel92.add(jPanel97, java.awt.BorderLayout.CENTER);

        jPanel91.add(jPanel92, java.awt.BorderLayout.PAGE_START);

        jPanel147.setLayout(new java.awt.BorderLayout());

        jPanel148.setLayout(new java.awt.BorderLayout());

        jPanel149.setPreferredSize(new java.awt.Dimension(376, 50));

        javax.swing.GroupLayout jPanel149Layout = new javax.swing.GroupLayout(jPanel149);
        jPanel149.setLayout(jPanel149Layout);
        jPanel149Layout.setHorizontalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1414, Short.MAX_VALUE)
        );
        jPanel149Layout.setVerticalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel148.add(jPanel149, java.awt.BorderLayout.PAGE_START);

        jPanel150.setLayout(new java.awt.BorderLayout());

        jPanel151.setPreferredSize(new java.awt.Dimension(350, 326));
        jPanel151.setLayout(new java.awt.BorderLayout());

        jPanel152.setBackground(new java.awt.Color(255, 255, 255));
        jPanel152.setLayout(new java.awt.BorderLayout());
        jPanel151.add(jPanel152, java.awt.BorderLayout.CENTER);

        jPanel150.add(jPanel151, java.awt.BorderLayout.LINE_START);

        jPanel153.setLayout(new java.awt.BorderLayout());

        jPanel154.setPreferredSize(new java.awt.Dimension(10, 326));

        javax.swing.GroupLayout jPanel154Layout = new javax.swing.GroupLayout(jPanel154);
        jPanel154.setLayout(jPanel154Layout);
        jPanel154Layout.setHorizontalGroup(
            jPanel154Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel154Layout.setVerticalGroup(
            jPanel154Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );

        jPanel153.add(jPanel154, java.awt.BorderLayout.LINE_START);

        jPanel155.setLayout(new java.awt.BorderLayout());
        jPanel153.add(jPanel155, java.awt.BorderLayout.CENTER);

        jPanel150.add(jPanel153, java.awt.BorderLayout.CENTER);

        jPanel148.add(jPanel150, java.awt.BorderLayout.CENTER);

        jPanel147.add(jPanel148, java.awt.BorderLayout.CENTER);

        jPanel91.add(jPanel147, java.awt.BorderLayout.CENTER);

        jPanel86.add(jPanel91, java.awt.BorderLayout.CENTER);

        jPanel85.add(jPanel86, java.awt.BorderLayout.CENTER);

        jPanel78.add(jPanel85, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel78, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Movie", jPanel22);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(1208, 10));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setPreferredSize(new java.awt.Dimension(1208, 10));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setPreferredSize(new java.awt.Dimension(1059, 10));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel13.setPreferredSize(new java.awt.Dimension(1059, 10));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1434, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jPanel14.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel14, java.awt.BorderLayout.LINE_START);

        jPanel15.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel15, java.awt.BorderLayout.LINE_END);

        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel17.setOpaque(false);
        jPanel17.setPreferredSize(new java.awt.Dimension(1039, 170));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel25.setBackground(new java.awt.Color(43, 43, 43));
        jPanel25.setPreferredSize(new java.awt.Dimension(1059, 20));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1414, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel25, java.awt.BorderLayout.PAGE_START);

        jPanel26.setBackground(new java.awt.Color(43, 43, 43));
        jPanel26.setPreferredSize(new java.awt.Dimension(1059, 20));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1414, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel26, java.awt.BorderLayout.PAGE_END);

        jPanel27.setBackground(new java.awt.Color(43, 43, 43));
        jPanel27.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel27, java.awt.BorderLayout.LINE_END);

        jPanel28.setBackground(new java.awt.Color(43, 43, 43));
        jPanel28.setPreferredSize(new java.awt.Dimension(10, 546));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel28, java.awt.BorderLayout.LINE_START);

        jPanel18.setBackground(new java.awt.Color(102, 102, 102));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(102, 102, 102));
        jPanel19.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel29.setPreferredSize(new java.awt.Dimension(1059, 25));
        jPanel29.setLayout(new java.awt.BorderLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Invoice Count");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel29.add(jLabel26, java.awt.BorderLayout.CENTER);

        jPanel19.add(jPanel29, java.awt.BorderLayout.PAGE_START);

        jPanel30.setLayout(new java.awt.BorderLayout());

        jPanel31.setPreferredSize(new java.awt.Dimension(1059, 35));
        jPanel31.setLayout(new java.awt.BorderLayout());

        jPanel39.setPreferredSize(new java.awt.Dimension(90, 130));
        jPanel39.setLayout(new java.awt.BorderLayout());

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Today     :");
        jPanel39.add(jLabel27, java.awt.BorderLayout.CENTER);

        jPanel31.add(jPanel39, java.awt.BorderLayout.LINE_START);

        jPanel40.setLayout(new java.awt.BorderLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 0, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Invoice Count");
        jPanel40.add(jLabel28, java.awt.BorderLayout.CENTER);

        jPanel31.add(jPanel40, java.awt.BorderLayout.CENTER);

        jPanel30.add(jPanel31, java.awt.BorderLayout.PAGE_START);

        jPanel32.setLayout(new java.awt.BorderLayout());

        jPanel33.setPreferredSize(new java.awt.Dimension(1059, 35));
        jPanel33.setLayout(new java.awt.BorderLayout());

        jPanel41.setPreferredSize(new java.awt.Dimension(90, 130));
        jPanel41.setLayout(new java.awt.BorderLayout());

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Monthly :");
        jPanel41.add(jLabel29, java.awt.BorderLayout.CENTER);

        jPanel33.add(jPanel41, java.awt.BorderLayout.LINE_START);

        jPanel42.setLayout(new java.awt.BorderLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 0, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Invoice Count");
        jPanel42.add(jLabel30, java.awt.BorderLayout.CENTER);

        jPanel33.add(jPanel42, java.awt.BorderLayout.CENTER);

        jPanel32.add(jPanel33, java.awt.BorderLayout.PAGE_START);

        jPanel35.setLayout(new java.awt.BorderLayout());

        jPanel43.setPreferredSize(new java.awt.Dimension(90, 130));
        jPanel43.setLayout(new java.awt.BorderLayout());

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Annualy :");
        jPanel43.add(jLabel31, java.awt.BorderLayout.CENTER);

        jPanel35.add(jPanel43, java.awt.BorderLayout.LINE_START);

        jPanel44.setLayout(new java.awt.BorderLayout());

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 0, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Invoice Count");
        jPanel44.add(jLabel32, java.awt.BorderLayout.CENTER);

        jPanel35.add(jPanel44, java.awt.BorderLayout.CENTER);

        jPanel32.add(jPanel35, java.awt.BorderLayout.CENTER);

        jPanel30.add(jPanel32, java.awt.BorderLayout.CENTER);

        jPanel19.add(jPanel30, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel19, java.awt.BorderLayout.LINE_START);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new java.awt.BorderLayout());

        jPanel21.setBackground(new java.awt.Color(43, 43, 43));
        jPanel21.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel21, java.awt.BorderLayout.LINE_START);

        jPanel23.setLayout(new java.awt.BorderLayout());

        jPanel24.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel59.setLayout(new java.awt.BorderLayout());

        jPanel60.setBackground(new java.awt.Color(51, 51, 51));
        jPanel60.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel60.setLayout(new java.awt.BorderLayout());

        jPanel61.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/td.png"))); // NOI18N
        jPanel61.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel60.add(jPanel61, java.awt.BorderLayout.CENTER);

        jPanel62.setForeground(new java.awt.Color(250, 250, 250));
        jPanel62.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel62.setLayout(new java.awt.BorderLayout());

        jLabel24.setBackground(new java.awt.Color(250, 250, 250));
        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(242, 242, 242));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Today Sales ");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        jPanel62.add(jLabel24, java.awt.BorderLayout.CENTER);

        jPanel60.add(jPanel62, java.awt.BorderLayout.PAGE_END);

        jPanel59.add(jPanel60, java.awt.BorderLayout.PAGE_START);

        jPanel63.setForeground(new java.awt.Color(255, 255, 255));
        jPanel63.setLayout(new java.awt.BorderLayout());

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(207, 0, 6));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel63.add(jLabel25, java.awt.BorderLayout.CENTER);

        jPanel59.add(jPanel63, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel59, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel24, java.awt.BorderLayout.LINE_START);

        jPanel34.setLayout(new java.awt.BorderLayout());

        jPanel36.setBackground(new java.awt.Color(43, 43, 43));
        jPanel36.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel34.add(jPanel36, java.awt.BorderLayout.LINE_START);

        jPanel37.setLayout(new java.awt.BorderLayout());

        jPanel38.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel38MouseClicked(evt);
            }
        });
        jPanel38.setLayout(new java.awt.BorderLayout());

        jPanel45.setLayout(new java.awt.BorderLayout());

        jPanel54.setLayout(new java.awt.BorderLayout());

        jPanel55.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel55.setLayout(new java.awt.BorderLayout());

        jPanel56.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/vs1.png"))); // NOI18N
        jPanel56.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel55.add(jPanel56, java.awt.BorderLayout.CENTER);

        jPanel57.setForeground(new java.awt.Color(250, 250, 250));
        jPanel57.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel57.setLayout(new java.awt.BorderLayout());

        jLabel21.setBackground(new java.awt.Color(250, 250, 250));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(242, 242, 242));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Weekly Sales ");
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 1, 0));
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel57.add(jLabel21, java.awt.BorderLayout.CENTER);

        jPanel55.add(jPanel57, java.awt.BorderLayout.PAGE_END);

        jPanel54.add(jPanel55, java.awt.BorderLayout.PAGE_START);

        jPanel58.setForeground(new java.awt.Color(255, 255, 255));
        jPanel58.setLayout(new java.awt.BorderLayout());

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(207, 0, 6));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel58.add(jLabel22, java.awt.BorderLayout.CENTER);

        jPanel54.add(jPanel58, java.awt.BorderLayout.CENTER);

        jPanel45.add(jPanel54, java.awt.BorderLayout.CENTER);

        jPanel38.add(jPanel45, java.awt.BorderLayout.CENTER);

        jPanel37.add(jPanel38, java.awt.BorderLayout.LINE_START);

        jPanel46.setLayout(new java.awt.BorderLayout());

        jPanel47.setBackground(new java.awt.Color(43, 43, 43));
        jPanel47.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel46.add(jPanel47, java.awt.BorderLayout.LINE_START);

        jPanel48.setLayout(new java.awt.BorderLayout());

        jPanel49.setPreferredSize(new java.awt.Dimension(195, 130));
        jPanel49.setLayout(new java.awt.BorderLayout());

        jPanel50.setLayout(new java.awt.BorderLayout());

        jPanel51.setLayout(new java.awt.BorderLayout());

        jPanel52.setBackground(new java.awt.Color(51, 51, 51));
        jPanel52.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel52.setLayout(new java.awt.BorderLayout());

        jPanel53.setLayout(new java.awt.BorderLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ts.png"))); // NOI18N
        jPanel53.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel52.add(jPanel53, java.awt.BorderLayout.CENTER);

        jPanel64.setForeground(new java.awt.Color(250, 250, 250));
        jPanel64.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel64.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(250, 250, 250));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(242, 242, 242));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Monthly Sales ");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        jPanel64.add(jLabel18, java.awt.BorderLayout.CENTER);

        jPanel52.add(jPanel64, java.awt.BorderLayout.PAGE_END);

        jPanel51.add(jPanel52, java.awt.BorderLayout.PAGE_START);

        jPanel65.setForeground(new java.awt.Color(255, 255, 255));
        jPanel65.setLayout(new java.awt.BorderLayout());

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(207, 0, 6));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel65.add(jLabel19, java.awt.BorderLayout.CENTER);

        jPanel51.add(jPanel65, java.awt.BorderLayout.CENTER);

        jPanel50.add(jPanel51, java.awt.BorderLayout.CENTER);

        jPanel49.add(jPanel50, java.awt.BorderLayout.CENTER);

        jPanel48.add(jPanel49, java.awt.BorderLayout.LINE_START);

        jPanel66.setLayout(new java.awt.BorderLayout());

        jPanel67.setBackground(new java.awt.Color(43, 43, 43));
        jPanel67.setPreferredSize(new java.awt.Dimension(10, 130));

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel66.add(jPanel67, java.awt.BorderLayout.LINE_START);

        jPanel68.setLayout(new java.awt.BorderLayout());

        jPanel69.setPreferredSize(new java.awt.Dimension(195, 90));
        jPanel69.setLayout(new java.awt.BorderLayout());

        jPanel70.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ann.png"))); // NOI18N
        jPanel70.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel69.add(jPanel70, java.awt.BorderLayout.CENTER);

        jPanel71.setForeground(new java.awt.Color(250, 250, 250));
        jPanel71.setPreferredSize(new java.awt.Dimension(1059, 20));
        jPanel71.setLayout(new java.awt.BorderLayout());

        jLabel15.setBackground(new java.awt.Color(250, 250, 250));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(242, 242, 242));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Annualy Sales ");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel71.add(jLabel15, java.awt.BorderLayout.CENTER);

        jPanel69.add(jPanel71, java.awt.BorderLayout.PAGE_END);

        jPanel68.add(jPanel69, java.awt.BorderLayout.PAGE_START);

        jPanel72.setForeground(new java.awt.Color(255, 255, 255));
        jPanel72.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(207, 0, 6));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel72.add(jLabel17, java.awt.BorderLayout.CENTER);

        jPanel68.add(jPanel72, java.awt.BorderLayout.CENTER);

        jPanel66.add(jPanel68, java.awt.BorderLayout.CENTER);

        jPanel48.add(jPanel66, java.awt.BorderLayout.CENTER);

        jPanel46.add(jPanel48, java.awt.BorderLayout.CENTER);

        jPanel37.add(jPanel46, java.awt.BorderLayout.CENTER);

        jPanel34.add(jPanel37, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel34, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel23, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel17.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        jPanel73.setLayout(new java.awt.BorderLayout());

        jPanel74.setLayout(new java.awt.BorderLayout());

        jPanel75.setPreferredSize(new java.awt.Dimension(376, 50));

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1414, Short.MAX_VALUE)
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel74.add(jPanel75, java.awt.BorderLayout.PAGE_START);

        jPanel76.setLayout(new java.awt.BorderLayout());

        jPanel77.setPreferredSize(new java.awt.Dimension(350, 326));
        jPanel77.setLayout(new java.awt.BorderLayout());

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));
        jPanel79.setLayout(new java.awt.BorderLayout());
        jPanel77.add(jPanel79, java.awt.BorderLayout.CENTER);

        jPanel76.add(jPanel77, java.awt.BorderLayout.LINE_START);

        jPanel80.setLayout(new java.awt.BorderLayout());

        jPanel81.setPreferredSize(new java.awt.Dimension(10, 326));

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        jPanel80.add(jPanel81, java.awt.BorderLayout.LINE_START);

        jPanel82.setLayout(new java.awt.BorderLayout());
        jPanel80.add(jPanel82, java.awt.BorderLayout.CENTER);

        jPanel76.add(jPanel80, java.awt.BorderLayout.CENTER);

        jPanel74.add(jPanel76, java.awt.BorderLayout.CENTER);

        jPanel73.add(jPanel74, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel73, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Snack", jPanel7);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked

    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered

    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited

    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked

    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered

    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited

    }//GEN-LAST:event_jLabel21MouseExited

    private void jPanel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseClicked

    }//GEN-LAST:event_jPanel38MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered

    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited

    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered

    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited

    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jPanel123MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel123MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel123MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel153;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
