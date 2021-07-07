package Bilgiçek;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

import org.primefaces.PrimeFaces;

/**
 * @author brkn_
 */
@ManagedBean(name = "deneme")

@RequestScoped
@SessionScoped

public class Kutuphanemanaged implements Serializable {

    /**
     * Creates a new instance of Kutuphanemanaged
     */
    public int islemno, ogrno, kitapno, yazarno, turno, sayfasayisi, puan;
    public String atarih, vtarih, ograd, ogrsoyad, kitapadi, turadi, yazarad, yazarsoyad, teslim, kullaniciad, kullanicisifre, isim, soyisim, pozisyon;

    public String adres;
    public static boolean kontrol;

    public Kutuphanemanaged() {
        kontrol = false;
        adres = null;
    }


    public void yap() {

        adres = "misafir/türmisafir.xhtml";
    }

    public void yapkitapliste() {

        adres = "liste/kitapmisafir.xhtml";
    }

    public void yapyazar() {
        adres = "misafir/yazarmisafir.xhtml";
    }

    public void yapkitap() {
        adres = "misafir/kitapmisafir.xhtml";
    }

    public void yapkitapsil() {
        adres = "kitap/kitapsil.xhtml";
    }

    public void yapögrenciekle() {
        adres = "Ogrenci/Ogrencikayit.xhtml";
    }

    public void yapögrenciliste() {
        adres = "liste/ogrenciliste.xhtml";
    }

    public void yapögrencisil() {
        adres = "Ogrenci/Ogrencisil.xhtml";
    }

    public void yapislemekle() {
        adres = "islem/islemkayit.xhtml";
    }

    public void yapislemgüncelle() {
        adres = "islem/vtarih.xhtml";
    }

    public void yapislemsil() {
        adres = "islem/İslemsil.xhtml";
    }

    public void yapislemlistem() {

        adres = "misafir/islemmisafir.xhtml";
    }

    public void yapislemliste() {

        adres = "liste/islem.xhtml";
    }

    public void yapkitapgüncelle() {
        adres = "kitap/kitapgüncelle.xhtml";
    }

    public void yapkitapkayit() {
        adres = "kitap/Kitapkayit.xhtml";

    }

    public void yapyazarkayit() {
        adres = "Yazar/yazarkayit.xhtml";

    }

    public void yapyazargüncelle() {
        adres = "Yazar/yazardegistir.xhtml";

    }

    public void yapyazarsil() {
        adres = "Yazar/yazarsil.xhtml";
    }

    public void yapyazarliste() {
        adres = "liste/yazarmisafir.xhtml";
    }

    public void yapturkayit() {
        adres = "tur/turkayit.xhtml";
    }

    public void yapturliste() {

        adres = "liste/türmisafir.xhtml";
    }

    public void yapturgüncelle() {
        adres = "tur/turdegistir.xhtml";
    }

    public void yaptursil() {
        adres = "tur/tursil.xhtml";
    }

    public String getTeslim() {
        return teslim;
    }

    public void setTeslim(String teslim) {
        this.teslim = teslim;
    }


    public String getAdres() {
        return adres;
    }


    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKullaniciad() {
        return kullaniciad;
    }

    public void setKullaniciad(String kullaniciad) {
        this.kullaniciad = kullaniciad;
    }

    public String getKullanicisifre() {
        return kullanicisifre;
    }

