package Bilgiçek;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
/**
 *
 * @author ilkaygunel
 */
@ManagedBean
@RequestScoped
public class KayitCek {
    List<Kutuphanemanaged> sorguSonucu;

    public List<Kutuphanemanaged> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<Kutuphanemanaged> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }
    
    /*public List<Kisiler> getTablodakiKayitlar()
    {
        Connection connnection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsfdersleri","root","");
            preparedStatement=connnection.prepareStatement("select * from kisiler");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                Kisiler kisiler=new Kisiler();
                kisiler.setId(resultSet.getInt("id"));
                kisiler.setIsim(resultSet.getString("isim"));
                kisiler.setSoyisim(resultSet.getString("soyisim"));
                kisiler.setUniversite(resultSet.getString("universite"));
                sorguSonucu.add(kisiler);
            }
        } catch (Exception e) {
            System.err.println("Hata Meydana Geldi. Hata:"+e);
        }
        finally{
            try {
                connnection.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }
        return sorguSonucu;
    }*/
    
    
   
    
    
    
    @PostConstruct
    public void veriTabanindanKayitCek()
    {
        
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu=new ArrayList<>();
        try {
           con=Baglan.getcon();
            preparedStatement=con.prepareStatement("select * from İSLEM");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setIslemno(resultSet.getInt("İSLEMNO"));
                kisiler.setOgrno(resultSet.getInt("OGRNO"));
                kisiler.setKitapno(resultSet.getInt("KİTAPNO"));
                kisiler.setAtarih(resultSet.getString("ATARİH"));
                kisiler.setVtarih(resultSet.getString("VTARİH"));
                sorguSonucu.add(kisiler);
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }
    }
    
}
