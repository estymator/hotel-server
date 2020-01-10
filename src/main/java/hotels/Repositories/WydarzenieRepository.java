package hotels.Repositories;


import hotels.models.Wydarzenie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface WydarzenieRepository extends CrudRepository<Wydarzenie, Integer> {

    @Query("Select w from Wydarzenie w join PersonelWydarzeniePokoj pwp on pwp.idWydarzenia=w.idWydarzenia where pwp.idPokoju= :idP")
    Iterable<Wydarzenie> getEventByIdPokoju(@Param("idP") Integer IdPokoju);

    @Query("Select w from Wydarzenie w join PersonelWydarzeniePokoj pwp on pwp.idWydarzenia=w.idWydarzenia where pwp.idPersonelu= :idP")
    Iterable<Wydarzenie> getEventByIdPersonelu(@Param("idP") Integer IdPersonelu);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Wydarzenie w set w.dataWydarzenia=:data, w.godzinaWydarzenia=:godzina, w.typ=:typ where w.idWydarzenia=:id")
    Integer updateWydarzenie(@Param("id") Integer id_wydarzenia,@Param("data") String data_wydarzenia,@Param("godzina") String godzina_wydarzenia,@Param("typ") String typ);
}