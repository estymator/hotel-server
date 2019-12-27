package hotels.Repositories;


import hotels.models.Wydarzenie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WydarzenieRepository extends CrudRepository<Wydarzenie, Integer> {

    @Query("Select w from Wydarzenie w join PersonelWydarzeniePokoj pwp on pwp.idWydarzenia=w.idWydarzenia where pwp.idPokoju= :idP")
    Iterable<Wydarzenie> getEventByIdPokoju(@Param("idP") Integer IdPokoju);

    @Query("Select w from Wydarzenie w join PersonelWydarzeniePokoj pwp on pwp.idWydarzenia=w.idWydarzenia where pwp.idPersonelu= :idP")
    Iterable<Wydarzenie> getEventByIdPersonelu(@Param("idP") Integer IdPersonelu);
}