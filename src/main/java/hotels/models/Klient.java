package hotels.models;
import javax.persistence.*;

@Entity
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idKlienta;
    private String imie, nazwisko,adres_mail, login, nr_telefonu, typ="klient";

    public Integer getIdKlienta() {
        return idKlienta;
    }


    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
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

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }
}
