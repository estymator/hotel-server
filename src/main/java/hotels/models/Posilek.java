package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posilek {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer idPosilku;
    Integer idMenu;
    String nazwa;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public Integer getIdPosilku() {
        return idPosilku;
    }

    public void setIdPosilku(Integer idPosilku) {
        this.idPosilku = idPosilku;
    }
}
