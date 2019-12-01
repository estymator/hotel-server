package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rezerwacja {
    @Id
    private String idPokoju;
    private String idKlienta, Rodzaj, Stan, dataRozpoczecia, dataZakonczenia;

    public String getIdPokoju() {
        return idPokoju;
    }

    public void setIdPokoju(String idPokoju) {
        this.idPokoju = idPokoju;
    }

    public String getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(String idKlienta) {
        this.idKlienta = idKlienta;
    }

    public String getRodzaj() {
        return Rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        Rodzaj = rodzaj;
    }

    public String getStan() {
        return Stan;
    }

    public void setStan(String stan) {
        Stan = stan;
    }

    public String getSataRozpoczęcia() {
        return dataRozpoczecia;
    }

    public void setSataRozpoczęcia(String sataRozpoczęcia) {
        this.dataRozpoczecia = sataRozpoczęcia;
    }

    public String getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(String dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }
}
