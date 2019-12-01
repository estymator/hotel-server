package hotels.Repositories;

import hotels.models.Klient;
import hotels.models.Personel;
import org.springframework.data.repository.CrudRepository;

public interface KlientRepository extends CrudRepository<Klient, Integer> {
    Iterable<Klient> findBylogin(String login);
}
