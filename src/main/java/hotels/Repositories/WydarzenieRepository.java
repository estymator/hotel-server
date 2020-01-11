package hotels.Repositories;


import hotels.models.Wydarzenie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
public interface WydarzenieRepository extends CrudRepository<Wydarzenie, Integer> {

    @Query("Select w from Wydarzenie w join PersonelWydarzeniePokoj pwp on pwp.idWydarzenia=w.idWydarzenia where pwp.idPokoju= :idP")
    Iterable<Wydarzenie> getEventByIdPokoju(@Param("idP") Integer IdPokoju);

    @Query("Select w from Wydarzenie w join PersonelWydarzeniePokoj pwp on pwp.idWydarzenia=w.idWydarzenia where pwp.idPersonelu= :idP")
    Iterable<Wydarzenie> getEventByIdPersonelu(@Param("idP") Integer IdPersonelu);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Wydarzenie w set w.startWydarzenia=:start, w.koniecWydarzenia=:koniec, w.tytul=:tytul, w.tresc=:tresc where w.idWydarzenia=:id")
    Integer updateWydarzenie(@Param("id") Integer id_wydarzenia, @Param("start") LocalDate start_wydarzenia, @Param("koniec") LocalDate koniec_wydarzenia, @Param("tytul") String tytul, @Param("tresc") String tresc);
}