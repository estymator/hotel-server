package hotels.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompKeyPWK.class)
public class PersonelWydarzeniePokoj {
    @Id
    Integer idPersonelu, idPokoju, idWydarzenia;

    public Integer getIdPersonelu() {
        return idPersonelu;
    }

    public void setIdPersonelu(Integer idPersonelu) {
        this.idPersonelu = idPersonelu;
    }

    public Integer getIdPokoju() {
        return idPokoju;
    }

    public void setIdPokoju(Integer idPokoju) {
        this.idPokoju = idPokoju;
    }

    public Integer getIdWydarzenia() {
        return idWydarzenia;
    }

    public void setIdWydarzenia(Integer idWydarzenia) {
        this.idWydarzenia = idWydarzenia;
    }
}
