package hotels.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opinia {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer idOpinii;

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

    public String getDataWystawnienia() {
        return dataWystawnienia;
    }

    public void setDataWystawnienia(String dataWystawnienia) {
        this.dataWystawnienia = dataWystawnienia;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    Integer idHotelu, gwiazdki;
    String dataWystawnienia, tresc;
}
