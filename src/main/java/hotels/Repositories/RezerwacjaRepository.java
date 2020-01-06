package hotels.Repositories;

import hotels.models.Rezerwacja;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface RezerwacjaRepository extends CrudRepository<Rezerwacja, Integer> {

    Iterable<Rezerwacja> findRezerwacjaByIdPokoju(Integer idPokoju);
    Iterable<Rezerwacja> findRezerwacjaByIdKlienta(Integer idKlienta);
    Iterable<Rezerwacja> findRezerwacjaByIdKlientaAndIdPokoju(Integer idKlienta, Integer idPokoju);

    @Transactional
    Integer deleteByIdKlientaAndIdPokoju(Integer idKlienta, Integer idPokoju);
}
