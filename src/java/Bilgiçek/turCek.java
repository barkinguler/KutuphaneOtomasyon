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
 * @author ilkaygunel
 */
@ManagedBean
@RequestScoped
public class turCek extends Kutuphanemanaged {


    List<Kutuphanemanaged> sorguSonucu3 = null;
    List<Kutuphanemanaged> sorguSonucu2 = null;
    private Kutuphanemanaged selectedCar;

    List<Kutuphanemanaged> sorguSonucudetay = null;

    List<Kutuphanemanaged> sorguSonucu = null;

    public List<Kutuphanemanaged> getSorguSonucudetay() {
        return sorguSonucudetay;
    }

    public void setSorguSonucudetay(List<Kutuphanemanaged> sorguSonucudetay) {
        this.sorguSonucudetay = sorguSonucudetay;
    }


    public Kutuphanemanaged getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Kutuphanemanaged selectedCar) {
        this.selectedCar = selectedCar;

        turgetirdetay(selectedCar);

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
    public void turkayit() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucu2 = new ArrayList<>();
        try {
            con = Baglan.getcon();

            preparedStatement = con.prepareStatement("select T.TURNO,T.TURAD FROM TUR T WHERE TURAD=?");
            preparedStatement.setString(1, turadi);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setTuradi(resultSet.getString("TURAD"));
                kisiler.setTurno(resultSet.getInt("TURNO"));

                sorguSonucu2.add(kisiler);
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

    public void turkayit2() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucu2 = new ArrayList<>();
        try {
            con = Baglan.getcon();

            preparedStatement = con.prepareStatement("select TURAD FROM TUR");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setTuradi(resultSet.getString("TURAD"));


                sorguSonucu2.add(kisiler);
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
        sorguSonucu3 = new ArrayList<>();
        try {
            con1 = Baglan.getcon();

            preparedStatement1 = con1.prepareStatement("select T.TURNO,T.TURAD FROM TUR T");


            resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setTurno(resultSet1.getInt("TURNO"));
                kisiler.setTuradi(resultSet1.getString("TURAD"));


                sorguSonucu3.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement1.close();
            } catch (Exception e) {
            }
        }

    }

    @PostConstruct
    public void turgetir() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucu = new ArrayList<>();
        try {
            con = Baglan.getconmusteri();

            preparedStatement = con.prepareStatement("select * from TÜR");


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setTurno(resultSet.getInt("TURNO"));
                kisiler.setTuradi(resultSet.getString("TURAD"));

                sorguSonucu.add(kisiler);
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
        sorguSonucu3 = new ArrayList<>();
        try {
            con1 = Baglan.getcon();

            preparedStatement1 = con1.prepareStatement("select T.TURNO,T.TURAD FROM TUR T");


            resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setTurno(resultSet1.getInt("TURNO"));
                kisiler.setTuradi(resultSet1.getString("TURAD"));


                sorguSonucu3.add(kisiler);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                preparedStatement1.close();
            } catch (Exception e) {
            }
        }

    }


    public void turgetirdetay(Kutuphanemanaged deger) {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        sorguSonucudetay = new ArrayList<>();
        try {
            con = Baglan.getconmusteri();

            preparedStatement = con.prepareStatement("select DISTINCT(Y.YAZARAD), Y.YAZARSOYAD,K.KİTAPAD from TÜR T,KITAP K,YAZAR Y WHERE T.TURNO=? AND T.TURNO=K.TURNO AND K.YAZARNO=Y.YAZARNO");
            preparedStatement.setInt(1, deger.turno);

            resultSet = preparedStatement.executeQuery();
            JOptionPane.showMessageDialog(null, deger.turno);
            while (resultSet.next()) {

                Kutuphanemanaged kisiler = new Kutuphanemanaged();
                kisiler.setYazarad(resultSet.getString("YAZARAD"));
                kisiler.setYazarsoyad(resultSet.getString("YAZARSOYAD"));
                kisiler.setKitapadi(resultSet.getString("KİTAPAD"));

                sorguSonucudetay.add(kisiler);
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
  
    

