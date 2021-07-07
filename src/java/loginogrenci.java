/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Bilgiçek.Baglan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

/**
 * @author brkn_
 */
@ManagedBean
@RequestScoped
public class loginogrenci {

    /**
     * Creates a new instance of loginogrenci
     */
    public loginogrenci() {
    }

    public String usernamemusteri;
    public String passwordmusteri;

    public String getPasswordmusteri() {
        return passwordmusteri;
    }

    public void setPasswordmusteri(String passwordmusteri) {
        this.passwordmusteri = passwordmusteri;
    }

    public String getUsernamemusteri() {
        return usernamemusteri;
    }

    public void setUsernamemusteri(String usernamemusteri) {
        this.usernamemusteri = usernamemusteri;
    }


    public String karsilastirmusteri() {


        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            con = Baglan.getconmusteri();
            preparedStatement = con.prepareStatement("select SIFRE from GİRİS  WHERE KULLANICIAD=?");
            preparedStatement.setString(1, usernamemusteri);
            resultSet = preparedStatement.executeQuery();
            JOptionPane.showMessageDialog(null, usernamemusteri);
            JOptionPane.showMessageDialog(null, passwordmusteri);
            while (resultSet.next()) {


                if (resultSet.getString("SIFRE").equals(passwordmusteri)) {

                    return "misafir/misafir.xhtml?faces-redirect=true";

                }


            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement.close();

            } catch (Exception e) {
                System.err.println("Hata Meydana Geldi. Hata:" + e);
            }
        }
        return "";
    }

}
