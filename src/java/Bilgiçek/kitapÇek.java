package Bilgiçek;


import static com.sun.javafx.logging.PulseLogger.addMessage;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

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
public class kitapÇek extends Kutuphanemanaged implements Serializable {
    List<Kutuphanemanaged> sorguSonucu3 = null;
    List<Kutuphanemanaged> sorguSonucu2 = null;

    private Kutuphanemanaged selectedCar;

    List<Kutuphanemanaged> sorguSonucu = null;
    List<Kutuphanemanaged> sorguSonucumüsteri = null;


    public Kutuphanemanaged getSelectedCar() {
        return selectedCar;
    }


    public void setSelectedCar(Kutuphanemanaged selectedCar) {
        this.selectedCar = selectedCar;
        kitapkayitmüsteridetay(selectedCar);


    }


    public List<Kutuphanemanaged> getSorguSonucumüsteri() {
        return sorguSonucumüsteri;
    }

    public void setSorguSonucumüsteri(List<Kutuphanemanaged> sorguSonucumüsteri) {
        this.sorguSonucumüsteri = sorguSonucumüsteri;
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

    public void buttonAction() {
        JOptionPane.showMessageDialog(null, "asdasdsad");
    }


    public List<Kutuphanemanaged> getSorguSonucu() {
        return sorguSonucu;
    }

    public void setSorguSonucu(List<Kutuphanemanaged> sorguSonucu) {
        this.sorguSonucu = sorguSonucu;
    }

    // @PostConstruct
    public void kitapkayit() {

        Connection con1 = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet1 = null;
        sorguSonucu = new ArrayList<>();
        try {
            con1 = Baglan.getcon();

            preparedStatement1 = con1.prepareStatement("select K.KİTAPNO,K.KİTAPAD,K.SAYFASAYİ,K.PUAN FROM KİTAP K where K.KİTAPAD=?");
            preparedStatement1.setString(1, kitapadi);

            resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapno(resultSet1.getInt("KİTAPNO"));
                kisiler.setKitapadi(resultSet1.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet1.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet1.getInt("PUAN"));

                sorguSonucu.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con1.close();
                preparedStatement1.close();
            } catch (Exception e) {
            }
        }
    }

    // @PostConstruct
    public void kitapkayit2() {

        Connection con1 = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet1 = null;
        sorguSonucu2 = new ArrayList<>();
        try {
            con1 = Baglan.getcon();

            preparedStatement1 = con1.prepareStatement("select K.KİTAPAD,K.SAYFASAYİ,K.PUAN FROM KİTAP K");


            resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapadi(resultSet1.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet1.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet1.getInt("PUAN"));

                sorguSonucu2.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con1.close();
                preparedStatement1.close();
            } catch (Exception e) {
            }
        }


    }

    public void kitapkayit3() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucu3 = new ArrayList<>();
        try {
            con = Baglan.getcon();

            preparedStatement = con.prepareStatement("select KİTAPAD,SAYFASAYİ,PUAN from KİTAP ORDER BY  SAYFASAYİ DESC");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet.getInt("PUAN"));

                sorguSonucu3.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }


    }

    public void kitapkayit4() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucu3 = new ArrayList<>();
        try {
            con = Baglan.getcon();

            preparedStatement = con.prepareStatement("select KİTAPAD,SAYFASAYİ,PUAN from KİTAP ORDER BY  PUAN DESC");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet.getInt("PUAN"));

                sorguSonucu3.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }


    }

    @PostConstruct
    public void kitapkayitmüsteri() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucumüsteri = new ArrayList<>();
        try {
            con = Baglan.getconmusteri();

            preparedStatement = con.prepareStatement("select KİTAPNO,KİTAPAD,SAYFASAYİ,PUAN from KITAP ORDER BY  PUAN DESC");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapno(resultSet.getInt("KİTAPNO"));
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet.getInt("PUAN"));

                sorguSonucumüsteri.add(kisiler);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }


        Connection con1 = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet1 = null;
        sorguSonucu2 = new ArrayList<>();
        try {
            con1 = Baglan.getcon();

            preparedStatement1 = con1.prepareStatement("select K.KİTAPNO,K.KİTAPAD,K.SAYFASAYİ,K.PUAN FROM KİTAP K");


            resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapno(resultSet1.getInt("KİTAPNO"));
                kisiler.setKitapadi(resultSet1.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet1.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet1.getInt("PUAN"));

                sorguSonucu2.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con1.close();
                preparedStatement1.close();
            } catch (Exception e) {
            }
        }


    }

    public void kitapkayitmüsteridetay(Kutuphanemanaged deger) {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucumüsteri = new ArrayList<>();
        try {
            con = Baglan.getconmusteri();

            preparedStatement = con.prepareStatement("select TURAD,YAZARAD,YAZARSOYAD FROM KITAP K,TÜR T,YAZAR Y WHERE K.KİTAPNO=? AND K.TURNO=T.TURNO AND K.YAZARNO=Y.YAZARNO");
            preparedStatement.setInt(1, deger.kitapno);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setTuradi(resultSet.getString("TURAD"));
                kisiler.setYazarad(resultSet.getString("YAZARAD"));
                kisiler.setYazarsoyad(resultSet.getString("YAZARSOYAD"));

                selectedCar = kisiler;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {
            try {

                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }


    }


    public void kitapkayit3musteri() {
        //sorguSonucumüsteri.clear();
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // sorguSonucumüsteri=new ArrayList<>();
        try {
            con = Baglan.getcon();

            preparedStatement = con.prepareStatement("select KİTAPNO,KİTAPAD,SAYFASAYİ,PUAN from KİTAP ORDER BY  SAYFASAYİ DESC");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapno(resultSet.getInt("KİTAPNO"));
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet.getInt("PUAN"));
                JOptionPane.showMessageDialog(null, "asd");
                sorguSonucumüsteri.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }


    }


    public void kitapkayit4musteri() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            con = Baglan.getcon();

            preparedStatement = con.prepareStatement("select KİTAPNO,KİTAPAD,SAYFASAYİ,PUAN from KİTAP ORDER BY  PUAN DESC");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setKitapno(resultSet.getInt("KİTAPNO"));
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));
                kisiler.setSayfasayisi(resultSet.getInt("SAYFASAYİ"));
                kisiler.setPuan(resultSet.getInt("PUAN"));

                sorguSonucumüsteri.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }


    }

}
