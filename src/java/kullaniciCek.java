
import Bilgiçek.Baglan;
import Bilgiçek.Kutuphanemanaged;
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
public class kullaniciCek {
    
     List<Kutuphanemanaged> sorguSonucu=null;
     
     public List<Kutuphanemanaged> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<Kutuphanemanaged> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }
     
     
    @PostConstruct 
        public void kullaniciCek()
    {
        
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        sorguSonucu=new ArrayList<>();
        try {
           con=Baglan.getconadmin();
           
            preparedStatement=con.prepareStatement("SELECT * FROM BILGILER");
         
            
            resultSet=preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Kutuphanemanaged kisiler=new Kutuphanemanaged();
                kisiler.setKullaniciad(resultSet.getString("KULLANICIAD"));
                
                kisiler.setKullanicisifre(resultSet.getString("KULLANICISIFRE"));
                kisiler.setIsim(resultSet.getString("ISIM"));
                kisiler.setSoyisim(resultSet.getString("SOYISIM"));
                kisiler.setPozisyon(resultSet.getString("POZİSYON"));
                
                
                
                
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
   
        
        
    public void islemgecmis(){
    
    
    
    
    }    
        
}
