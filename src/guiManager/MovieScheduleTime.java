/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package guiManager;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.mySQL;

/**
 *
 * @author Geeth Kalhara
 */
public class MovieScheduleTime extends javax.swing.JPanel {

    private static HashMap<String, String> LoadsMovieMap = new HashMap<>();
    private static HashMap<String, String> LoadMovieHallMap = new HashMap<>();
    private static HashMap<String, String> LanguageMap = new HashMap<>();
    private static HashMap<String, String> LoadTimeSlotMap = new HashMap<>();

    public MovieScheduleTime() {
        initComponents();
        loadMovieHall();
        loadMovieName();
        loadStartEndTime();
        loadMovieTimeSchedule();
        jButton5.setEnabled(false);
    }

    private void loadMovieName() {
        try {
            ResultSet resultset = mySQL.executeSearch("SELECT * FROM `movie`");
            Vector<String> vector = new Vector<>();
            vector.add("select");
            while (resultset.next()) {
                vector.add(resultset.getString("name"));
                LoadsMovieMap.put(resultset.getString("name"), resultset.getString("movie_id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadStartEndTime() {
        try {
            ResultSet resultset = mySQL.executeSearch("SELECT * FROM `time_slot`");
            Vector<String> vector = new Vector<>();
            vector.add("select");
            while (resultset.next()) {
                vector.add(resultset.getString("start_time") + " " + resultset.getString("end_time"));
                LoadTimeSlotMap.put(resultset.getString("start_time"), resultset.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox3.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadMovieHall() {
        try {
            ResultSet resultset = mySQL.executeSearch("SELECT * FROM `hall`");
            Vector<String> vector = new Vector<>();
            vector.add("select");
            while (resultset.next()) {
                vector.add(resultset.getString("hall_number"));
                LoadMovieHallMap.put(resultset.getString("hall_number"), resultset.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadMovieTimeSchedule() {

        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `schedule` "
                    + "INNER JOIN `movie` ON `schedule`.`movie_movie_id`=`movie`.`movie_id`"
                    + "INNER JOIN `hall` ON `schedule`.`hall_id`=`hall`.`id`"
                    + "INNER JOIN `time_slot` ON `schedule`.`time_Slot_id`=`time_slot`.`id`");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("movie.name"));
                vector.add(resultSet.getString("hall.hall_number"));
                vector.add(resultSet.getString("schedule_date"));
                vector.add(resultSet.getString("time_slot.start_time"));
                vector.add(resultSet.getString("time_slot.end_time"));

                vector.add(resultSet.getString("start_date"));
                vector.add(resultSet.getString("end_date"));

                dtm.addRow(vector);

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
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(949, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(949, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setPreferredSize(new java.awt.Dimension(10, 600));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel4.setPreferredSize(new java.awt.Dimension(10, 600));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(929, 50));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/schedule.png"))); // NOI18N
        jLabel1.setText("Schedule Management");
        jPanel6.add(jLabel1);

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(929, 5));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setPreferredSize(new java.awt.Dimension(929, 5));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(220, 540));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel25.setPreferredSize(new java.awt.Dimension(220, 5));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel14.add(jPanel25, java.awt.BorderLayout.PAGE_START);

        jPanel26.setLayout(new java.awt.BorderLayout());

        jPanel27.setPreferredSize(new java.awt.Dimension(220, 5));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel27, java.awt.BorderLayout.PAGE_END);

        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Movie Name");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Movie Hall No.");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Time Slot");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox3MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Start Date");

        jDateChooser2.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("End Date");

        jButton4.setBackground(new java.awt.Color(24, 119, 242));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add");
        jButton4.setBorderPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.setPreferredSize(new java.awt.Dimension(75, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(24, 119, 242));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Update");
        jButton5.setBorderPainted(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton5.setPreferredSize(new java.awt.Dimension(75, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");
        jButton6.setBorderPainted(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton6.setPreferredSize(new java.awt.Dimension(75, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jDateChooser4.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, 208, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, 208, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.add(jPanel29, java.awt.BorderLayout.CENTER);

        jPanel26.add(jPanel28, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel26, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel14, java.awt.BorderLayout.LINE_START);

        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel10.setPreferredSize(new java.awt.Dimension(5, 540));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel10, java.awt.BorderLayout.LINE_START);

        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel17.setPreferredSize(new java.awt.Dimension(704, 45));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel30.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanel30.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jButton8.setBackground(new java.awt.Color(24, 119, 242));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Add Time Slot");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel30.add(jButton8);

        jPanel17.add(jPanel30, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel31, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel19.setPreferredSize(new java.awt.Dimension(704, 5));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jPanel20.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.BorderLayout());

        jPanel23.setPreferredSize(new java.awt.Dimension(704, 5));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel23, java.awt.BorderLayout.PAGE_END);

        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Movie Name", "Movie Hall", "Schedule Date", "Start Time", "End Time", "Start Date", "End Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel24.add(jScrollPane1);

        jPanel22.add(jPanel24, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel15.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //
        //        AddMovieDimension addMovieDimension = new AddMovieDimension(this, true);
        //        addMovieDimension.setVisible(true);
        new AddScheduleTimeSlot(null, true).show();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String MovieName = String.valueOf(jComboBox1.getSelectedItem());
        String MovieHall = String.valueOf(jComboBox2.getSelectedItem());
        String TimeSlot = String.valueOf(jComboBox3.getSelectedItem());
        Date StartDate = jDateChooser2.getDate();
        Date EndDate = jDateChooser4.getDate();

        // Input validation
        if (MovieName.equals("select")) {
            JOptionPane.showMessageDialog(this, "Please Select Movie", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (MovieHall.equals("select")) {
            JOptionPane.showMessageDialog(this, "Please Select Movie Hall", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (TimeSlot.equals("select")) {
            JOptionPane.showMessageDialog(this, "Please Select Time Slot", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (StartDate == null) {
            JOptionPane.showMessageDialog(this, "Please Enter Start Date", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (EndDate == null) {
            JOptionPane.showMessageDialog(this, "Please Select End Date", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!EndDate.after(StartDate)) {
            JOptionPane.showMessageDialog(this, "End date must be after the start date.", "Date Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);

            // Get today's date and add 1 day to get "tomorrow"
            Date today = new Date();
            String todayStr = sdf.format(today);
            Date cleanToday = sdf.parse(todayStr);

            // Add 1 day to today
            long oneDayInMillis = 24 * 60 * 60 * 1000;
            Date tomorrow = new Date(cleanToday.getTime() + oneDayInMillis);

            // 🔥 Validate: StartDate must be tomorrow or later
            if (StartDate.before(tomorrow)) {
                JOptionPane.showMessageDialog(null, "❌ Invalid Start Date.\nStart Date must be at least tomorrow or later.");
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "⚠️ Invalid date format.\nUse yyyy-MM-dd (e.g., 2025-05-22).");
        }

        try {
            // Validate if a conflicting schedule already exists
            int hallId = Integer.parseInt(LoadMovieHallMap.get(MovieHall));
            int timeSlotId = jComboBox3.getSelectedIndex(); // or LoadTimeSlotMap.get(TimeSlot) if you have one
            java.sql.Date sqlStart = new java.sql.Date(StartDate.getTime());
            java.sql.Date sqlEnd = new java.sql.Date(EndDate.getTime());

            String query = "SELECT * FROM `schedule` WHERE `hall_id` = '" + hallId + "' AND `time_slot_id` = '" + timeSlotId + "' "
                    + "AND ((`start_date` <= '" + sqlEnd + "' AND `end_date` >= '" + sqlStart + "'))";

            ResultSet rs = mySQL.executeSearch(query);

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Schedule conflict detected! This time slot is already in use in the selected hall during that date range.", "Conflict Detected", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Proceed with inserting the schedule
            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            mySQL.executeIUD("INSERT INTO `schedule`(`schedule_date`, `movie_movie_id`, `hall_id`, `time_slot_id`, `start_date`, `end_date`) VALUES ("
                    + "'" + sdf.format(today) + "', "
                    + "'" + LoadsMovieMap.get(MovieName) + "', "
                    + "'" + hallId + "', "
                    + "'" + timeSlotId + "', "
                    + "'" + sdf.format(StartDate) + "', "
                    + "'" + sdf.format(EndDate) + "')");

            loadMovieTimeSchedule();
            jButton5.setEnabled(false);
            reset();
            JOptionPane.showMessageDialog(this, "Movie Schedule Time successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while processing the schedule. Please check your inputs and try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
//        int selectedTimeSlotId = -1;

        jComboBox3.setEnabled(false);
        jButton5.setEnabled(true);
        jButton4.setEnabled(false);
        jComboBox1.setEnabled(false);

        int row = jTable1.getSelectedRow();

        // Movie & Hall
        String moviename = String.valueOf(jTable1.getValueAt(row, 1));
        jComboBox1.setSelectedItem(moviename);

        String moviehall = String.valueOf(jTable1.getValueAt(row, 2));
        jComboBox2.setSelectedItem(moviehall);

        // 🕒 Get start_time and end_time from table (Column 4 & 5)
        String startTime = String.valueOf(jTable1.getValueAt(row, 4));
        String endTime = String.valueOf(jTable1.getValueAt(row, 5));

// 🔎 Search for matching time_slot ID
        try {
            String timeSlotQuery = "SELECT id FROM time_slot WHERE start_time = '" + startTime + "' AND end_time = '" + endTime + "'";
            ResultSet resultSet = mySQL.executeSearch(timeSlotQuery);

//            if (resultSet.next()) {
//                selectedTimeSlotId = resultSet.getInt("id");
//                System.out.println(selectedTimeSlotIdd);
//            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Time Slot Matching (🔥 FIXED VERSION)
        boolean found = false;

        for (int i = 0; i < jComboBox3.getItemCount(); i++) {
            String item = jComboBox3.getItemAt(i).toString().trim();

            // Split combo box time slot like "10:00:00 12:00:00"
            if (item.startsWith(startTime)) {
                jComboBox3.setSelectedIndex(i); // 💯 set by index — avoids string compare bugs
                found = true;
                break;
            }
        }

        if (!found) {
            jComboBox3.setSelectedIndex(0); // Or -1, or show error
        }

        // Start & End Dates (working before, keep as-is)
        String startDate = String.valueOf(jTable1.getValueAt(row, 6));
        String endDate = String.valueOf(jTable1.getValueAt(row, 7));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date2 = dateFormat.parse(startDate);
            jDateChooser2.setDate(date2);

            Date date3 = dateFormat.parse(endDate);
            jDateChooser4.setDate(date3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jComboBox2.grabFocus();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseClicked
        jDateChooser2.grabFocus();
    }//GEN-LAST:event_jComboBox3MouseClicked

    private void jDateChooser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseClicked
        jDateChooser4.grabFocus();
    }//GEN-LAST:event_jDateChooser2MouseClicked

    private void jDateChooser4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser4MouseClicked
        jButton4.grabFocus();
    }//GEN-LAST:event_jDateChooser4MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        int row = jTable1.getSelectedRow();
//        if (row == -1) {
//            JOptionPane.showMessageDialog(this, "Please Select Movie", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        String movieID = String.valueOf(jTable1.getValueAt(row, 0));
//        String MovieName = String.valueOf(jComboBox1.getSelectedItem());
//        String MovieHall = String.valueOf(jComboBox2.getSelectedItem());
//        String TimeSlot = String.valueOf(jComboBox3.getSelectedItem()); // not index!
//        Date StartDate = jDateChooser2.getDate();
//        Date EndDate = jDateChooser4.getDate();
//        System.out.println(TimeSlot);
//// Validation
//        if (MovieName.equals("select")) {
//            JOptionPane.showMessageDialog(this, "Please Select Movie", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if (MovieHall.equals("select")) {
//            JOptionPane.showMessageDialog(this, "Please Select Movie Hall", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if (TimeSlot.equals("select")) {
//            JOptionPane.showMessageDialog(this, "Please Select Time Slot", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if (StartDate == null) {
//            JOptionPane.showMessageDialog(this, "Please Enter Start Date", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if (EndDate == null) {
//            JOptionPane.showMessageDialog(this, "Please Select End Date", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if (!EndDate.after(StartDate)) {
//            JOptionPane.showMessageDialog(this, "End date must be after the start date.", "Date Error", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//// All good — go ahead and update the DB
//        try {
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Use lowercase 'yyyy'
//
//            ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `schedule` WHERE  `end_date` = '" + sdf.format(EndDate) + "' AND `start_date` = '" + sdf.format(StartDate) + "'  AND `movie_movie_id` = '" + LoadsMovieMap.get(MovieName) + "' ");
//
//            if (resultSet.next()) {
//                JOptionPane.showMessageDialog(this, "Movie Schedule already registered", "Warning", JOptionPane.WARNING_MESSAGE);
//            } else {
//                mySQL.executeIUD("UPDATE `schedule` SET `schedule_date` = '" + sdf.format(date) + "', `movie_movie_id` = '" + LoadsMovieMap.get(MovieName) + "', `hall_id` = '" + LoadMovieHallMap.get(MovieHall) + "', `time_slot_id` = '" + TimeSlot + "',"
//                        + " `start_date` = '" + sdf.format(StartDate) + "', `end_date` = '" + sdf.format(EndDate) + "'"
//                        + " WHERE `id` = '" + movieID + "'");
//
//                loadMovieTimeSchedule();
//                reset();
//                JOptionPane.showMessageDialog(this, "Movie Schedule Time successfully Updated!", "Inform", JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please Select Movie", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String movieID = String.valueOf(jTable1.getValueAt(row, 0));
        String MovieName = String.valueOf(jComboBox1.getSelectedItem());
        String MovieHall = String.valueOf(jComboBox2.getSelectedItem());
        String TimeSlot = String.valueOf(jComboBox3.getSelectedItem()); // format: "03:00:00 05:00:00"
        Date StartDate = jDateChooser2.getDate();
        Date EndDate = jDateChooser4.getDate();

        // Validation
        if (MovieName.equals("select")) {
            JOptionPane.showMessageDialog(this, "Please Select Movie", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (MovieHall.equals("select")) {
            JOptionPane.showMessageDialog(this, "Please Select Movie Hall", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (TimeSlot.equals("select")) {
            JOptionPane.showMessageDialog(this, "Please Select Time Slot", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (StartDate == null) {
            JOptionPane.showMessageDialog(this, "Please Enter Start Date", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (EndDate == null) {
            JOptionPane.showMessageDialog(this, "Please Select End Date", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!EndDate.after(StartDate)) {
            JOptionPane.showMessageDialog(this, "End date must be after the start date.", "Date Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);

            // Get today's date and add 1 day to get "tomorrow"
            Date today = new Date();
            String todayStr = sdf.format(today);
            Date cleanToday = sdf.parse(todayStr);

            // Add 1 day to today
            long oneDayInMillis = 24 * 60 * 60 * 1000;
            Date tomorrow = new Date(cleanToday.getTime() + oneDayInMillis);

            // 🔥 Validate: StartDate must be tomorrow or later
            if (StartDate.before(tomorrow)) {
                JOptionPane.showMessageDialog(null, "❌ Invalid Start Date.\nStart Date must be at least tomorrow or later.");
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "⚠️ Invalid date format.\nUse yyyy-MM-dd (e.g., 2025-05-22).");
        }

        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Extract start_time and end_time from TimeSlot
            String[] timeParts = TimeSlot.split(" ");
            if (timeParts.length != 2) {
                JOptionPane.showMessageDialog(this, "Invalid Time Slot format", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String startTime = timeParts[0];
            String endTime = timeParts[1];
            String timeSlotID = null;

            // Find time slot ID
            ResultSet rsTime = mySQL.executeSearch("SELECT id FROM time_slot WHERE start_time = '" + startTime + "' AND end_time = '" + endTime + "'");
            if (rsTime.next()) {
                timeSlotID = rsTime.getString("id");
            } else {
                JOptionPane.showMessageDialog(this, "Matching Time Slot not found in database", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Check for existing schedule
            ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `schedule` WHERE `end_date` = '" + sdf.format(EndDate) + "' AND `start_date` = '" + sdf.format(StartDate) + "' AND `movie_movie_id` = '" + LoadsMovieMap.get(MovieName) + "'");
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Movie Schedule already registered", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Update the schedule
                mySQL.executeIUD("UPDATE `schedule` SET `schedule_date` = '" + sdf.format(date) + "', `movie_movie_id` = '" + LoadsMovieMap.get(MovieName) + "', `hall_id` = '" + LoadMovieHallMap.get(MovieHall) + "', `time_slot_id` = '" + timeSlotID + "',"
                        + "`start_date` = '" + sdf.format(StartDate) + "', `end_date` = '" + sdf.format(EndDate) + "' WHERE `id` = '" + movieID + "'");

                loadMovieTimeSchedule();
                reset();
                JOptionPane.showMessageDialog(this, "Movie Schedule Time successfully Updated!", "Inform", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jDateChooser2.setDate(null);
        jDateChooser4.setDate(null);
        jButton4.setEnabled(true);
        jTable1.clearSelection();
        jButton5.setEnabled(false);
        jComboBox3.setEnabled(true);
        jComboBox1.setEnabled(true);

    }
}
