package hotels.Repositories;

import hotels.models.Pokoj;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PokojRepository extends CrudRepository<Pokoj, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Pokoj p set p.status='zajety' where p.idPokoju=:ip and p.idHotelu=:ih")
    Integer findPokojByIdPokojuAndIdHotelu(@Param("ip") Integer idPokoju,@Param("ih") Integer idHotelu);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Pokoj p set p.status=:status, p.iloscOsob=:io, p.standart=:standart, p.cena=:cena where p.idPokoju=:ip")
    Integer updatePokoj(@Param("ip") Integer idPokoju, @Param("status") String status , @Param("io") Integer ilosc_osob, @Param("standart") String standart, @Param("cena") Integer cena);


    Iterable<Pokoj> findByIdHoteluAndIloscOsobAndStandartAndStatusAndCenaGreaterThanAndCenaLessThan(Integer idHotelu, Integer iloscOsob, String standart, String status, Integer cena_min, Integer cena_max);
    Iterable<Pokoj> findByStatus(String status);
}
