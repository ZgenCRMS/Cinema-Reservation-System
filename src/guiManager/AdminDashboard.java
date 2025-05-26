/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guiManager;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.raven.chart.ModelChart;
import guiLogin.LogingOption;
import guiSnackbar.Manager.snackbarDashboard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Geeth Kalhara
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public AdminDashboard() {
        initComponents();
        progressChart();
        setLiveDateTime(jLabel8);
        loadDashboard();

//        Frame();
    }

    private void loadDashboard() {
        jPanel24.removeAll();

        EmployeeManage employeeManage = new EmployeeManage();
        jPanel24.add(employeeManage, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);
    }

    public void setLiveDateTime(javax.swing.JLabel jLabel8) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateTime = sdf.format(now);
                jLabel8.setText(dateTime);
            }
        });
        timer.start();
    }

    public void progressChart() {

//        progress1.start();
//        progress2.start();
//        progress3.start();
//        progress4.start();
//
//        chart1.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
//        chart1.addLegend("Expense", new Color(54, 4, 143), new Color(104, 48, 200));
//        chart1.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
//        chart1.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
//        chart1.addData(new ModelChart("January", new double[]{800, 600, 500, 700}));
//        chart1.addData(new ModelChart("February", new double[]{600, 750, 600, 350}));
//        chart1.addData(new ModelChart("March", new double[]{400, 350, 460, 600}));
//        chart1.addData(new ModelChart("April", new double[]{580, 350, 750, 700}));
//        chart1.addData(new ModelChart("May", new double[]{650, 440, 570, 650}));
//        chart1.addData(new ModelChart("June", new double[]{390, 480, 400, 500}));
//        chart1.addData(new ModelChart("July", new double[]{500, 480, 400, 300}));
//
//        chart1.start();
//
//        chart2.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
//        chart2.addLegend("Expense", new Color(54, 4, 143), new Color(104, 48, 200));
//        chart2.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
//        chart2.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
//        chart2.addData(new ModelChart("January", new double[]{800, 600, 500, 700}));
//        chart2.addData(new ModelChart("February", new double[]{600, 750, 600, 350}));
//        chart2.addData(new ModelChart("March", new double[]{400, 350, 460, 600}));
//        chart2.addData(new ModelChart("April", new double[]{580, 350, 750, 700}));
//        chart2.addData(new ModelChart("May", new double[]{650, 440, 570, 650}));
//        chart2.addData(new ModelChart("June", new double[]{390, 480, 400, 500}));
//        chart2.addData(new ModelChart("July", new double[]{500, 480, 400, 300}));
//
//        chart2.start();
    }

    public void Frame() {
        setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();

        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");

        jPanel1.setBackground(new java.awt.Color(0, 34, 68));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(31, 35, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(215, 100));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/cinema (2).png"))); // NOI18N
        jPanel4.add(jLabel1);

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(31, 35, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(215, 100));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(31, 35, 51));
        jPanel11.setPreferredSize(new java.awt.Dimension(205, 100));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(31, 35, 51));
        jPanel12.setPreferredSize(new java.awt.Dimension(205, 60));

        jLabel5.setText("    ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/contacts-32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(44, 44, 44))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(8, Short.MAX_VALUE)))
        );

        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(31, 35, 51));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("2024/05/09   10.00 PM");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/clock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel11, java.awt.BorderLayout.LINE_START);

        jPanel1.add(jPanel5, java.awt.BorderLayout.LINE_END);

        jPanel6.setBackground(new java.awt.Color(31, 35, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(20, 22, 32));
        jPanel2.setPreferredSize(new java.awt.Dimension(215, 700));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(20, 22, 32));
        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(215, 100));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logout-24.png"))); // NOI18N
        jButton1.setText("Logout");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel2.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPanel14.setBackground(new java.awt.Color(20, 22, 32));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(20, 22, 32));
        jPanel15.setPreferredSize(new java.awt.Dimension(215, 80));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel14.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jPanel16.setBackground(new java.awt.Color(20, 22, 32));
        jPanel16.setPreferredSize(new java.awt.Dimension(215, 500));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel17.setPreferredSize(new java.awt.Dimension(215, 0));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        jPanel18.setPreferredSize(new java.awt.Dimension(215, 0));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel18, java.awt.BorderLayout.PAGE_END);

        jPanel19.setBackground(new java.awt.Color(20, 22, 32));
        jPanel19.setPreferredSize(new java.awt.Dimension(5, 470));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel19, java.awt.BorderLayout.LINE_END);

        jPanel20.setBackground(new java.awt.Color(20, 22, 32));
        jPanel20.setPreferredSize(new java.awt.Dimension(5, 470));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel20, java.awt.BorderLayout.LINE_START);

        jPanel21.setBackground(new java.awt.Color(20, 22, 32));
        jPanel21.setLayout(new java.awt.GridLayout(8, 1, 0, 8));

        jButton9.setBackground(new java.awt.Color(31, 35, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/132301_list_clien_icon.png"))); // NOI18N
        jButton9.setText("Manage Employee");
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton9);

        jButton10.setBackground(new java.awt.Color(31, 35, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/male_female_users.png"))); // NOI18N
        jButton10.setText("View All Customer");
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton10);

        jButton11.setBackground(new java.awt.Color(31, 35, 51));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/video-player.png"))); // NOI18N
        jButton11.setText("Movie Manage");
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton11);

        jButton12.setBackground(new java.awt.Color(31, 35, 51));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/schedule.png"))); // NOI18N
        jButton12.setText("Schedule Manage");
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton12);

        jButton14.setBackground(new java.awt.Color(31, 35, 51));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8-note-24.png"))); // NOI18N
        jButton14.setText("View All MRN");
        jButton14.setBorderPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton14);

        jButton4.setBackground(new java.awt.Color(31, 35, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ticket.png"))); // NOI18N
        jButton4.setText("Ticket Prices");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton4);

        jButton15.setBackground(new java.awt.Color(31, 35, 51));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/report.png"))); // NOI18N
        jButton15.setText("Report");
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton15);

        jPanel16.add(jPanel21, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel14, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel25.setLayout(new java.awt.BorderLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(809, 342));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel9.setPreferredSize(new java.awt.Dimension(200, 342));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setPreferredSize(new java.awt.Dimension(200, 5));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel29, java.awt.BorderLayout.PAGE_START);

        jPanel30.setBackground(new java.awt.Color(51, 51, 51));
        jPanel30.setPreferredSize(new java.awt.Dimension(200, 5));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel30, java.awt.BorderLayout.PAGE_END);

        jPanel31.setLayout(new java.awt.BorderLayout());

        jPanel32.setBackground(new java.awt.Color(51, 51, 51));
        jPanel32.setPreferredSize(new java.awt.Dimension(5, 332));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jPanel31.add(jPanel32, java.awt.BorderLayout.LINE_START);

        jPanel33.setLayout(new java.awt.BorderLayout());

        jPanel34.setBackground(new java.awt.Color(51, 51, 51));
        jPanel34.setPreferredSize(new java.awt.Dimension(5, 332));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jPanel33.add(jPanel34, java.awt.BorderLayout.LINE_END);

        jPanel35.setBackground(new java.awt.Color(51, 51, 51));
        jPanel35.setLayout(new java.awt.GridLayout(1, 0));
        jPanel33.add(jPanel35, java.awt.BorderLayout.CENTER);

        jPanel31.add(jPanel33, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel31, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9, java.awt.BorderLayout.LINE_START);

        jPanel26.setLayout(new java.awt.BorderLayout());

        jPanel36.setBackground(new java.awt.Color(51, 51, 51));
        jPanel36.setPreferredSize(new java.awt.Dimension(609, 5));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel36, java.awt.BorderLayout.PAGE_START);

        jPanel37.setBackground(new java.awt.Color(51, 51, 51));
        jPanel37.setPreferredSize(new java.awt.Dimension(609, 5));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel37, java.awt.BorderLayout.PAGE_END);

        jPanel38.setLayout(new java.awt.BorderLayout());

        jPanel39.setBackground(new java.awt.Color(51, 51, 51));
        jPanel39.setPreferredSize(new java.awt.Dimension(5, 332));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jPanel38.add(jPanel39, java.awt.BorderLayout.LINE_END);

        jPanel40.setBackground(new java.awt.Color(51, 51, 51));
        jPanel40.setLayout(new java.awt.GridLayout(1, 0));
        jPanel38.add(jPanel40, java.awt.BorderLayout.CENTER);

        jPanel26.add(jPanel38, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel26, java.awt.BorderLayout.CENTER);

        jPanel25.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.BorderLayout());

        jPanel27.setPreferredSize(new java.awt.Dimension(200, 342));
        jPanel27.setLayout(new java.awt.BorderLayout());

        jPanel41.setBackground(new java.awt.Color(51, 51, 51));
        jPanel41.setPreferredSize(new java.awt.Dimension(200, 2));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel27.add(jPanel41, java.awt.BorderLayout.PAGE_START);

        jPanel42.setPreferredSize(new java.awt.Dimension(200, 5));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel27.add(jPanel42, java.awt.BorderLayout.PAGE_END);

        jPanel43.setLayout(new java.awt.BorderLayout());

        jPanel44.setBackground(new java.awt.Color(51, 51, 51));
        jPanel44.setPreferredSize(new java.awt.Dimension(5, 332));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        jPanel43.add(jPanel44, java.awt.BorderLayout.LINE_START);

        jPanel45.setLayout(new java.awt.BorderLayout());

        jPanel46.setBackground(new java.awt.Color(51, 51, 51));
        jPanel46.setPreferredSize(new java.awt.Dimension(5, 332));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        jPanel45.add(jPanel46, java.awt.BorderLayout.LINE_END);

        jPanel47.setBackground(new java.awt.Color(51, 51, 51));
        jPanel47.setLayout(new java.awt.GridLayout(1, 0));
        jPanel45.add(jPanel47, java.awt.BorderLayout.CENTER);

        jPanel43.add(jPanel45, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel43, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel27, java.awt.BorderLayout.LINE_START);

        jPanel28.setLayout(new java.awt.BorderLayout());

        jPanel48.setBackground(new java.awt.Color(51, 51, 51));
        jPanel48.setPreferredSize(new java.awt.Dimension(609, 2));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel48, java.awt.BorderLayout.PAGE_START);

        jPanel49.setPreferredSize(new java.awt.Dimension(609, 5));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel49, java.awt.BorderLayout.PAGE_END);

        jPanel50.setLayout(new java.awt.BorderLayout());

        jPanel51.setBackground(new java.awt.Color(51, 51, 51));
        jPanel51.setPreferredSize(new java.awt.Dimension(5, 332));

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel51, java.awt.BorderLayout.LINE_END);

        jPanel52.setBackground(new java.awt.Color(51, 51, 51));
        jPanel52.setLayout(new java.awt.GridLayout(1, 0));
        jPanel50.add(jPanel52, java.awt.BorderLayout.CENTER);

        jPanel28.add(jPanel50, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel28, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel25.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel25, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel24, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        jPanel24.removeAll();

        EmployeeManage employeeManage = new EmployeeManage();
        jPanel24.add(employeeManage, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

//         ManageMovie manageMovie = new ManageMovie();
//         manageMovie.setVisible(true);
        jPanel24.removeAll();

        MovieManage movieManage = new MovieManage();
        jPanel24.add(movieManage, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);


    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jPanel24.removeAll();

        CustomersView customersView = new CustomersView();
        jPanel24.add(customersView, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
//        SheduleManagement sheduleManagement = new SheduleManagement();
//        sheduleManagement.setVisible(true);

        jPanel24.removeAll();

        MovieScheduleTime movieScheduleTime = new MovieScheduleTime();
        jPanel24.add(movieScheduleTime, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        jPanel24.removeAll();

        ViewAllMRN viewAll = new ViewAllMRN();
        jPanel24.add(viewAll, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        jPanel24.removeAll();

        TicketsPrice ticketsPrice = new TicketsPrice();
        jPanel24.add(ticketsPrice, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LogingOption loginoption = new LogingOption();
        loginoption.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        jPanel24.removeAll();

        guiManager.movie Movie = new guiManager.movie();
        jPanel24.add(Movie, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel24);

    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables

}
