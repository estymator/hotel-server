package hotels.models;

import javax.persistence.*;

@Entity
@IdClass(CompKeyReservation.class)
public class Rezerwacja {
    @Id
    private Integer idPokoju, idKlienta;
    private String Rodzaj, Stan, dataRozpoczecia, dataZakonczenia;



    public Integer getIdPokoju() {
        return idPokoju;
    }

    public void setIdPokoju(Integer idPokoju) {
        this.idPokoju = idPokoju;
    }

    public Integer getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Integer idKlienta) {
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

    public String getdataRozpoczęcia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczęcia(String dataRozpoczęcia) {
        this.dataRozpoczecia = dataRozpoczęcia;
    }

    public String getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(String dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

}
