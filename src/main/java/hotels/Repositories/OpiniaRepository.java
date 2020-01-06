package hotels.Repositories;


import hotels.models.Opinia;
import org.springframework.data.repository.CrudRepository;

public interface OpiniaRepository extends CrudRepository<Opinia, Integer> {
    Iterable<Opinia> findByIdHotelu(Integer id);
}