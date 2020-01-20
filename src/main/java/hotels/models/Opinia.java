package hotels.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Opinia {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer idOpinii;

    Integer idHotelu, gwiazdki;
    String tresc;
    LocalDate dataWystawienia;

    public Integer getIdHotelu() {
        return idHotelu;
    }

    public void setIdHotelu(Integer idHotelu) {
        this.idHotelu = idHotelu;
    }

    public Integer getGwiazdki() {
        return gwiazdki;
    }

    public void setGwiazdki(Integer gwiazdki) {
        this.gwiazdki = gwiazdki;
    }

    public LocalDate getDataWystawnienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(LocalDate dataWystawnienia) {
        this.dataWystawienia = dataWystawnienia;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }


}
