package Bilgiçek;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author brkn_
 */
public class Baglan {
    public static Connection getcon() {
        Connection con1 = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "brkn123", "asdqwe123");


            if (con1 != null) System.out.print("calıstı");


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return con1;
    }

    public static Connection getconmusteri() {
        Connection con1 = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MÜŞTERİ", "asdqwe123");


            if (con1 != null) System.out.print("calıstı");


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return con1;
    }

    public static Connection getconadmin() {
        Connection con1 = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "admin", "123");


            if (con1 != null) System.out.print("calıstı");


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        return con1;
    }


}
