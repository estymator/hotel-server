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


    Iterable<Pokoj> findByIdHoteluAndIloscOsobAndStandartAndStatus(Integer idHotelu, Integer iloscOsob, String standart, String status);
    Iterable<Pokoj> findByStatus(String status);
}
