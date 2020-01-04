package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokoj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPokoju;

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    private Integer iloscOsob, idHotelu, cena;
    private String standart,status;

    public Integer getId_pokoju() {
        return idPokoju;
    }

    public void setId_pokoju(Integer id_pokoju) {
        this.idPokoju = id_pokoju;
    }

    public Integer getIloscOsob() {
        return iloscOsob;
    }

    public void setIloscOsob(Integer iloscOsob) {
        this.iloscOsob = iloscOsob;
    }

    public Integer getIdHotelu() {
        return idHotelu;
    }

    public void setIdHotelu(Integer idHotelu) {
        this.idHotelu = idHotelu;
    }

    public String getStandart() {
        return standart;
    }

    public void setStandart(String standart) {
        this.standart = standart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
