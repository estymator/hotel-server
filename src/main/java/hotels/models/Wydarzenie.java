package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wydarzenie {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer idWydarzenia;
    String dataWydarzenia, godzinaWydarzenia, typ;

    public String getDataWydarzenia() {
        return dataWydarzenia;
    }

    public void setDataWydarzenia(String dataWydarzenia) {
        this.dataWydarzenia = dataWydarzenia;
    }

    public String getGodzinaWydarzenia() {
        return godzinaWydarzenia;
    }

    public void setGodzinaWydarzenia(String godzinaWydarzenia) {
        this.godzinaWydarzenia = godzinaWydarzenia;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getIdWydarzenia()
    {
        return idWydarzenia;
    }
}
