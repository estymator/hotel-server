package models;
import javax.persistence.*;

@Entity
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String imie, nazwisko,adres_mail, login, phone_number;

    public Integer getId() {
        return id;
    }



    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres_mail() {
        return adres_mail;
    }

    public void setAdres_mail(String adres_mail) {
        this.adres_mail = adres_mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
