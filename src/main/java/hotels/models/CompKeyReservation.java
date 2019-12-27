package hotels.models;

import java.io.Serializable;
import java.util.Objects;

public class CompKeyReservation implements Serializable {
    private Integer idPokoju, idKlienta;



    public Integer getIdPokoju() {
        return idPokoju;
    }

    public void setIdPokoju(Integer idPokoju) {
        this.idPokoju = idPokoju;
    }

    public Integer getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompKeyReservation that = (CompKeyReservation) o;
        return getIdPokoju().equals(that.getIdPokoju()) &&
                getIdKlienta().equals(that.getIdKlienta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPokoju(), getIdKlienta());
    }
}
