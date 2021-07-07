
import Bilgiçek.Baglan;
import Util.Util2;
import Util.Util1;
import Util.Util;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.primefaces.PrimeFaces;

@ManagedBean(name = "login")

@RequestScoped
@SessionScoped
public class LoginBean implements Serializable {


    private String usernamead;
    private String usernamesoyad;
    private String usernamemusteri;
    private String passwordmusteri;
    private String username;
    private String password;
    private String newsifre;
    private String adminad;
    private String adminsifre;
    private int ogrno;
    static boolean loggedIn = true;

    public String getAdminad() {
        return adminad;
    }

    public void setAdminad(String adminad) {
        this.adminad = adminad;
    }

    public String getAdminsifre() {
        return adminsifre;
    }

    public void setAdminsifre(String adminsifre) {
        this.adminsifre = adminsifre;
    }


    public String getNewsifre() {
        return newsifre;
    }

    public void setNewsifre(String newsifre) {
        this.newsifre = newsifre;
    }

    public String getUsernamead() {
        return usernamead;
    }

    public void setUsernamead(String usernamead) {
        this.usernamead = usernamead;
    }

    public String getUsernamesoyad() {
        return usernamesoyad;
    }

    public void setUsernamesoyad(String usernamesoyad) {
        this.usernamesoyad = usernamesoyad;
    }


    public int getOgrno() {
        return ogrno;
    }

    public void setOgrno(int ogrno) {
        this.ogrno = ogrno;
    }


    public String getUsernamemusteri() {
        return usernamemusteri;
    }

    public void setUsernamemusteri(String usernamemusteri) {
        this.usernamemusteri = usernamemusteri;
    }

    public String getPasswordmusteri() {
        return passwordmusteri;
    }

    public void setPasswordmusteri(String passwordmusteri) {
        this.passwordmusteri = passwordmusteri;
    }

    public void admincikis() {
        HttpSession hs = Util.getSession();
        hs.setAttribute("username", null);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {

        }

    }

