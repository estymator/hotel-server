package hotels.Repositories;

import hotels.models.Rezerwacja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface RezerwacjaRepository extends CrudRepository<Rezerwacja, Integer> {

    Iterable<Rezerwacja> findRezerwacjaByIdPokoju(Integer idPokoju);
    Iterable<Rezerwacja> findRezerwacjaByIdKlienta(Integer idKlienta);
    Iterable<Rezerwacja> findRezerwacjaByIdKlientaAndIdPokoju(Integer idKlienta, Integer idPokoju);

    @Query("SELECT r FROM Rezerwacja r join Pokoj p on p.idPokoju=r.idPokoju WHERE p.idHotelu=:id ")
    Iterable<Rezerwacja> findRezerwacjaByIdHotelu(@Param("id") Integer id);

    @Transactional
    Integer deleteByIdKlientaAndIdPokoju(Integer idKlienta, Integer idPokoju);
}
