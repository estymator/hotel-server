package hotels.Repositories;

import hotels.models.Personel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface PersonelRepository extends CrudRepository<Personel, Integer> {

    Iterable<Personel> findByIdHotelu(Integer idHotelu);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Personel p set p.imie=:imie, p.nazwisko=:nazwisko, p.adresMail=:adres_mail, p.nr_telefonu=:nr_telefonu, p.pensja=:pensja, p.idHotelu=:id_hotelu where p.id_personelu=:id")
    Integer updatePersonel(@Param("id") Integer id_personelu,@Param("imie") String imie,@Param("nazwisko") String nazwisko,@Param("adres_mail") String adres_mail,@Param("nr_telefonu") String nr_telefonu,@Param("pensja") String pensja,@Param("id_hotelu") Integer id_hotelu);
}
