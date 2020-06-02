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
public class islemCek {
    

    
 List<Kutuphanemanaged> sorguSonucu=null;
  List<Kutuphanemanaged> sorguSonucumusteri=null;

    public List<Kutuphanemanaged> getSorguSonucumusteri() {
        return sorguSonucumusteri;
    }

    public void setSorguSonucumusteri(List<Kutuphanemanaged> sorguSonucumusteri) {
        this.sorguSonucumusteri = sorguSonucumusteri;
    }

  
  
  
  
    public List<Kutuphanemanaged> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<Kutuphanemanaged> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }
 
 
 
 
  @PostConstruct 
        public void kitapkayit2()
    {
        
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu=new ArrayList<>();
        try {
           con=Baglan.getcon();
           
            preparedStatement=con.prepareStatement("SELECT DISTINCT (I.İSLEMNO),I.OGRNO,I.KİTAPNO,K.KİTAPAD,I.ATARİH,I.VTARİH,I.TESLİM FROM İSLEM I,OGRENCİ O,KİTAP K WHERE I.KİTAPNO=K.KİTAPNO");
         
            
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setIslemno(resultSet.getInt("İSLEMNO"));
                
                kisiler.setOgrno(resultSet.getInt("OGRNO"));
                kisiler.setKitapno(resultSet.getInt("KİTAPNO"));
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));
                kisiler.setAtarih(resultSet.getString("ATARİH").substring(0,10));
               /* try{
                kisiler.setVtarih(resultSet.getString("VTARİH").substring(0,10));}
                catch(Exception e){
                kisiler.setVtarih("yok");
                }*/
                kisiler.setTeslim(resultSet.getString("TESLİM"));
                
                if(!resultSet.getString("TESLİM").equals("Teslim edilmedi")){
                    
                kisiler.setVtarih(resultSet.getString("VTARİH").substring(0,10));
                }
                
               // kisiler.setTeslim(resultSet.getString("TESLİM"));
                
                sorguSonucu.add(kisiler);
                
            }
        } catch (Exception e) {
          // JOptionPane.showMessageDialog(null,e);
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
        
        try {
            sorguSonucumusteri=new ArrayList<>();
           con1=Baglan.getconmusteri();
           CookieHelper a=new CookieHelper();
            preparedStatement1=con1.prepareStatement("SELECT İ.İSLEMNO,İ.OGRNO,K.KİTAPAD,İ.ATARİH,İ.VTARİH,İ.TESLİM  FROM İSLEM İ,KITAP K WHERE   İ.OGRNO=(SELECT OGRNO FROM GİRİS WHERE KULLANICIAD=? )  AND İ.KİTAPNO=K.KİTAPNO order by İ.ATARİH");
            preparedStatement1.setString(1, a.getCookie("Test").getValue());
            
            resultSet1=preparedStatement1.executeQuery();
            
            while (resultSet1.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setIslemno(resultSet1.getInt("İSLEMNO"));
              
                kisiler.setOgrno(resultSet1.getInt("OGRNO"));
               
                kisiler.setKitapadi(resultSet1.getString("KİTAPAD"));
                kisiler.setAtarih(resultSet1.getString("ATARİH").substring(0,10));
                
                kisiler.setTeslim(resultSet1.getString("TESLİM"));
               
                if(kisiler.getTeslim().equals("Teslim edildi")){
                    
                kisiler.setVtarih(resultSet1.getString("VTARİH").substring(0,10));
                }
                
               
                
                
                
                
                sorguSonucumusteri.add(kisiler);
            }
        } catch (Exception e) {
           //JOptionPane.showMessageDialog(null,e);
        }
        finally{
            try {
                con1.close();
                preparedStatement1.close();
                resultSet1.close();
            } catch (Exception e) {
            }
        }
    
     
    }
 
 
    
}