    public void kullanicicikis() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {

        }

    }

    public void ogrencicikis() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("misafirindex.xhtml");
        } catch (Exception e) {

        }

    }

    String adres = null;

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }


    public void yapp() {

        adres = "admin/adminindex.xhtml";
    }

    public LoginBean() {
    }

    public String karsilastiradmin() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("Test", usernamemusteri, null);
        try {
            con = Baglan.getconadmin();
            preparedStatement = con.prepareStatement("select SİFRE from ADMİN where ADMİN_AD=?");
            preparedStatement.setString(1, adminad);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                if (resultSet.getString("SİFRE").equals(adminsifre)) {
                    HttpSession hs = Util.getSession();
                    hs.setAttribute("username", adminad);
                    //FacesContext.getCurrentInstance().getExternalContext().redirect("admin/adminindex.xhtml");


                    return "admin/adminindex.xhtml";

                } else
                    loggedIn = false;


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
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Giriş", "Lütfen Tekrar deneyin");

        PrimeFaces.current().dialog().showMessageDynamic(message);
        return "";


    }


    public void adminŞifreDeğiştir() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            con = Baglan.getconadmin();
            preparedStatement = con.prepareStatement("UPDATE ADMİN SET SİFRE=?");


            preparedStatement.setString(1, password);
            resultSet = preparedStatement.executeQuery();


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

    }


    public void kullanıcıGüncelleme() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CallableStatement cStmt = null;

        try {
            con = Baglan.getconadmin();


            cStmt = con.prepareCall("{call KULLANICI_DEGISTIR(?,?)}");

            cStmt.setString(1, usernamemusteri);
            cStmt.setString(2, passwordmusteri);

            cStmt.execute();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                cStmt.close();
                con.close();
                preparedStatement.close();

            } catch (Exception e) {
                System.err.println("Hata Meydana Geldi. Hata:" + e);
            }
        }

    }


    public void kullanıcıSil() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CallableStatement cStmt = null;

        try {
            con = Baglan.getconadmin();


            cStmt = con.prepareCall("{call KULLANICI_SIL(?)}");

            cStmt.setString(1, usernamemusteri);

            cStmt.execute();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                cStmt.close();
                con.close();
                preparedStatement.close();

            } catch (Exception e) {
                System.err.println("Hata Meydana Geldi. Hata:" + e);
            }
        }


    }


    public void kullanıcıEkle() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CallableStatement cStmt = null;

        try {
            con = Baglan.getconadmin();


            cStmt = con.prepareCall("{call KULLANICI_EKLE(?,?,?,?,?)}");

            cStmt.setString(1, usernamemusteri);
            cStmt.setString(2, passwordmusteri);
            cStmt.setString(3, usernamead);
            cStmt.setString(4, usernamesoyad);
            cStmt.setString(5, "kullanıcı");
            cStmt.execute();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                cStmt.close();
                con.close();
                preparedStatement.close();

            } catch (Exception e) {
                System.err.println("Hata Meydana Geldi. Hata:" + e);
            }
        }


    }

    public void musterisifredegis() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        JOptionPane.showMessageDialog(null, usernamemusteri);
        JOptionPane.showMessageDialog(null, newsifre);
        JOptionPane.showMessageDialog(null, passwordmusteri);
        try {
            con = Baglan.getconmusteri();
            preparedStatement = con.prepareStatement("UPDATE GİRİS SET SIFRE=? WHERE KULLANICIAD=? AND SIFRE=?");
            preparedStatement.setString(1, newsifre);
            preparedStatement.setString(2, usernamemusteri);
            preparedStatement.setString(3, passwordmusteri);
            resultSet = preparedStatement.executeQuery();


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


    }


    public void kayitmusteri() {

        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        JOptionPane.showMessageDialog(null, usernamemusteri);
        try {
            con = Baglan.getconmusteri();
            preparedStatement = con.prepareStatement("INSERT INTO  GİRİS VALUES(?,?,?)");
            preparedStatement.setString(1, usernamemusteri);
            preparedStatement.setInt(2, ogrno);
            preparedStatement.setString(3, passwordmusteri);
            resultSet = preparedStatement.executeQuery();


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

    }

    public void yap() {

        HttpSession hs = Util.getSession();
        hs.setAttribute("username", null);
    }

    public String karsilastirmusteri() {


        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("Test", usernamemusteri, null);
        try {
            con = Baglan.getconmusteri();
            preparedStatement = con.prepareStatement("select SIFRE from GİRİS  WHERE KULLANICIAD=?");
            preparedStatement.setString(1, usernamemusteri);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                if (resultSet.getString("SIFRE").equals(passwordmusteri)) {
                    HttpSession hs = Util2.getSession();
                    hs.setAttribute("username2", username);
                    return "indexogrenci.xhtml?faces-redirect=true";

                } else
                    loggedIn = false;


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
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Giriş", "Lütfen Tekrar deneyin");

        PrimeFaces.current().dialog().showMessageDynamic(message);

        return "";
    }


    public String karsilastir() {


        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            con = Baglan.getcon();
            preparedStatement = con.prepareStatement("select PASSWORD from LOGİN  WHERE USERNAME=?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                if (resultSet.getString("PASSWORD").equals(password)) {
                    HttpSession hs = Util1.getSession();
                    hs.setAttribute("username1", username);
                    return "kullaniciindex.xhtml";

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
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hatalı Giriş", "Lütfen Tekrar deneyin");

        PrimeFaces.current().dialog().showMessageDynamic(message);

        return "";
    }

    public String validateUserLogin() {


        return "success";
    }

    public String doLogin() {
        // Veri tabanından veri çekme işlemi olarak düşünelim


        if (loggedIn = true) {

            // return navigationBean.redirectToWelcome();
            return "secured/deneme.xhtml";

        }



        return "";

    }

    public String doLogout() {
        //Oturum kapandığını bildiriyoruz.
        loggedIn = false;

        // Çıkış mesajı veriyoruz.
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "";
    }

    // ------------------------------
    // Getters & Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


}
