package hotels.models;
import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHotelu;
    private String nazwa;
    private String adres;
    private String nr_telefonu;
    private String adres_mail;
    private String zdjecie;

    public Integer getIdHotelu() {
        return idHotelu;
    }

    public void setIdHotelu(Integer idHotelu) {
        this.idHotelu = idHotelu;
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

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


}
