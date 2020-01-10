package hotels.Repositories;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface HotelRepository extends CrudRepository<hotels.models.Hotel, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Hotel h set h.nazwa=:nazwa, h.adres=:adres, h.adres_mail=:adresMail, h.nr_telefonu=:telefon, h.zdjecie=:zdjecie where h.idHotelu=:idHotelu")
    Integer updateHotel(@Param("idHotelu") Integer id_hotelu,@Param("nazwa") String nazwa,@Param("adres") String adres, @Param("adresMail") String adres_mail,@Param("telefon") String nr_telefonu,@Param("zdjecie") String zdjecie);
}
