/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

public class mySQL implements Serializable {

    public String ip;
    public String port;
    public String pw;
    public String un;
    public String dbname;

    public String dump;
    public String path;

    private static Connection connection;

    public static void createConnection() throws Exception {

        if (connection == null) {

//            FileInputStream input = new FileInputStream("dbinfo.ser");
//            ObjectInputStream objectInputStream = new ObjectInputStream(input);
//            mySQL db = (mySQL) objectInputStream.readObject();
//            
//            objectInputStream.close();

            String secretKey = "1234567890123456"; // Same key
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            FileInputStream fileIn = new FileInputStream("dbinfo.ser");
            CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
            ObjectInputStream objectIn = new ObjectInputStream(cipherIn);

            mySQL db = (mySQL) objectIn.readObject();
            objectIn.close();

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + db.ip + ":" + db.port + "/" + db.dbname, db.un, db.pw);

        }

    }

    public static ResultSet executeSearch(String query) throws Exception {

        createConnection();

        return connection.createStatement().executeQuery(query);

    }

    public static Integer executeIUD(String query) throws Exception {

        createConnection();

        return connection.createStatement().executeUpdate(query);

    }

}
