/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package guiManager;

import guiSuperAdmin.*;
import guiSuperAdmin.*;
import com.formdev.flatlaf.FlatClientProperties;
import guiManager.AdminDashboard;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.DB;
import model.mySQL;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Laky
 */
public class movie extends javax.swing.JPanel {

    /**
     * Creates new form movie
     */
    public movie() {
        initComponents();
        LoadMovieTable();
        LoadInvoiceTable();
        loadMovieTimeSchedule();
        loadMovieGRN();
        loardCompany();
        loardSuppliers("fname", "ASC", "");
//        reload();
        hint();

    }

     private void hint() {
        if (jTextField9 != null) {
            jTextField9.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Movie Name");
        }
        if (jTextField10 != null) {
            jTextField10.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Movie Name");
        }
        if (jTextField11 != null) {
            jTextField11.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Invoice ID");
        }
        if (jTextField12 != null) {
            jTextField12.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Movie Name");
        }
        if (jTextField13 != null) {
                jTextField13.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Company Name");
        }
        if (jTextField14 != null) {
            jTextField14.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Supplier Name");
        }

    }

    /////////////////////////////////////
    private void moviestatechange() {

        if (jComboBox9.getSelectedIndex() == 0) {

            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `movie` "
                        + "INNER JOIN `movie_category` ON `movie`.`movie_category_id`=`movie_category`.`id`"
                        + "INNER JOIN `movie_dimension` ON `movie`.`movie_dimension_id`=`movie_dimension`.`id`"
                        + "INNER JOIN `language` ON `movie`.`language_id`=`language`.`id`  ORDER BY `movie`.`name` ASC ");

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);

                while (resultSet.next()) {
                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("movie_id"));
                    vector.add(resultSet.getString("name"));
                    vector.add(resultSet.getString("duration"));
                    vector.add(resultSet.getString("relased_date"));
                    vector.add(resultSet.getString("movie_category.name"));
                    vector.add(resultSet.getString("movie_dimension.type"));
                    vector.add(resultSet.getString("language.name"));

