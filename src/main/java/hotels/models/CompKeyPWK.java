package hotels.models;


import java.io.Serializable;
import java.util.Objects;

/**
 * Klasa stworzona na potrzeby klucza glownego klasy PersonelWydarzeniePokoj
 */
public class CompKeyPWK implements Serializable {
    private Integer idPersonelu, idPokoju, idWydarzenia;



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompKeyPWK that = (CompKeyPWK) o;
        return getIdPersonelu().equals(that.getIdPersonelu()) &&
                getIdPokoju().equals(that.getIdPokoju()) &&
                getIdWydarzenia().equals(that.getIdWydarzenia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPersonelu(), getIdPokoju(), getIdWydarzenia());
    }
}
