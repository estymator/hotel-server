package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Wydarzenie {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer idWydarzenia;
    String tresc;
    String tytul;


    String kolor;
    LocalDate startWydarzenia, koniecWydarzenia;


    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public void setIdWydarzenia(Integer idWydarzenia) {
        this.idWydarzenia = idWydarzenia;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Integer getIdWydarzenia()
    {
        return idWydarzenia;
    }

    public LocalDate getStartWydarzenia() {
        return startWydarzenia;
    }

    public void setStartWydarzenia(LocalDate startWydarzenia) {
        this.startWydarzenia = startWydarzenia;
    }

    public LocalDate getKoniecWydarzenia() {
        return koniecWydarzenia;
    }

    public void setKoniecWydarzenia(LocalDate koniecWydarzenia) {
        this.koniecWydarzenia = koniecWydarzenia;
    }
}
