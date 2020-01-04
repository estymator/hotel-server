package hotels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

@Entity
public class Test {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer id;
    LocalDate dataPierwsza, dataDruga;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataPierwsza() {
        return dataPierwsza;
    }

    public void setDataPierwsza(LocalDate dataPierwsza) {
        this.dataPierwsza = dataPierwsza;
    }

    public LocalDate getDataDruga() {
        return dataDruga;
    }

    public void setDataDruga(LocalDate dataDruga) {
        this.dataDruga = dataDruga;
    }
}
