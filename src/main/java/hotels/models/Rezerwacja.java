package hotels.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(CompKeyReservation.class)
public class Rezerwacja {
    @Id
    private Integer idPokoju, idKlienta;
    private String Rodzaj, Stan;
    private LocalDate  dataRozpoczecia, dataZakonczenia;



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

    public LocalDate getdataRozpoczęcia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczęcia(LocalDate dataRozpoczęcia) {
        this.dataRozpoczecia = dataRozpoczęcia;
    }

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

}
