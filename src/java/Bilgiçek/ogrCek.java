package Bilgiçek;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author brkn_
 */
@ManagedBean
@RequestScoped
public class ogrCek extends Kutuphanemanaged {
    List<Kutuphanemanaged> sorguSonucu = null;

    public List<Kutuphanemanaged> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<Kutuphanemanaged> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }

    @PostConstruct
    public void turkayit() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucu = new ArrayList<>();
        try {
            con = Baglan.getcon();

            preparedStatement = con.prepareStatement("select OGRNO,OGRAD,OGRSOYAD FROM OGRENCİ");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setOgrno(resultSet.getInt("OGRNO"));
                kisiler.setOgrad(resultSet.getString("OGRAD"));
                kisiler.setOgrsoyad(resultSet.getString("OGRSOYAD"));
                sorguSonucu.add(kisiler);
            }
        } catch (Exception e) {

        } finally {
            try {
                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }
    }
}
