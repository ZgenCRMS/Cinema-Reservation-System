/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public static Connection getConnection() throws Exception {
        String secretKey = "1234567890123456";
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        FileInputStream fis = new FileInputStream("dbinfo.ser");
        CipherInputStream cis = new CipherInputStream(fis, cipher);
        ObjectInputStream ois = new ObjectInputStream(cis);

        mySQL db = (mySQL) ois.readObject();
        ois.close();

        String jdbcUrl = "jdbc:mysql://localhost:3306/" + db.dbname;
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(jdbcUrl, db.un, db.pw);
    }

}
