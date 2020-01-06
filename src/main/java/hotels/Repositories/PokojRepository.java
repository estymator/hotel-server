package hotels.Repositories;

import hotels.models.Pokoj;
import hotels.models.Rezerwacja;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
public interface PokojRepository extends CrudRepository<Pokoj, Integer> {



    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Pokoj p set p.iloscOsob=:io, p.standart=:standart, p.cena=:cena where p.idPokoju=:ip")
    Integer updatePokoj(@Param("ip") Integer idPokoju, @Param("io") Integer ilosc_osob, @Param("standart") String standart, @Param("cena") Integer cena);

    @Query("Select r from Rezerwacja r where r.dataRozpoczecia <= :d1 and r.dataZakonczenia >= :d1 or r.dataRozpoczecia <= :d2 and r.dataZakonczenia >= :d2 or r.dataRozpoczecia >= :d1 and r.dataZakonczenia <= :d2 and r.idPokoju=:id")
    Iterable<Rezerwacja> checkAvailable(@Param("id") Integer id, @Param("d1") LocalDate d1, @Param("d2") LocalDate d2);


    Iterable<Pokoj> findByIdHoteluAndIloscOsobAndStandartAndCenaGreaterThanAndCenaLessThan(Integer idHotelu, Integer iloscOsob, String standart, Integer cena_min, Integer cena_max);
}
