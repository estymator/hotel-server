package hotels.Repositories;

import hotels.models.Personel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PersonelRepository extends CrudRepository<Personel, Integer> {

    Iterable<Personel> findByidHotelu(Integer id_hotelu);
}
