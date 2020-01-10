package hotels.Repositories;


import hotels.models.Posilek;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
@Transactional
public interface PosilekRepository extends CrudRepository<Posilek, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Posilek p set p.idMenu=:idMenu, p.nazwa=:nazwa where p.idPosilku=:id")
    Integer updateMeal(@Param("id") Integer id_posilku,@Param("idMenu") Integer id_menu,@Param("nazwa") String nazwa);

    Iterable<Posilek> findByIdMenu(Integer id_menu);

    @Transactional
    Integer deleteByNazwa(String nazwa);

}