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

    Integer idHotelu, gwiazdki;
    String dataWystawienia, tresc;

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
        return dataWystawienia;
    }

    public void setDataWystawienia(String dataWystawnienia) {
        this.dataWystawienia = dataWystawnienia;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }


}