    public void setKullanicisifre(String kullanicisifre) {
        this.kullanicisifre = kullanicisifre;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public static boolean isKontrol() {
        return kontrol;
    }

    public static void setKontrol(boolean kontrol) {
        Kutuphanemanaged.kontrol = kontrol;
    }


    public void yazarGüncelle() {

        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("UPDATE  YAZAR set YAZARAD=?,YAZARSOYAD=? WHERE YAZARNO=?");
            preparedStatement.setString(1, yazarad);
            preparedStatement.setString(2, yazarsoyad);
            preparedStatement.setInt(3, yazarno);


            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Güncelleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);
        }

    }


    public void turGüncelle() {

        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("UPDATE TUR SET TURAD=? WHERE TURNO=?");
            preparedStatement.setString(1, turadi);
            preparedStatement.setInt(2, turno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Güncelleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }
    }


    public void kitapGüncelle() {

        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("UPDATE KİTAP SET KİTAPAD=? WHERE KİTAPNO=?");
            preparedStatement.setString(1, kitapadi);
            preparedStatement.setInt(2, kitapno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Güncelleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }

    }

    public void vtarihGüncelle() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        String b = dateFormat.format(date);
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("UPDATE İSLEM SET TESLİM=?,VTARİH=? WHERE İSLEMNO=?");
            preparedStatement.setString(1, "Teslim edildi");
            preparedStatement.setString(2, b);
            preparedStatement.setInt(3, islemno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Güncelleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);
        }

    }

    public void turSil() {
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("DELETE FROM TUR WHERE TURNO=?");
            preparedStatement.setInt(1, turno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı silme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);
        }


    }

    public void yazarSil() {
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("DELETE FROM YAZAR WHERE YAZARNO=?");
            preparedStatement.setInt(1, yazarno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı silme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }


    }

    public void kitapSil() {
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("DELETE FROM KİTAP WHERE KİTAPNO=?");
            preparedStatement.setInt(1, kitapno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Silme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }

    }

    public void ogrenciSil() {

        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("DELETE FROM OGRENCİ WHERE OGRNO=?");
            preparedStatement.setInt(1, ogrno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Silme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }

    }

    public void islemSil() {
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("DELETE FROM İSLEM WHERE İSLEMNO=?");
            preparedStatement.setInt(1, islemno);

            preparedStatement.executeUpdate();

            con.close();
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Silme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }
    }

    public void ekle() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        String b = dateFormat.format(date);
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();

            preparedStatement = con.prepareStatement("INSERT INTO İSLEM (İSLEMNO,OGRNO,KİTAPNO,ATARİH) VALUES(?,?,?,?)");
            preparedStatement.setInt(1, islemno);
            preparedStatement.setInt(2, ogrno);
            preparedStatement.setInt(3, kitapno);
            preparedStatement.setString(4, b);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Ekleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }

    }

    public void turekle() {
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("INSERT INTO TUR VALUES(?,?)");
            preparedStatement.setInt(1, turno);
            preparedStatement.setString(2, turadi);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "sdasdada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Ekleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }


    }

    public void ogrenciekle() {
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("INSERT INTO OGRENCİ (OGRNO,OGRAD,OGRSOYAD) VALUES(?,?,?)");
            preparedStatement.setInt(1, ogrno);
            preparedStatement.setString(2, ograd);
            preparedStatement.setString(3, ogrsoyad);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Ekleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }

    }

    public void yazarekle() {

        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("INSERT INTO YAZAR VALUES(?,?,?)");
            preparedStatement.setInt(1, yazarno);
            preparedStatement.setString(2, yazarad);
            preparedStatement.setString(3, yazarsoyad);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "sdasdada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Ekleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }


    }

    public void kitapekle() {
        PreparedStatement preparedStatement = null;
        try {
            Connection con = Baglan.getcon();
            preparedStatement = con.prepareStatement("INSERT INTO KİTAP  VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1, kitapno);
            preparedStatement.setString(2, kitapadi);
            preparedStatement.setInt(3, yazarno);
            preparedStatement.setInt(4, turno);
            preparedStatement.setInt(5, sayfasayisi);
            preparedStatement.setInt(6, puan);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "sdasdada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Ekleme", "Lütfen Tekrar deneyin");

            PrimeFaces.current().dialog().showMessageDynamic(message);

        }


    }


    public int getIslemno() {
        return islemno;
    }

    public int getOgrno() {
        return ogrno;
    }

    public int getKitapno() {
        return kitapno;
    }

    public int getYazarno() {
        return yazarno;
    }

    public int getTurno() {
        return turno;
    }

    public int getSayfasayisi() {
        return sayfasayisi;
    }

    public int getPuan() {
        return puan;
    }

    public String getAtarih() {
        return atarih;
    }

    public String getVtarih() {
        return vtarih;
    }

    public String getOgrad() {
        return ograd;
    }

    public String getOgrsoyad() {
        return ogrsoyad;
    }

    public String getKitapadi() {
        return kitapadi;
    }

    public String getTuradi() {
        return turadi;
    }

    public String getYazarad() {
        return yazarad;
    }

    public String getYazarsoyad() {
        return yazarsoyad;
    }

    public void setIslemno(int islemno) {
        this.islemno = islemno;
    }

    public void setOgrno(int ogrno) {
        this.ogrno = ogrno;
    }

    public void setKitapno(int kitapno) {
        this.kitapno = kitapno;
    }

    public void setYazarno(int yazarno) {
        this.yazarno = yazarno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setSayfasayisi(int sayfasayisi) {
        this.sayfasayisi = sayfasayisi;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public void setAtarih(String atarih) {
        this.atarih = atarih;
    }

    public void setVtarih(String vtarih) {
        this.vtarih = vtarih;
    }

    public void setOgrad(String ograd) {
        this.ograd = ograd;
    }

    public void setOgrsoyad(String ogrsoyad) {
        this.ogrsoyad = ogrsoyad;
    }

    public void setKitapadi(String kitapadi) {
        this.kitapadi = kitapadi;
    }

    public void setTuradi(String turadi) {
        this.turadi = turadi;
    }

    public void setYazarad(String yazarad) {
        this.yazarad = yazarad;
    }

    public void setYazarsoyad(String yazarsoyad) {
        this.yazarsoyad = yazarsoyad;
    }


    public Kutuphanemanaged(int islemno, int ogrno, int kitapno, String atarih, String vtarih) {
        this.islemno = islemno;
        this.ogrno = ogrno;
        this.kitapno = kitapno;
        this.atarih = atarih;
        this.vtarih = vtarih;
    }

    public Kutuphanemanaged(int ogrno, String ograd, String ogrsoyad) {
        this.ogrno = ogrno;
        this.ograd = ograd;
        this.ogrsoyad = ogrsoyad;
    }

    public Kutuphanemanaged(int kitapno, int yazarno, int turno, int sayfasayisi, int puan, String kitapadi) {
        this.kitapno = kitapno;
        this.yazarno = yazarno;
        this.turno = turno;
        this.sayfasayisi = sayfasayisi;
        this.puan = puan;
        this.kitapadi = kitapadi;
    }

    public Kutuphanemanaged(String yazarad, String yazarsoyad, int yazarno) {
        this.yazarno = yazarno;
        this.yazarsoyad = yazarsoyad;
        this.yazarad = yazarad;
    }


}
