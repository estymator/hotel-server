package hotels.models;
import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_hotelu;
    private String nazwa, adres,nr_telefonu, adres_mail;
    private Integer id_administratora;

    public Integer getId() {
        return id_hotelu;
    }



    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getAdres_mail() {
        return adres_mail;
    }

    public void setAdres_mail(String adres_mail) {
        this.adres_mail = adres_mail;
    }

    public Integer getId_admina() {
        return id_administratora;
    }

    public void setId_admina(Integer id_admina) {
        this.id_administratora = id_admina;
    }
}