                    dtm.addRow(vector);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jComboBox9.getSelectedIndex() == 1) {
            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `movie` "
                        + "INNER JOIN `movie_category` ON `movie`.`movie_category_id`=`movie_category`.`id`"
                        + "INNER JOIN `movie_dimension` ON `movie`.`movie_dimension_id`=`movie_dimension`.`id`"
                        + "INNER JOIN `language` ON `movie`.`language_id`=`language`.`id` ORDER BY `movie`.`name` DESC ");

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);

                while (resultSet.next()) {
                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("movie_id"));
                    vector.add(resultSet.getString("name"));
                    vector.add(resultSet.getString("duration"));
                    vector.add(resultSet.getString("relased_date"));
                    vector.add(resultSet.getString("movie_category.name"));
                    vector.add(resultSet.getString("movie_dimension.type"));
                    vector.add(resultSet.getString("language.name"));

                    dtm.addRow(vector);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void MovieSearch() {

        try {
            String moviename = jTextField9.getText().trim();
            String query = "SELECT * FROM `movie` "
                    + "INNER JOIN `movie_category` ON `movie`.`movie_category_id`=`movie_category`.`id`"
                    + "INNER JOIN `movie_dimension` ON `movie`.`movie_dimension_id`=`movie_dimension`.`id`"
                    + "INNER JOIN `language` ON `movie`.`language_id`=`language`.`id`";

            if (!moviename.isEmpty()) {
                query += " WHERE `movie`.`name` LIKE '" + moviename + "%'";
            }

            java.sql.ResultSet resultSet = mySQL.executeSearch(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0); // clear existing rows

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("movie_id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("duration"));
                vector.add(resultSet.getString("relased_date"));
                vector.add(resultSet.getString("movie_category.name"));
                vector.add(resultSet.getString("movie_dimension.type"));
                vector.add(resultSet.getString("language.name"));

                dtm.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField9.setText("");
        jComboBox9.setSelectedIndex(0);
        LoadMovieTable();
    }

    private void InvoiceState() {

        if (jComboBox10.getSelectedIndex() == 0) {

            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT  * FROM `movie_invoiceitem` INNER JOIN `invoice` ON `movie_invoiceitem`.`invoice_id` = `invoice`.id "
                        + "INNER JOIN `ticket` ON `movie_invoiceitem`.`ticket_id` = `ticket`.`id` "
                        + "INNER JOIN `schedule` ON `movie_invoiceitem`.`schedule_id` = `schedule`.`id` "
                        + "INNER JOIN `payment_method` ON `invoice`.`payment_method_id` = `payment_method`.`id` "
                        + "INNER JOIN `movie` ON `schedule`.`movie_movie_id` = `movie`.`movie_id`"
                        + "INNER JOIN `movie_customer_type` ON `ticket`.`movie_customer_type_id` = `movie_customer_type`.`id`  ORDER BY `movie_invoiceitem`.`id` ASC ");

                DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
                dtm.setRowCount(0);

                while (resultSet.next()) {
                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("invoice.id"));
                    vector.add(resultSet.getString("movie.name"));
                    vector.add(resultSet.getString("schedule.hall_id"));
                    vector.add(resultSet.getString("sheet_number"));
                    vector.add(resultSet.getString("customer_mobile"));
                    vector.add(resultSet.getString("movie_customer_type.customer_type_name"));
                    vector.add(resultSet.getString("payment_method.name"));
                    vector.add(resultSet.getString("invoice.paid_amount"));
                    vector.add(resultSet.getString("invoice.qty"));
                    vector.add(resultSet.getString("invoice.user_email"));
                    vector.add(resultSet.getString("invoice.date"));

                    dtm.addRow(vector);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jComboBox10.getSelectedIndex() == 1) {
            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT  * FROM `movie_invoiceitem` INNER JOIN `invoice` ON `movie_invoiceitem`.`invoice_id` = `invoice`.id "
                        + "INNER JOIN `ticket` ON `movie_invoiceitem`.`ticket_id` = `ticket`.`id` "
                        + "INNER JOIN `schedule` ON `movie_invoiceitem`.`schedule_id` = `schedule`.`id` "
                        + "INNER JOIN `payment_method` ON `invoice`.`payment_method_id` = `payment_method`.`id` "
                        + "INNER JOIN `movie` ON `schedule`.`movie_movie_id` = `movie`.`movie_id`"
                        + "INNER JOIN `movie_customer_type` ON `ticket`.`movie_customer_type_id` = `movie_customer_type`.`id`  ORDER BY `movie_invoiceitem`.`id` DESC ");

                DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
                dtm.setRowCount(0);

                while (resultSet.next()) {
                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("invoice.id"));
                    vector.add(resultSet.getString("movie.name"));
                    vector.add(resultSet.getString("schedule.hall_id"));
                    vector.add(resultSet.getString("sheet_number"));
                    vector.add(resultSet.getString("customer_mobile"));
                    vector.add(resultSet.getString("movie_customer_type.customer_type_name"));
                    vector.add(resultSet.getString("payment_method.name"));
                    vector.add(resultSet.getString("invoice.paid_amount"));
                    vector.add(resultSet.getString("invoice.qty"));
                    vector.add(resultSet.getString("invoice.user_email"));
                    vector.add(resultSet.getString("invoice.date"));

                    dtm.addRow(vector);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void MovieInvoiceSearch() {
        try {
            String moviename = jTextField10.getText().trim();
            String query = "SELECT  * FROM `movie_invoiceitem` INNER JOIN `invoice` ON `movie_invoiceitem`.`invoice_id` = `invoice`.id "
                    + "INNER JOIN `ticket` ON `movie_invoiceitem`.`ticket_id` = `ticket`.`id` "
                    + "INNER JOIN `schedule` ON `movie_invoiceitem`.`schedule_id` = `schedule`.`id` "
                    + "INNER JOIN `payment_method` ON `invoice`.`payment_method_id` = `payment_method`.`id` "
                    + "INNER JOIN `movie` ON `schedule`.`movie_movie_id` = `movie`.`movie_id`"
                    + "INNER JOIN `movie_customer_type` ON `ticket`.`movie_customer_type_id` = `movie_customer_type`.`id`";

//            String query = "SELECT * FROM `employye_attendce` INNER JOIN `emp_qr` ON `employye_attendce`.`emp_qr_qr_number`=`emp_qr`.`qr_number`"
//                    + "INNER JOIN `attendce_type` ON `employye_attendce`.`attendce_type_id`=`attendce_type`.`id`";
            if (!moviename.isEmpty()) {
                query += " WHERE `movie`.`name` LIKE '" + moviename + "%'";
            }

            java.sql.ResultSet resultSet = mySQL.executeSearch(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0); // clear existing rows

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("invoice.id"));
                vector.add(resultSet.getString("movie.name"));
                vector.add(resultSet.getString("schedule.hall_id"));
                vector.add(resultSet.getString("sheet_number"));
                vector.add(resultSet.getString("customer_mobile"));
                vector.add(resultSet.getString("movie_customer_type.customer_type_name"));
                vector.add(resultSet.getString("payment_method.name"));
                vector.add(resultSet.getString("invoice.paid_amount"));
                vector.add(resultSet.getString("invoice.qty"));
                vector.add(resultSet.getString("invoice.user_email"));
                vector.add(resultSet.getString("invoice.date"));

                dtm.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void resetInvoice() {
        jTextField10.setText("");
        jComboBox10.setSelectedIndex(0);
        LoadInvoiceTable();
    }

    private void MovieScheduleState() {

        if (jComboBox11.getSelectedIndex() == 0) {

            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `schedule` "
                        + "INNER JOIN `movie` ON `schedule`.`movie_movie_id`=`movie`.`movie_id`"
                        + "INNER JOIN `hall` ON `schedule`.`hall_id`=`hall`.`id`"
                        + "INNER JOIN `time_slot` ON `schedule`.`time_Slot_id`=`time_slot`.`id` ORDER BY `movie`.`name` ASC ");

                DefaultTableModel dtm = (DefaultTableModel) jTable7.getModel();
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

        } else if (jComboBox11.getSelectedIndex() == 1) {
            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `schedule` "
                        + "INNER JOIN `movie` ON `schedule`.`movie_movie_id`=`movie`.`movie_id`"
                        + "INNER JOIN `hall` ON `schedule`.`hall_id`=`hall`.`id`"
                        + "INNER JOIN `time_slot` ON `schedule`.`time_Slot_id`=`time_slot`.`id` ORDER BY `movie`.`name` DESC ");

                DefaultTableModel dtm = (DefaultTableModel) jTable7.getModel();
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

    }

    private void MovieScheduleSearch() {

        try {
            String moviename = jTextField11.getText().trim();
            String query = "SELECT * FROM `schedule` "
                    + "INNER JOIN `movie` ON `schedule`.`movie_movie_id`=`movie`.`movie_id`"
                    + "INNER JOIN `hall` ON `schedule`.`hall_id`=`hall`.`id`"
                    + "INNER JOIN `time_slot` ON `schedule`.`time_Slot_id`=`time_slot`.`id`";

//            String query = "SELECT * FROM `employye_attendce` INNER JOIN `emp_qr` ON `employye_attendce`.`emp_qr_qr_number`=`emp_qr`.`qr_number`"
//                    + "INNER JOIN `attendce_type` ON `employye_attendce`.`attendce_type_id`=`attendce_type`.`id`";
            if (!moviename.isEmpty()) {
                query += " WHERE `movie`.`name` LIKE '" + moviename + "%'";
            }

            java.sql.ResultSet resultSet = mySQL.executeSearch(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable7.getModel();
            dtm.setRowCount(0); // clear existing rows

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

    private void resetMovie() {

        jTextField11.setText("");
        jComboBox11.setSelectedIndex(0);
        loadMovieTimeSchedule();
    }

    private void MRNstate() {

        if (jComboBox12.getSelectedIndex() == 0) {

            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `movie_grn` INNER JOIN `movie` ON "
                        + "`movie_grn`.`movie_movie_id` = `movie`.`movie_id`"
                        + "INNER JOIN `movie_supplier` ON "
                        + "`movie_grn`.`movie_supplier_supplier_mobile` = `movie_supplier`.supplier_mobile ORDER BY `movie`.`name` ASC");

                DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
                dtm.setRowCount(0);

                while (resultSet.next()) {

                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("id"));
                    vector.add(resultSet.getString("movie_supplier.supplier_mobile"));
                    vector.add(resultSet.getString("movie.name"));
                    vector.add(resultSet.getString("payed_amount"));

                    dtm.addRow(vector);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jComboBox12.getSelectedIndex() == 1) {
            try {
                ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `movie_grn` INNER JOIN `movie` ON "
                        + "`movie_grn`.`movie_movie_id` = `movie`.`movie_id`"
                        + "INNER JOIN `movie_supplier` ON "
                        + "`movie_grn`.`movie_supplier_supplier_mobile` = `movie_supplier`.supplier_mobile ORDER BY `movie`.`name` DESC");

                DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
                dtm.setRowCount(0);

                while (resultSet.next()) {

                    Vector<String> vector = new Vector<>();
                    vector.add(resultSet.getString("id"));
                    vector.add(resultSet.getString("movie_supplier.supplier_mobile"));
                    vector.add(resultSet.getString("movie.name"));
                    vector.add(resultSet.getString("payed_amount"));

                    dtm.addRow(vector);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void MRNsearch() {

        try {
            String grnid = jTextField12.getText().trim();
            String query = "SELECT * FROM `movie_grn` INNER JOIN `movie` ON "
                    + "`movie_grn`.`movie_movie_id` = `movie`.`movie_id`"
                    + "INNER JOIN `movie_supplier` ON "
                    + "`movie_grn`.`movie_supplier_supplier_mobile` = `movie_supplier`.supplier_mobile";

            if (!grnid.isEmpty()) {
                query += " WHERE `movie_grn`.`id` LIKE '" + grnid + "%'";
            }

            java.sql.ResultSet resultSet = mySQL.executeSearch(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0); // clear existing rows

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("movie_supplier.supplier_mobile"));
                vector.add(resultSet.getString("movie.name"));
                vector.add(resultSet.getString("payed_amount"));

                dtm.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void resetMRN() {

        jTextField12.setText("");
        jComboBox12.setSelectedIndex(0);
        loadMovieGRN();
    }

    private void companyState() {
        if (jComboBox13.getSelectedIndex() == 0) {

            try {

                java.sql.ResultSet result = mySQL.executeSearch("SELECT * FROM `movie_company` ORDER BY `movie_company`.`company_name` ASC");

                DefaultTableModel dtm = (DefaultTableModel) jTable8.getModel();
                dtm.setRowCount(0);

                while (result.next()) {
                    Vector<String> v = new Vector();
                    v.add(result.getString("Hotline"));
                    v.add(result.getString("company_name"));
                    v.add(result.getString("company_email"));

                    dtm.addRow(v);
//                this.repaint();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jComboBox13.getSelectedIndex() == 1) {
            try {
                java.sql.ResultSet result = mySQL.executeSearch("SELECT * FROM `movie_company` ORDER BY `movie_company`.`company_name` DESC");

                DefaultTableModel dtm = (DefaultTableModel) jTable8.getModel();
                dtm.setRowCount(0);

                while (result.next()) {
                    Vector<String> v = new Vector();
                    v.add(result.getString("Hotline"));
                    v.add(result.getString("company_name"));
                    v.add(result.getString("company_email"));

                    dtm.addRow(v);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void companySearch() {
        try {
            String Cname = jTextField13.getText().trim();
            String query = "SELECT * FROM `movie_company`";

            if (!Cname.isEmpty()) {
                query += " WHERE `movie_company`.`company_name` LIKE '" + Cname + "%'";
            }

            java.sql.ResultSet result = mySQL.executeSearch(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable8.getModel();
            dtm.setRowCount(0); // clear existing rows

            while (result.next()) {
                Vector<String> v = new Vector();
                v.add(result.getString("Hotline"));
                v.add(result.getString("company_name"));
                v.add(result.getString("company_email"));

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void resetCompany() {

        jTextField13.setText("");
        jComboBox13.setSelectedIndex(0);
        loardCompany();
    }

    private void SupplierState() {

        if (jComboBox14.getSelectedIndex() == 0) {
            loardSuppliers("fname", "ASC", jTextField14.getText());
        } else if (jComboBox14.getSelectedIndex() == 1) {
            loardSuppliers("fname", "DESC", jTextField14.getText());
        }
    }

    private void supplierSearch() {

        try {
            String Fname = jTextField14.getText().trim();
            String query = "SELECT * FROM `movie_supplier` INNER JOIN `movie_company` ON `movie_supplier`.`movie_company_id`=`movie_company`.`id`";

            if (!Fname.isEmpty()) {
                query += " WHERE `movie_supplier`.`fname` LIKE '" + Fname + "%'";
            }

            java.sql.ResultSet result = mySQL.executeSearch(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(0); // clear existing rows

            while (result.next()) {
                Vector<String> v = new Vector<>();
                v.add(result.getString("supplier_mobile"));
                v.add(result.getString("fname"));
                v.add(result.getString("lname"));
                v.add(result.getString("email"));
                v.add(result.getString("movie_company.company_name"));

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetSupplier() {

        jTextField14.setText("");
        jComboBox14.setSelectedIndex(0);
        loardSuppliers("fname", "ASC", "");
    }

    /////////////////////////////////////
    private void LoadMovieTable() {

        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `movie` "
                    + "INNER JOIN `movie_category` ON `movie`.`movie_category_id`=`movie_category`.`id`"
                    + "INNER JOIN `movie_dimension` ON `movie`.`movie_dimension_id`=`movie_dimension`.`id`"
                    + "INNER JOIN `language` ON `movie`.`language_id`=`language`.`id` ");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("movie_id"));
                vector.add(resultSet.getString("name"));
                vector.add(resultSet.getString("duration"));
                vector.add(resultSet.getString("relased_date"));
                vector.add(resultSet.getString("movie_category.name"));
                vector.add(resultSet.getString("movie_dimension.type"));
                vector.add(resultSet.getString("language.name"));

                dtm.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void LoadInvoiceTable() {

        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT  * FROM `movie_invoiceitem` INNER JOIN `invoice` ON `movie_invoiceitem`.`invoice_id` = `invoice`.id "
                    + "INNER JOIN `ticket` ON `movie_invoiceitem`.`ticket_id` = `ticket`.`id` "
                    + "INNER JOIN `schedule` ON `movie_invoiceitem`.`schedule_id` = `schedule`.`id` "
                    + "INNER JOIN `payment_method` ON `invoice`.`payment_method_id` = `payment_method`.`id` "
                    + "INNER JOIN `movie` ON `schedule`.`movie_movie_id` = `movie`.`movie_id`"
                    + "INNER JOIN `movie_customer_type` ON `ticket`.`movie_customer_type_id` = `movie_customer_type`.`id`  ");

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("invoice.id"));
                vector.add(resultSet.getString("movie.name"));
                vector.add(resultSet.getString("schedule.hall_id"));
                vector.add(resultSet.getString("sheet_number"));
                vector.add(resultSet.getString("customer_mobile"));
                vector.add(resultSet.getString("movie_customer_type.customer_type_name"));
                vector.add(resultSet.getString("payment_method.name"));
                vector.add(resultSet.getString("invoice.paid_amount"));
                vector.add(resultSet.getString("invoice.qty"));
                vector.add(resultSet.getString("invoice.user_email"));
                vector.add(resultSet.getString("invoice.date"));

                dtm.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadMovieGRN() {

        try {

            ResultSet resultSet = mySQL.executeSearch("SELECT * FROM `movie_grn` INNER JOIN `movie` ON "
                    + "`movie_grn`.`movie_movie_id` = `movie`.`movie_id`"
                    + "INNER JOIN `movie_supplier` ON "
                    + "`movie_grn`.`movie_supplier_supplier_mobile` = `movie_supplier`.supplier_mobile");

            DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel();
            dtm.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("id"));
                vector.add(resultSet.getString("movie_supplier.supplier_mobile"));
                vector.add(resultSet.getString("movie.name"));
                vector.add(resultSet.getString("payed_amount"));

                dtm.addRow(vector);
            }

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

            DefaultTableModel dtm = (DefaultTableModel) jTable7.getModel();
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

    private void loardCompany() {

        try {
            java.sql.ResultSet result = mySQL.executeSearch("SELECT * FROM `movie_company`");

            DefaultTableModel dtm = (DefaultTableModel) jTable8.getModel();
            dtm.setRowCount(0);

            while (result.next()) {
                Vector<String> v = new Vector();
                v.add(result.getString("Hotline"));
                v.add(result.getString("company_name"));
                v.add(result.getString("company_email"));

                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loardSuppliers(String column, String orderby, String fname) {
        try {

            ResultSet resultset = mySQL.executeSearch("SELECT * FROM `movie_supplier` INNER JOIN `movie_company` ON `movie_supplier`.`movie_company_id`=`movie_company`.`id` WHERE `fname` LIKE '" + fname + "%' ORDER BY `" + column + "` " + orderby + "");

            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(0);
            while (resultset.next()) {
                Vector<String> v = new Vector<>();
                v.add(resultset.getString("supplier_mobile"));
                v.add(resultset.getString("fname"));
                v.add(resultset.getString("lname"));
                v.add(resultset.getString("email"));
                v.add(resultset.getString("movie_company.company_name"));

                dtm.addRow(v);
//                this.repaint();
            }
            Vector<String> v = new Vector();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reload() {

        java.lang.Runnable runnable = new java.lang.Runnable() {
            @Override
            public void run() {

                while (true) {

                    LoadMovieTable();

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        };

        java.lang.Thread thread = new java.lang.Thread(runnable);
        thread.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jComboBox9 = new javax.swing.JComboBox<>();
        jPanel74 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jPanel82 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel78 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jPanel87 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox11 = new javax.swing.JComboBox<>();
        jPanel103 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel84 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jPanel88 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jComboBox12 = new javax.swing.JComboBox<>();
        jPanel102 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel91 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jPanel93 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jPanel95 = new javax.swing.JPanel();
        jPanel96 = new javax.swing.JPanel();
        jPanel97 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jComboBox13 = new javax.swing.JComboBox<>();
        jPanel104 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jPanel98 = new javax.swing.JPanel();
        jPanel99 = new javax.swing.JPanel();
        jPanel100 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel62 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jPanel105 = new javax.swing.JPanel();
        jPanel106 = new javax.swing.JPanel();
        jPanel107 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jComboBox14 = new javax.swing.JComboBox<>();
        jPanel112 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jPanel108 = new javax.swing.JPanel();
        jPanel109 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel10.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel10, java.awt.BorderLayout.LINE_START);

        jPanel11.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel11, java.awt.BorderLayout.LINE_END);

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setPreferredSize(new java.awt.Dimension(1148, 50));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel14, java.awt.BorderLayout.LINE_END);

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Movies");
        jPanel15.add(jLabel2);

        jPanel13.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1148, 35));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel73.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel73.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel73.add(jTextField9);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox9ItemStateChanged(evt);
            }
        });
        jPanel73.add(jComboBox9);

        jPanel3.add(jPanel73, java.awt.BorderLayout.LINE_START);

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Clear");
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel74, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Duration", "Released Date", "Category", "Dimension", "Language"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel6.add(jScrollPane1);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel17.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel12, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("All Movies", jPanel7);

        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel19.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        jPanel20.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel20, java.awt.BorderLayout.PAGE_END);

        jPanel21.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel21, java.awt.BorderLayout.LINE_START);

        jPanel22.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel22, java.awt.BorderLayout.LINE_END);

        jPanel23.setLayout(new java.awt.BorderLayout());

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.setPreferredSize(new java.awt.Dimension(1148, 50));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.setForeground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel25, java.awt.BorderLayout.LINE_END);

        jPanel26.setBackground(new java.awt.Color(51, 51, 51));
        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Invoices");
        jPanel26.add(jLabel3);

        jPanel24.add(jPanel26, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel24, java.awt.BorderLayout.PAGE_START);

        jPanel28.setLayout(new java.awt.BorderLayout());

        jPanel75.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel75, java.awt.BorderLayout.PAGE_START);

        jPanel76.setLayout(new java.awt.BorderLayout());

        jPanel77.setPreferredSize(new java.awt.Dimension(1148, 35));
        jPanel77.setLayout(new java.awt.BorderLayout());

        jPanel81.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel81.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel81.add(jTextField10);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox10ItemStateChanged(evt);
            }
        });
        jPanel81.add(jComboBox10);

        jPanel77.add(jPanel81, java.awt.BorderLayout.LINE_START);

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Clear");
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel77.add(jPanel82, java.awt.BorderLayout.CENTER);

        jPanel76.add(jPanel77, java.awt.BorderLayout.PAGE_START);

        jPanel78.setLayout(new java.awt.BorderLayout());

        jPanel79.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel78.add(jPanel79, java.awt.BorderLayout.PAGE_START);

        jPanel80.setLayout(new java.awt.GridLayout(1, 0));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice ID", "Movie Name", "Hall ", "Sheet Number", "Customer Mobile", "Customer Type", "Payment Method", "Paid Amount", "QTY", "Cashier", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel80.add(jScrollPane2);

        jPanel78.add(jPanel80, java.awt.BorderLayout.CENTER);

        jPanel76.add(jPanel78, java.awt.BorderLayout.CENTER);

        jPanel28.add(jPanel76, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel28, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel23, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Invoices", jPanel18);

        jPanel29.setLayout(new java.awt.BorderLayout());

        jPanel30.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel29.add(jPanel30, java.awt.BorderLayout.PAGE_START);

        jPanel31.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel29.add(jPanel31, java.awt.BorderLayout.PAGE_END);

        jPanel32.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel29.add(jPanel32, java.awt.BorderLayout.LINE_START);

        jPanel33.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel29.add(jPanel33, java.awt.BorderLayout.LINE_END);

        jPanel34.setLayout(new java.awt.BorderLayout());

        jPanel35.setBackground(new java.awt.Color(51, 51, 51));
        jPanel35.setPreferredSize(new java.awt.Dimension(1148, 50));
        jPanel35.setLayout(new java.awt.BorderLayout());

        jPanel36.setBackground(new java.awt.Color(51, 51, 51));
        jPanel36.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel36, java.awt.BorderLayout.LINE_END);

        jPanel37.setBackground(new java.awt.Color(51, 51, 51));
        jPanel37.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Shedule");
        jPanel37.add(jLabel4);

        jPanel35.add(jPanel37, java.awt.BorderLayout.CENTER);

        jPanel34.add(jPanel35, java.awt.BorderLayout.PAGE_START);

        jPanel39.setLayout(new java.awt.BorderLayout());

        jPanel16.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel39.add(jPanel16, java.awt.BorderLayout.PAGE_START);

        jPanel27.setLayout(new java.awt.BorderLayout());

        jPanel83.setPreferredSize(new java.awt.Dimension(1148, 35));
        jPanel83.setLayout(new java.awt.BorderLayout());

        jPanel87.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel87.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel87.add(jTextField11);

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox11ItemStateChanged(evt);
            }
        });
        jPanel87.add(jComboBox11);

        jPanel83.add(jPanel87, java.awt.BorderLayout.LINE_START);

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Clear");
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel103Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel83.add(jPanel103, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel83, java.awt.BorderLayout.PAGE_START);

        jPanel84.setLayout(new java.awt.BorderLayout());

        jPanel85.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel84.add(jPanel85, java.awt.BorderLayout.PAGE_START);

        jPanel86.setLayout(new java.awt.GridLayout(1, 0));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable7);

        jPanel86.add(jScrollPane7);

        jPanel84.add(jPanel86, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel84, java.awt.BorderLayout.CENTER);

        jPanel39.add(jPanel27, java.awt.BorderLayout.CENTER);

        jPanel34.add(jPanel39, java.awt.BorderLayout.CENTER);

        jPanel29.add(jPanel34, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Schedule", jPanel29);

        jPanel40.setLayout(new java.awt.BorderLayout());

        jPanel41.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel41, java.awt.BorderLayout.PAGE_START);

        jPanel42.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel42, java.awt.BorderLayout.PAGE_END);

        jPanel43.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel43, java.awt.BorderLayout.LINE_START);

        jPanel44.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel40.add(jPanel44, java.awt.BorderLayout.LINE_END);

        jPanel45.setLayout(new java.awt.BorderLayout());

        jPanel46.setBackground(new java.awt.Color(51, 51, 51));
        jPanel46.setPreferredSize(new java.awt.Dimension(1148, 50));
        jPanel46.setLayout(new java.awt.BorderLayout());

        jPanel47.setBackground(new java.awt.Color(51, 51, 51));
        jPanel47.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel46.add(jPanel47, java.awt.BorderLayout.LINE_END);

        jPanel48.setBackground(new java.awt.Color(51, 51, 51));
        jPanel48.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MRN");
        jPanel48.add(jLabel5);

        jPanel46.add(jPanel48, java.awt.BorderLayout.CENTER);

        jPanel45.add(jPanel46, java.awt.BorderLayout.PAGE_START);

        jPanel50.setLayout(new java.awt.BorderLayout());

        jPanel88.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel50.add(jPanel88, java.awt.BorderLayout.PAGE_START);

        jPanel89.setLayout(new java.awt.BorderLayout());

        jPanel90.setPreferredSize(new java.awt.Dimension(1148, 35));
        jPanel90.setLayout(new java.awt.BorderLayout());

        jPanel94.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel94.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel94.add(jTextField12);

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox12.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox12ItemStateChanged(evt);
            }
        });
        jPanel94.add(jComboBox12);

        jPanel90.add(jPanel94, java.awt.BorderLayout.LINE_START);

        jButton13.setBackground(new java.awt.Color(51, 51, 51));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Clear");
        jButton13.setBorderPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel102Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel90.add(jPanel102, java.awt.BorderLayout.CENTER);

        jPanel89.add(jPanel90, java.awt.BorderLayout.PAGE_START);

        jPanel91.setLayout(new java.awt.BorderLayout());

        jPanel92.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel91.add(jPanel92, java.awt.BorderLayout.PAGE_START);

        jPanel93.setLayout(new java.awt.GridLayout(1, 0));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Supplier Mobile", "Movie Name", "Buying Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel93.add(jScrollPane4);

        jPanel91.add(jPanel93, java.awt.BorderLayout.CENTER);

        jPanel89.add(jPanel91, java.awt.BorderLayout.CENTER);

        jPanel50.add(jPanel89, java.awt.BorderLayout.CENTER);

        jPanel45.add(jPanel50, java.awt.BorderLayout.CENTER);

        jPanel40.add(jPanel45, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("MRN", jPanel40);

        jPanel51.setLayout(new java.awt.BorderLayout());

        jPanel52.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel51.add(jPanel52, java.awt.BorderLayout.PAGE_START);

        jPanel53.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel51.add(jPanel53, java.awt.BorderLayout.PAGE_END);

        jPanel54.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel51.add(jPanel54, java.awt.BorderLayout.LINE_START);

        jPanel55.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel51.add(jPanel55, java.awt.BorderLayout.LINE_END);

        jPanel56.setLayout(new java.awt.BorderLayout());

        jPanel57.setBackground(new java.awt.Color(51, 51, 51));
        jPanel57.setPreferredSize(new java.awt.Dimension(1148, 50));
        jPanel57.setLayout(new java.awt.BorderLayout());

        jPanel58.setBackground(new java.awt.Color(51, 51, 51));
        jPanel58.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel57.add(jPanel58, java.awt.BorderLayout.LINE_END);

        jPanel59.setBackground(new java.awt.Color(51, 51, 51));
        jPanel59.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Company");
        jPanel59.add(jLabel6);

        jPanel57.add(jPanel59, java.awt.BorderLayout.CENTER);

        jPanel56.add(jPanel57, java.awt.BorderLayout.PAGE_START);

        jPanel61.setLayout(new java.awt.BorderLayout());

        jPanel95.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel61.add(jPanel95, java.awt.BorderLayout.PAGE_START);

        jPanel96.setLayout(new java.awt.BorderLayout());

        jPanel97.setPreferredSize(new java.awt.Dimension(1148, 35));
        jPanel97.setLayout(new java.awt.BorderLayout());

        jPanel101.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel101.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });
        jPanel101.add(jTextField13);

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox13.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox13ItemStateChanged(evt);
            }
        });
        jPanel101.add(jComboBox13);

        jPanel97.add(jPanel101, java.awt.BorderLayout.LINE_START);

        jButton14.setBackground(new java.awt.Color(51, 51, 51));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Clear");
        jButton14.setBorderPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel104Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel97.add(jPanel104, java.awt.BorderLayout.CENTER);

        jPanel96.add(jPanel97, java.awt.BorderLayout.PAGE_START);

        jPanel98.setLayout(new java.awt.BorderLayout());

        jPanel99.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel98.add(jPanel99, java.awt.BorderLayout.PAGE_START);

        jPanel100.setLayout(new java.awt.GridLayout(1, 0));

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hot Line", "Name", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable8);

        jPanel100.add(jScrollPane8);

        jPanel98.add(jPanel100, java.awt.BorderLayout.CENTER);

        jPanel96.add(jPanel98, java.awt.BorderLayout.CENTER);

        jPanel61.add(jPanel96, java.awt.BorderLayout.CENTER);

        jPanel56.add(jPanel61, java.awt.BorderLayout.CENTER);

        jPanel51.add(jPanel56, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Company", jPanel51);

        jPanel62.setLayout(new java.awt.BorderLayout());

        jPanel63.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel63, java.awt.BorderLayout.PAGE_START);

        jPanel64.setPreferredSize(new java.awt.Dimension(1208, 30));

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel64, java.awt.BorderLayout.PAGE_END);

        jPanel65.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel65, java.awt.BorderLayout.LINE_START);

        jPanel66.setPreferredSize(new java.awt.Dimension(30, 469));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel66, java.awt.BorderLayout.LINE_END);

        jPanel67.setLayout(new java.awt.BorderLayout());

        jPanel68.setBackground(new java.awt.Color(51, 51, 51));
        jPanel68.setPreferredSize(new java.awt.Dimension(1148, 50));
        jPanel68.setLayout(new java.awt.BorderLayout());

        jPanel69.setBackground(new java.awt.Color(51, 51, 51));
        jPanel69.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel68.add(jPanel69, java.awt.BorderLayout.LINE_END);

        jPanel70.setBackground(new java.awt.Color(51, 51, 51));
        jPanel70.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Supplier");
        jPanel70.add(jLabel7);

        jPanel68.add(jPanel70, java.awt.BorderLayout.CENTER);

        jPanel67.add(jPanel68, java.awt.BorderLayout.PAGE_START);

        jPanel72.setLayout(new java.awt.BorderLayout());

        jPanel105.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel72.add(jPanel105, java.awt.BorderLayout.PAGE_START);

        jPanel106.setLayout(new java.awt.BorderLayout());

        jPanel107.setPreferredSize(new java.awt.Dimension(1148, 35));
        jPanel107.setLayout(new java.awt.BorderLayout());

        jPanel111.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel111.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField14KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });
        jPanel111.add(jTextField14);

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox14.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox14ItemStateChanged(evt);
            }
        });
        jPanel111.add(jComboBox14);

        jPanel107.add(jPanel111, java.awt.BorderLayout.LINE_START);

        jButton15.setBackground(new java.awt.Color(51, 51, 51));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Clear");
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel112Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel107.add(jPanel112, java.awt.BorderLayout.CENTER);

        jPanel106.add(jPanel107, java.awt.BorderLayout.PAGE_START);

        jPanel108.setLayout(new java.awt.BorderLayout());

        jPanel109.setPreferredSize(new java.awt.Dimension(1148, 5));

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel108.add(jPanel109, java.awt.BorderLayout.PAGE_START);

        jPanel110.setLayout(new java.awt.GridLayout(1, 0));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last Name", "Email", "Company"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel110.add(jScrollPane3);

        jPanel108.add(jPanel110, java.awt.BorderLayout.CENTER);

        jPanel106.add(jPanel108, java.awt.BorderLayout.CENTER);

        jPanel72.add(jPanel106, java.awt.BorderLayout.CENTER);

        jPanel67.add(jPanel72, java.awt.BorderLayout.CENTER);

        jPanel62.add(jPanel67, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Supplier", jPanel62);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        resetSupplier();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jComboBox14ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox14ItemStateChanged
        SupplierState();
    }//GEN-LAST:event_jComboBox14ItemStateChanged

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        supplierSearch();
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jTextField14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyReleased
        supplierSearch();
    }//GEN-LAST:event_jTextField14KeyReleased

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        resetCompany();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jComboBox13ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox13ItemStateChanged
        companyState();
    }//GEN-LAST:event_jComboBox13ItemStateChanged

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        companySearch();
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        companySearch();
    }//GEN-LAST:event_jTextField13KeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        resetMRN();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jComboBox12ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox12ItemStateChanged
        MRNstate();
    }//GEN-LAST:event_jComboBox12ItemStateChanged

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        MRNsearch();
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        MRNsearch();
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        resetMovie();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jComboBox11ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox11ItemStateChanged
        MovieScheduleState();
    }//GEN-LAST:event_jComboBox11ItemStateChanged

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        MovieScheduleSearch();
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        MovieScheduleSearch();
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        resetInvoice();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox10ItemStateChanged
        InvoiceState();
    }//GEN-LAST:event_jComboBox10ItemStateChanged

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
        MovieInvoiceSearch();
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        MovieInvoiceSearch();
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        reset();
        LoadMovieTable();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jComboBox9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox9ItemStateChanged
        moviestatechange();
    }//GEN-LAST:event_jComboBox9ItemStateChanged

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        MovieSearch();
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        MovieSearch();
    }//GEN-LAST:event_jTextField9KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
