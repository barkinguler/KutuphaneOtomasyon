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
 *
 * @author brkn_
 */
@ManagedBean
@RequestScoped
public class yazarCek extends Kutuphanemanaged {
    List<Kutuphanemanaged> sorguSonucu3=null;
List<Kutuphanemanaged> sorguSonucu2=null;
Kutuphanemanaged selectedCar=null;
    
 List<Kutuphanemanaged> sorguSonucu=null;
 List<Kutuphanemanaged> sorguSonucumusteri=null;
 List<Kutuphanemanaged> sorguSonucumusteri2=null;

    public List<Kutuphanemanaged> getSorguSonucumusteri2() {
        return sorguSonucumusteri2;
    }

    public void setSorguSonucumusteri2(List<Kutuphanemanaged> sorguSonucumusteri2) {
        this.sorguSonucumusteri2 = sorguSonucumusteri2;
    }
 
 
 
    public Kutuphanemanaged getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Kutuphanemanaged selectedCar) {
        this.selectedCar = selectedCar;
        yazarkayitdetay2(selectedCar);
    }

 
 
 
    public List<Kutuphanemanaged> getSorguSonucumusteri() {
        return sorguSonucumusteri;
    }

    public void setSorguSonucumusteri(List<Kutuphanemanaged> sorguSonucumusteri) {
        this.sorguSonucumusteri = sorguSonucumusteri;
    }
 
 
 

    public List<Kutuphanemanaged> getSorguSonucu3() {
        return sorguSonucu3;
    }

    public void setSorguSonucu3(List<Kutuphanemanaged> sorguSonucu3) {
        this.sorguSonucu3 = sorguSonucu3;
    }

 
 
    public List<Kutuphanemanaged> getSorguSonucu2() {
        return sorguSonucu2;
    }

    public void setSorguSonucu2(List<Kutuphanemanaged> sorguSonucu2) {
        this.sorguSonucu2 = sorguSonucu2;
    }
 
 
 

    public List<Kutuphanemanaged> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<Kutuphanemanaged> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }
   // @PostConstruct
     public void yazarkayit()
    {
        
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu=new ArrayList<>();
        try {
           con=Baglan.getcon();
           
            preparedStatement=con.prepareStatement("select Y.YAZARAD,Y.YAZARSOYAD,Y.YAZARNO FROM YAZAR Y WHERE YAZARAD=?");
            preparedStatement.setString(1,yazarad);
            
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setYazarad(resultSet.getString("YAZARAD"));
                kisiler.setYazarsoyad(resultSet.getString("YAZARSOYAD"));
                kisiler.setYazarno(resultSet.getInt("YAZARNO"));
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
        }}
    @PostConstruct 
        public void yazarkayit2()
    {
        
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu2=new ArrayList<>();
        try {
           con=Baglan.getcon();
           
            preparedStatement=con.prepareStatement("select YAZARAD,YAZARSOYAD FROM YAZAR");
         
            
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setYazarad(resultSet.getString("YAZARAD"));
                kisiler.setYazarsoyad(resultSet.getString("YAZARSOYAD"));
                
                sorguSonucu2.add(kisiler);
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
    
      Connection con1=null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet1=null;
        sorguSonucu3=new ArrayList<>();
        try {
           con1=Baglan.getcon();
           
            preparedStatement1=con1.prepareStatement("select Y.YAZARNO,Y.YAZARAD,Y.YAZARSOYAD FROM YAZAR Y");
         
            
            resultSet1=preparedStatement1.executeQuery();
            
            while (resultSet1.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setYazarno(resultSet1.getInt("YAZARNO"));
                kisiler.setYazarad(resultSet1.getString("YAZARAD"));
                kisiler.setYazarsoyad(resultSet1.getString("YAZARSOYAD"));
               
                
                
                sorguSonucu3.add(kisiler);
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                con1.close();
                preparedStatement1.close();
            } catch (Exception e) {
            }
        }
    
        Connection con3=null;
        PreparedStatement preparedStatement3=null;
        ResultSet resultSet3=null;
        sorguSonucumusteri=new ArrayList<>();
        try {
            
           con3=Baglan.getconmusteri();
           
            preparedStatement3=con3.prepareStatement("select YAZARNO,YAZARAD,YAZARSOYAD FROM YAZAR");
         
            
            resultSet3=preparedStatement3.executeQuery();
            
            while (resultSet3.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setYazarno(resultSet3.getInt("YAZARNO"));
                kisiler.setYazarad(resultSet3.getString("YAZARAD"));
                kisiler.setYazarsoyad(resultSet3.getString("YAZARSOYAD"));
                
                sorguSonucumusteri.add(kisiler);
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                con3.close();
                preparedStatement3.close();
                resultSet3.close();
            } catch (Exception e) {
            }
        }
        
    }
        
            public void yazarkayitdetay()
    {
        
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucumusteri=new ArrayList<>();
        try {
           con=Baglan.getconmusteri();
           
            preparedStatement=con.prepareStatement("select YAZARNO,YAZARAD,YAZARSOYAD FROM YAZAR");
         
            
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setYazarno(resultSet.getInt("YAZARNO"));
                kisiler.setYazarad(resultSet.getString("YAZARAD"));
                kisiler.setYazarsoyad(resultSet.getString("YAZARSOYAD"));
                
                sorguSonucumusteri.add(kisiler);
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
        }}
            
            
            
                   public void yazarkayitdetay2(Kutuphanemanaged deger)
    {
        
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucumusteri2=new ArrayList<>();
        try {
           con=Baglan.getconmusteri();
           
            preparedStatement=con.prepareStatement("select K.KİTAPAD,T.TURAD from TÜR T,KITAP K,YAZAR Y WHERE Y.YAZARNO=? AND Y.YAZARNO=K.YAZARNO AND K.TURNO=T.TURNO");
            preparedStatement.setInt(1, deger.yazarno);
            
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));
                kisiler.setTuradi(resultSet.getString("TURAD"));
                
                
                sorguSonucumusteri2.add(kisiler);
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
        }}    
        
}
