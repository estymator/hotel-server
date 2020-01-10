package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Menu {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer idMenu;
    Integer idHotelu;

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdHotelu() {
        return idHotelu;
    }

    public void setIdHotelu(Integer idHotelu) {
        this.idHotelu = idHotelu;
    }


}
