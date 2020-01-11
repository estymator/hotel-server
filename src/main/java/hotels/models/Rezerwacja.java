package hotels.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Rezerwacja {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer idRezerwacji;

    private Integer idPokoju, idKlienta;
    private String Rodzaj, Stan;
    private LocalDate  dataRozpoczecia, dataZakonczenia;

    public Integer getIdRezerwacji() {
        return idRezerwacji;
    }

    public void setIdRezerwacji(Integer idRezerwacji) {
        this.idRezerwacji = idRezerwacji;
    }

    public LocalDate getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(LocalDate dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

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


    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

}
